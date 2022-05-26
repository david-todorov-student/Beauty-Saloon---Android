package mk.ukim.finki.mpip.beautysaloon.adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import mk.ukim.finki.mpip.beautysaloon.R
import mk.ukim.finki.mpip.beautysaloon.api.SalonApi
import mk.ukim.finki.mpip.beautysaloon.api.SalonApiClient
import mk.ukim.finki.mpip.beautysaloon.models.Appointment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*


class BasicRecyclerViewAdapter(val context: Context, val allAppointments: MutableList<Appointment>):
    RecyclerView.Adapter<BasicRecyclerViewAdapter.ViewHolder>() {
    private lateinit var salonApiClient: SalonApi

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val clientName: TextView
        val dateTime: TextView
        val phoneNumber: TextView
        val serviceDesc: TextView
        val textEnded: TextView

        val textApproved: TextView
        val textDenied: TextView
        val textWaiting: TextView


        init {
            clientName = view.findViewById(R.id.row_clientName)
            dateTime = view.findViewById(R.id.row_dateTime)
            phoneNumber = view.findViewById(R.id.row_phoneNumber)
            serviceDesc = view.findViewById(R.id.row_serviceDesc)
            textEnded = view.findViewById(R.id.textEnd)

            textApproved = view.findViewById(R.id.textApproved)
            textDenied = view.findViewById(R.id.textDenied)
            textWaiting = view.findViewById(R.id.textWaiting)

        }
    }

//    lateinit var viewHolder: ViewHolder

    override fun getItemViewType(position: Int): Int {
        return R.layout.recycler_view_row
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)

//        viewHolder = ViewHolder(view)
//        return viewHolder
        return ViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentAppointment: Appointment = allAppointments[position]

        holder.clientName.text = currentAppointment.clientName
        holder.dateTime.text = currentAppointment.dateTime.toString()
        holder.phoneNumber.text = currentAppointment.phoneNumber
        holder.serviceDesc.text = currentAppointment.serviceDescription

        holder.textEnded.isVisible = false;
        holder.textWaiting.isVisible = false;
        holder.textDenied.isVisible = false;
        holder.textApproved.isVisible = false;

        if (currentAppointment.statusId == 1){
            holder.textApproved.isVisible = false;
            holder.textDenied.isVisible = false;
            holder.textWaiting.isVisible = true;
        }else if (currentAppointment.statusId == 2){
            holder.textApproved.isVisible = true;
            holder.textDenied.isVisible = false;
            holder.textWaiting.isVisible = false;
        }else if (currentAppointment.statusId == 3){
            holder.textApproved.isVisible = false;
            holder.textDenied.isVisible = true;
            holder.textWaiting.isVisible = false;
        }

        if(LocalDateTime.parse(currentAppointment.dateTime).isBefore(LocalDateTime.now())){
            holder.textApproved.isVisible = false;
            holder.textDenied.isVisible = false;
            holder.textWaiting.isVisible = false;

            holder.textEnded.isVisible = true;
        }

    }



    override fun getItemCount(): Int {
        return allAppointments.size
    }
}