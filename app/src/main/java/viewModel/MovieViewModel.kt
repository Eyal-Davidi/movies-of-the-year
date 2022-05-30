package viewModel

import Movie
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import madlevel6task2.ui.repository.MovieRepository

class MovieViewModel(application: Application) : AndroidViewModel(application) {

    //XXXXNEW
    // variable to contain message whenever
    // it gets changed/modified(mutable)
    val message = MutableLiveData<Movie>()
    // function to send message
//    fun sendMessage(text: String) {
    fun sendMessage(movie: Movie) {
        message.value = movie
    }


    private val movieRepository = MovieRepository()

    /**
     * This property points direct to the LiveData in the repository, that value
     * get's updated when user clicks FAB. This happens through the refreshNumber() in this class :)
     */
    //val movies = movieRepository.movie
    val movies = movieRepository.movies


    private val _errorText: MutableLiveData<String> = MutableLiveData()

    /**
     * Expose non MutableLiveData via getter
     * errorText can be observed from Activity for error showing
     * Encapsulation :)
     */
    val errorText: LiveData<String>
        get() = _errorText

    /**
     * The viewModelScope is bound to Dispatchers.Main and will automatically be cancelled when the ViewModel is cleared.
     * Extension method of lifecycle-viewmodel-ktx library
     */

    // XXXXX NEEDED?
//    fun getMostPopularMovies() {
    fun connectMovies(year: String) {
        viewModelScope. launch {
            try {
                //the triviaRepository sets it's own livedata property
                //our own trivia property points to this one
                movieRepository.getMostPopularMovies(year)
            } catch (error: MovieRepository.MovieRefreshError) {
                _errorText.value = error.message
                Log.e("Movie error", error.cause.toString())
            }
        }
    }

    fun connectMovieDetails() {
//    fun connectMovieDetails() {
        viewModelScope. launch {
            try {
                //the triviaRepository sets it's own livedata property
                //our own trivia property points to this one
                movieRepository.getMovieDetails()
            } catch (error: MovieRepository.MovieRefreshError) {
                _errorText.value = error.message
                Log.e("Movie error", error.cause.toString())
            }
        }
    }
}