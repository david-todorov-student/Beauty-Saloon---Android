package mk.ukim.finki.mpip.beautysaloon

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mk.ukim.finki.mpip.beautysaloon.adapters.BasicRecyclerViewAdapter
import mk.ukim.finki.mpip.beautysaloon.databinding.FragmentAppointmentsListBinding
import mk.ukim.finki.mpip.beautysaloon.models.Appointment

import java.time.LocalDateTime

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AppointmetsListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AppointmentsList : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var recyclerView: RecyclerView

    private var _binding: FragmentAppointmentsListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAppointmentsListBinding.inflate(inflater, container, false)

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = requireView().findViewById(R.id.appointments_recycler_view)
        recyclerView.setHasFixedSize(true);
        recyclerView.layoutManager = LinearLayoutManager(view?.context)
        recyclerView.adapter = view?.context?.let {
            BasicRecyclerViewAdapter(it, initList())
        }

//        recyclerView.getChildViewHolder(recyclerView).detailsButton.setOnClickListener {
//            findNavController().navigate(R.id.action_AppointmentsList_to_AppointmentDetails)
//        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AppointmetsListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AppointmentsList().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initList(): MutableList<Appointment> {
        return mutableListOf(
            Appointment("Dimitar", "pedicure", "070/000-000", "dimitar@email.com", LocalDateTime.now()),
            Appointment("Vlatko", "manicure", "071/111-111", "vlatko@email.com", LocalDateTime.now()),
            Appointment("Stefan", "haircut", "072/222-222", "stefan@email.com", LocalDateTime.now()),
            Appointment("Marko", "botox", "073/333-333", "marko@email.com", LocalDateTime.now())
        )
    }
}