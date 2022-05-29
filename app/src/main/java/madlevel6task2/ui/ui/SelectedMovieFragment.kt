package madlevel6task2.ui.ui

import Movie
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.madlevel6task2.databinding.FragmentSelectedMovieBinding
import viewModel.MovieViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SelectedMovieFragment : Fragment() {

    //XXXNEW
        // to contain and display shared message
//        lateinit var displayMsg: TextView
    lateinit var displayMovie: Movie



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


//        displayMsg = binding.movieTitle
        //YYY
//        displayMsg = movie

        // create object of SharedViewModel
        val model = ViewModelProvider(requireActivity()).get(MovieViewModel::class.java)
        // observing the change in the message declared in SharedViewModel
        model.message.observe(viewLifecycleOwner, Observer {
            // updating data in displayMsg
//            displayMsg.text = it
            displayMovie = it

            binding.movieTitle.text = displayMovie.original_title
            binding.overview.text = displayMovie.overview
            binding.releaseDate.text = displayMovie.release_date
            binding.rating.text = displayMovie.vote_average.toString()

            context?.let { it1 -> Glide.with(it1).load(displayMovie.getPosterImage()).into(binding.ivPosterImage) }

            context?.let { it1 -> Glide.with(it1).load(displayMovie.getBackdropImage()).into(binding.ivBackdropImage) }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}