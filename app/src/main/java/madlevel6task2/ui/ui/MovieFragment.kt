package madlevel6task2.ui.ui

import Movie
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel6task2.R
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
//    private val viewModel: MovieViewModel by activityViewModels()

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

        moviesAdapter = MoviesAdapter(movies, ::onMoviesClick)
//        moviesAdapter = MoviesAdapter(movies)
        binding.rvMovies.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rvMovies.adapter = moviesAdapter
        binding.rvMovies.setLayoutManager(GridLayoutManager(context, 3))

        //needed?
        binding.btnSubmit.setOnClickListener {
//            viewModel.getMostPopularMovies()
            viewModel.connectMovies()
            observeMovie()
        }
    }

    private fun observeMovie() {
//        binding.etYear

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

    private fun onMoviesClick(movie: Movie) {
//        private fun onMoviesClick() {

//        Snackbar.make(
//            binding.rvMovies,
//            "This movie is: ${movie.original_title}",
//            Snackbar.LENGTH_LONG
//        )
//            .show()
            findNavController().navigate(
                R.id.action_MoviesFragment_to_SelectedMovieFragment
            )

//        viewModel.connectMovieDetails()
//        observeMovie()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}