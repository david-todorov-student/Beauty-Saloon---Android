package mk.ukim.finki.mpip.beautysaloon.api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SalonApiClient {

    companion object {
        private var salonApi: SalonApi? = null

        fun getSalonApi(): SalonApi? {

            if(salonApi == null) {
                salonApi = Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:5000/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(SalonApi::class.java)
            }

            return salonApi
        }
    }

}