package mk.ukim.finki.mpip.beautysaloon.models

import java.sql.Time
import java.time.LocalDateTime
import java.util.*

data class Appointment(val clientName: String, val serviceDescription: String, val phoneNumber: String,
                        val email: String, val dateTime: LocalDateTime) {
}