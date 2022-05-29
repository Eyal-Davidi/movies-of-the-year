package madlevel6task2.ui.ui

import Movie
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.madlevel6task2.R
import com.example.madlevel6task2.databinding.FragmentSelectedMovieBinding
import madlevel6task2.ui.api.MovieApiService
import viewModel.MovieViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SelectedMovieFragment : Fragment() {

    //XXXNEW
        // to contain and display shared message
        lateinit var displayMsg: TextView



//    private val movies = arrayListOf<Movie>()

//    private lateinit var movie : Movie

    private var _binding: FragmentSelectedMovieBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSelectedMovieBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //XXXNEW
        // reference for the container declared above
//        displayMsg = view.findViewById(R.id.textViewReceiver)
        displayMsg = binding.movieTitle

        // create object of SharedViewModel
        val model = ViewModelProvider(requireActivity()).get(MovieViewModel::class.java)
        // observing the change in the message declared in SharedViewModel
        model.message.observe(viewLifecycleOwner, Observer {
            // updating data in displayMsg
            displayMsg.text = it
        })


//        movie = movie.getMovieDetails(8.3, "***REMOVED***")

//
//        binding.movieTitle.text = movies[0].original_title

//        binding.movieTitle.text = movie.original_title

//        context?.let { Glide.with(it).load(movie.getPoster()).into(binding.ivPosterImage) }
//        Glide.with()

//        binding.btnSubmit.setOnClickListener {
////            viewModel.getMostPopularMovies()
//            viewModel.connectMovies()
//            observeMovie()
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}