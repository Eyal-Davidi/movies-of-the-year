package madlevel6task2.ui.ui

import Movie
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
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

    lateinit var sendMovie: Movie

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

        //XXXNEW
        // reference for button and EditText
//        btn = view.findViewById(R.id.button)
//        writeMSg = view.findViewById(R.id.writeMessage)

//        writeMSg = binding.rvMovies.movie.original_title

        // create object of SharedViewModel
//        val model = ViewModelProvider(requireActivity()).get(MovieViewModel::class.java)

        // call function "sendMessage" defined in SharedVieModel
        // to store the value in message.
//        btn.setOnClickListener { model.sendMessage(writeMSg.text.toString()) }


        moviesAdapter = MoviesAdapter(movies, ::onMoviesClick)
        binding.rvMovies.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rvMovies.adapter = moviesAdapter
        binding.rvMovies.setLayoutManager(GridLayoutManager(context, 3))

        binding.btnSubmit.setOnClickListener {

            binding.progressBar.isInvisible = view.isActivated

//            viewModel.getMostPopularMovies()
            viewModel.connectMovies(binding.etYear.text.toString())
//            viewModel.connectMovieDetails()
            observeMovie()
        }
    }

    private fun observeMovie() {
//        binding.etYear

        viewModel.movies.observe(viewLifecycleOwner) {

            movies.clear()
            movies.addAll(it)
            moviesAdapter.notifyDataSetChanged()

            binding.progressBar.visibility = View.INVISIBLE
        }

        // Observe the error message.
        viewModel.errorText.observe(viewLifecycleOwner, {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        })
    }

    private fun observeMovieDetails() {
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

    private fun onMoviesClick(movie : Movie) {

//        Snackbar.make(
//            binding.rvMovies,
//            "This movie is: ${movie.original_title}",
//            Snackbar.LENGTH_LONG
//        )
//            .show()

        ///XXXNEW
//        writeMSg = movie.original_title
        sendMovie = movie

        val model = ViewModelProvider(requireActivity()).get(MovieViewModel::class.java)

//        btn.setOnClickListener { model.sendMessage(writeMSg.text.toString()) }
        model.sendMessage(sendMovie)




//        movie = binding.rvMovies.movie.original_title

            viewModel.connectMovieDetails()
        //observemovie2
            observeMovieDetails()

//        setFragmentResult(REQ_PORTAL_KEY, bundleOf(Pair(BUNDLE_PORTAL_KEY,Portal(portalText, portalUrl))))
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