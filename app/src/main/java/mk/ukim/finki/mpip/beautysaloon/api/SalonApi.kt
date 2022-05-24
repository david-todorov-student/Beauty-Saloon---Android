package mk.ukim.finki.mpip.beautysaloon.api

import mk.ukim.finki.mpip.beautysaloon.models.Appointment
import mk.ukim.finki.mpip.beautysaloon.models.AppointmentWrapper
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface SalonApi {
    @GET("Appointment/GetAllAppointmentsForDate")
    fun GetAllAppointmentsForDate(@Query("date") date: String): Call<MutableList<Appointment>>

    @GET("Appointment/GetAppointmentDetails")
    fun getAppointmentById(@Query("appointmentId") appointmentIdd: String): Call<Appointment>

    @POST("Appointment/CreateAppointment")
    fun createAppointment(@Body appointment: Appointment): Call<Appointment>

    @POST("Appointment/MarkAppointmentAs")
    fun markAppointmentAs(@Query("appointmentId") appointmentId: Int, @Query("approved") approved: Boolean): Call<Appointment>
}