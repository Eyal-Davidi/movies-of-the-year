package madlevel6task2.ui.adapter

import Movie
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.madlevel6task2.R
import com.example.madlevel6task2.databinding.FragmentSelectedMovieBinding
import com.example.madlevel6task2.databinding.ItemMoviesBinding

class MoviesAdapter(private val movies: List<Movie>, private val onClick: (Movie) -> Unit) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_movies, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(movies[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener { onClick(movies[adapterPosition]) }
        }

        private val binding = ItemMoviesBinding.bind(itemView)

        fun bind(movie: Movie) {
//            Glide.with(context).load(movie.getPosterImage()).into(binding.ivMovies)
            Glide
                .with(context)
                .load(movie.getPosterImage())
//                .placeholder(R.drawable.loading_action)
                .error(R.drawable.error_action)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.ivMovies)
        }
    }
}
