package madlevel6task2.ui.ui

import Movie
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel6task2.databinding.FragmentMovieBinding
import com.google.android.material.snackbar.Snackbar
import madlevel6task2.ui.adapter.MoviesAdapter
import viewModel.MovieViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MovieFragment : Fragment() {

    private val movies = arrayListOf<Movie>()
    private lateinit var moviesAdapter: MoviesAdapter

    private val viewModel: MovieViewModel by viewModels()
//private val viewModel: TriviaViewModel by activityViewModels()

    private var _binding: FragmentMovieBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        moviesAdapter = MoviesAdapter(movies, ::onMoviesClick)
        moviesAdapter = MoviesAdapter(movies)
        binding.rvMovies.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rvMovies.adapter = moviesAdapter

        //needed?
        binding.btnSubmit.setOnClickListener {
//            viewModel.getMostPopularMovies()
            viewModel.connectMovies()
            observeMovie()
        }

//        observeMovie()

        }

//    private fun observeMovie() {
//        viewModel.movie.observe(viewLifecycleOwner, {
////            binding.try2.text = it?.text
//            binding.try2.text = it?.name
//        })
//
//        // Observe the error message.
//        viewModel.errorText.observe(viewLifecycleOwner, {
//            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
//        })
//    }

    private fun observeMovie() {
        viewModel.movies.observe(viewLifecycleOwner) {
            movies.clear()
            movies.addAll(it)
            moviesAdapter.notifyDataSetChanged()
        }

        // Observe the error message.
        viewModel.errorText.observe(viewLifecycleOwner, {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        })
    }

//    private fun onColorClick(colorItem: ColorItem) {
//        Snackbar.make(binding.rvColors, "This color is: ${colorItem.name}", Snackbar.LENGTH_LONG)
//            .show()
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}