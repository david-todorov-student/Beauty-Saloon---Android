package mk.ukim.finki.mpip.beautysaloon.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mk.ukim.finki.mpip.beautysaloon.R
import mk.ukim.finki.mpip.beautysaloon.models.Appointment


class BasicRecyclerViewAdapter(val context: Context, val allAppointments: MutableList<Appointment>):
    RecyclerView.Adapter<BasicRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val clientName: TextView
        val dateTime: TextView
        val detailsButton: Button

        init {
            clientName = view.findViewById(R.id.row_clientName)
            dateTime = view.findViewById(R.id.row_dateTime)
            detailsButton = view.findViewById(R.id.button_details)
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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentAppointment: Appointment = allAppointments[position]

        holder.clientName.text = currentAppointment.clientName
        holder.dateTime.text = currentAppointment.dateTime.toString()

    }

    override fun getItemCount(): Int {
        return allAppointments.size
    }
}