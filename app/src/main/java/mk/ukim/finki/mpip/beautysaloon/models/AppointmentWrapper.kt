package mk.ukim.finki.mpip.beautysaloon.models

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken


class AppointmentWrapper {
    private val appointments
            : List<Appointment>

    init {
        appointments = ArrayList<Appointment>()
    }
}