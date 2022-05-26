package madlevel6task2.ui.api

import Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


////The only format we support is JSON. If you are using a JavaScript library and need to make requests
//// from another public domain, you can use the callback paramater which will encapsulate the JSON
//// response in a JavaScript function for you.

//find a good json to get best movies
//https://www.json2kotlin.com/results.php

////What is are the best movies from 2010?
////URL: /discover/movie?primary_release_year=2010&sort_by=vote_average.desc

//What are the most popular movies?
//URL: /discover/movie?sort_by=popularity.desc

interface MovieApiService {

//q

    // The GET method needed to retrieve a random number trivia.
//    @GET("/random/trivia?json")
    @GET("3/discover/movie")
//    Call<List<Movie>> getMovies()


//    @GET("movie/550?api_key=***REMOVED***")
//    @GET("https://api.themoviedb.org/3/genre/movie/list?api_key=***REMOVED***&language=en-US")
//    suspend fun getRandomNumberTrivia(): Movie

     suspend fun getMostPopularMovies(@Query("primary_release_year") year:Int,
                                      @Query("page") page:Int,
                                      @Query("api_key") apiKey:String,
                                        ) : Movie

//    suspend fun getMostPopularMovies(@Query("api_key") apiKey:String,
//                                     @Query("poster_path") posterPath:String
//    ) : Movie

//    suspend fun getMostPopularMovies(@Query("api_key") apiKey:String,
//    ) : Movie

//    suspend fun getMostPopularMovies(
//                                     @Query("api_key") apiKey:String,
//    ) : Movie
//    ) : MovieApiService
//    suspend fun getMostPopularMovies(): List<Movie>
//    val movies: List<Movie>?
     ////xxxxxx movies list
}