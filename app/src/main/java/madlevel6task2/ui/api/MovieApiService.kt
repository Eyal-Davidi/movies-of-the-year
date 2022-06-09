package madlevel6task2.ui.api

import Movie
import android.widget.EditText
import android.widget.FrameLayout
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("3/discover/movie")

     suspend fun getMostPopularMovies(@Query("primary_release_year") year: String,
                                      @Query("api_key") apiKey:String,
                                        ) : Movie
    suspend fun getMovieDetails(
    ) : Movie
}