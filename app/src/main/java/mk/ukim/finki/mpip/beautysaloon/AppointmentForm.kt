package mk.ukim.finki.mpip.beautysaloon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import mk.ukim.finki.mpip.beautysaloon.api.SalonApi
import mk.ukim.finki.mpip.beautysaloon.api.SalonApiClient
import mk.ukim.finki.mpip.beautysaloon.models.Appointment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AppointmentForm.newInstance] factory method to
 * create an instance of this fragment.
 */
class AppointmentForm : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var clientName: String? = null;
    private var serviceDescription: String? = null;
    private var phoneNumber: String? = null;
    private var email: String? = null;
    private var date: String? = null;
    private var time: String? = null;

    private var createBtn : Button? = null;

    private lateinit var salonApiClient: SalonApi

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

        return inflater.inflate(R.layout.fragment_appointment_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnMakeAppointment)
            .setOnClickListener {
                clientName = view.findViewById<EditText>(R.id.etClientName).text.toString()
                serviceDescription = view.findViewById<EditText>(R.id.etServiceDescription).text.toString()
                phoneNumber = view.findViewById<EditText>(R.id.etPhoneNumber).text.toString()
                email = view.findViewById<EditText>(R.id.etEmail).text.toString()
                date = view.findViewById<EditText>(R.id.etDate).text.toString()
                time = view.findViewById<EditText>(R.id.etTime).text.toString()

                var appointment: Appointment = Appointment(clientName!!,
                    serviceDescription!!, phoneNumber!!, email!!,
                    date!! + " " + time!!, 1, null)

                salonApiClient = SalonApiClient.getSalonApi()!!;

                val call: Call<Appointment> = salonApiClient.createAppointment(appointment)

                call.enqueue(object : Callback<Appointment?> {
                    override fun onResponse(call: Call<Appointment?>?, response: Response<Appointment?>) {
                        // this method is called when we get response from our api.
                        findNavController().navigate(R.id.action_AppointmentForm_to_AppointmentCreated)

                    }

                    override fun onFailure(call: Call<Appointment?>?, t: Throwable) {
                        Toast.makeText(activity, t.message, Toast.LENGTH_SHORT)
                            .show()
                    }
                })
            }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AppointmentForm.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AppointmentForm().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}