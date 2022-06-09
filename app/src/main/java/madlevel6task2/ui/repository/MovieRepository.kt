package madlevel6task2.ui.repository

import Movie
import android.provider.Settings.Global.getString
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.madlevel6task2.BuildConfig
import com.example.madlevel6task2.R
import com.example.madlevel6task2.databinding.FragmentMovieBinding
import kotlinx.coroutines.withTimeout
import madlevel6task2.ui.api.MovieApi
import madlevel6task2.ui.api.MovieApiService


class MovieRepository {
    private val movieApiService: MovieApiService = MovieApi.createApi()

    private val _movies: MutableLiveData<List<Movie>> = MutableLiveData()

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!

    /**
     * Expose non MutableLiveData via getter
     * Encapsulation :)
     */
    val movies: LiveData<List<Movie>>
        get() = _movies

    /**
     * suspend function that calls a suspend function from the numbersApi call
     */
    suspend fun getMostPopularMovies(year: String) {
        try {
            //timeout the request after 5 seconds
            val result = withTimeout(5_000) {

                val apiKey = BuildConfig.MY_KEY
                    movieApiService.getMostPopularMovies(year = year, apiKey = apiKey)
                }


            _movies.value = result.results
        } catch (error: Throwable) {
            throw MovieRefreshError("Unable to refresh movie", error)
        }
    }

    suspend fun getMovieDetails(){
        try {
            //timeout the request after 5 seconds
            val result = withTimeout(5_000) {
                movieApiService.getMovieDetails()
            }

            _movies.value = result.results
        } catch (error: Throwable) {
//            throw MovieRefreshError("Unable to refresh movie", error)
        }
    }

    class MovieRefreshError(message: String, cause: Throwable) : Throwable(message, cause)
}