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
//                                      @Query("page") page: Int,
                                      @Query("api_key") apiKey:String,
//                                      @Query("title") title: String
                                        ) : Movie

//    suspend fun getMovieDetails(@Query("backdrop_image") backdropImage: Int,
//                                 @Query("poster_image") posterImage: Int,
//                                 @Query("title") title: String,
//                                 @Query("release_date") releaseDate: String,
//                                 @Query("rating") rating: Int,
//                                 @Query("overview") overview: String,

    @GET("3/discover/movie")

//        suspend fun getMovieDetails(
//            @Query("rating") rating: Double,
//            @Query("api_key") apiKey:String,) : Movie

    suspend fun getMovieDetails(
//        @Query("primary_release_year") year: String,
//                                     @Query("page") page: Int,
//                                     @Query("api_key") apiKey:String,
//                                      @Query("title") title: String
    ) : Movie
}