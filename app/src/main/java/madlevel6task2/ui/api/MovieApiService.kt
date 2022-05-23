package madlevel6task2.ui.api

import madlevel6task2.ui.model.Movie
import retrofit2.http.GET


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

    // The GET method needed to retrieve a random number trivia.
//    @GET("/random/trivia?json")
    @GET("/discover/movie?sort_by=popularity.desc")
    suspend fun getRandomNumberTrivia(): Movie
    // suspend fun getBestMoviesOfYear
}