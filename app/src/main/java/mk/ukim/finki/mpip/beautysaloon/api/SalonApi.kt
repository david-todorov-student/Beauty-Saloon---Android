package mk.ukim.finki.mpip.beautysaloon.api

import mk.ukim.finki.mpip.beautysaloon.models.Appointment
import mk.ukim.finki.mpip.beautysaloon.models.AppointmentWrapper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SalonApi {
    @GET("Appointment/GetAllAppointmentsForDate")
    fun GetAllAppointmentsForDate(@Query("date") date: String): Call<MutableList<Appointment>>

    @GET("Appointment/GetAppointmentDetails")
    fun getPlayListById(@Query("appointmentId") appointmentIdd: String): Call<Appointment>
}