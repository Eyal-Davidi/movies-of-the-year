package madlevel6task2.ui.repository

import Movie
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.withTimeout
import madlevel6task2.ui.api.MovieApi
import madlevel6task2.ui.api.MovieApiService


class MovieRepository {
    private val movieApiService: MovieApiService = MovieApi.createApi()

    private val _movies: MutableLiveData<List<Movie>> = MutableLiveData()

    /**
     * Expose non MutableLiveData via getter
     * Encapsulation :)
     */
    val movies: LiveData<List<Movie>>
        get() = _movies

    /**
     * suspend function that calls a suspend function from the numbersApi call
     */
    suspend fun getMostPopularMovies() {
        try {
            //timeout the request after 5 seconds
            val result = withTimeout(5_000) {
                movieApiService.getMostPopularMovies(year = 2020, page =2, apiKey = "***REMOVED***")
//                movieApiService.getMostPopularMovies(year, page, apiKey)
            }

//            _movies.value = result
            _movies.value = result.movies
        } catch (error: Throwable) {
            throw MovieRefreshError("Unable to refresh movie", error)
        }
    }

    class MovieRefreshError(message: String, cause: Throwable) : Throwable(message, cause)

//        /**
//         * No data from IO here, just a dummy list with colors
//         * */
//        fun getColorItems(): List<ColorItem> {
//            return arrayListOf(
//                ColorItem("000000", "Black"),
//                ColorItem("FF0000", "Red"),
//                ColorItem("0000FF", "Blue"),
//                ColorItem("FFFF00", "Yellow"),
//                ColorItem("008000", "Green")
//            )
//        }
//    }
}