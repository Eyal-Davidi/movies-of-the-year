package madlevel6task2.ui.adapter

import Movie
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.madlevel6task2.R
import com.example.madlevel6task2.databinding.FragmentSelectedMovieBinding
import com.example.madlevel6task2.databinding.ItemMoviesBinding

class MoviesAdapter(private val movies: List<Movie>, private val onClick: (Movie) -> Unit) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
//            LayoutInflater.from(context).inflate(R.layout.item_movies, parent, false)
            LayoutInflater.from(context).inflate(R.layout.item_movies, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(movies[position])

    //    inner class ViewHolder(itemView: View, itemView2: View) : RecyclerView.ViewHolder(itemView) {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener { onClick(movies[adapterPosition]) }
//            itemView2.setOnClickListener { onClick(movies[adapterPosition]) }
        }

        private val binding = ItemMoviesBinding.bind(itemView)

        fun bind(movie: Movie) {
            Glide.with(context).load(movie.getPosterImage()).into(binding.ivMovies)
//            Glide.with(context).load(movie.getPoster()).into(binding.ivPosterImage)
        }

    }

//    private val binding = FragmentSelectedMovieBinding.bind(itemView2)
//
//    fun bind(movie: Movie) {
////        Glide.with(context).load(movie.getPoster()).into(binding.ivMovies)
//        Glide.with(context).load(movie.getPoster()).into(binding.ivPosterImage)
//    }
}
