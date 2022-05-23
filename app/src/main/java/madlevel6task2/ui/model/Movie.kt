package madlevel6task2.ui.model

import com.google.gson.annotations.SerializedName


// XXXXX need to change parameters
// level 6 example Tip: You can try using https://www.json2kotlin.com/
// to generate a data class using the raw json response from
// http://numbersapi.com/random/trivia?json
data class Movie(
//    @SerializedName("text") val text: String,
//    @SerializedName("number") val number: Int,
//    @SerializedName("found") val found: Boolean,
//    @SerializedName("type") val type: String

    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,

//    @SerializedName("id") val id : Int,
    @SerializedName("logo_path") val logo_path : String,
//    @SerializedName("name") val name : String,
    @SerializedName("origin_country") val origin_country : String,

    @SerializedName("iso_3166_1") val iso_3166_1 : String,
//    @SerializedName("name") val name : String,

    @SerializedName("english_name") val english_name : String,
    @SerializedName("iso_639_1") val iso_639_1 : String,
//    @SerializedName("name") val name : String

// {
//    fun getImageUrl() = "http://singlecolorimage.com/get/$hex/1080x1080"
//}


)
