package app.iti.driver.services

import app.iti.driver.entities.LoginResponse
import app.iti.driver.utilities.RetrofitCreation
import io.reactivex.Observable
import retrofit2.http.POST
import retrofit2.http.QueryMap

interface UpdateLocationService {

    @POST("authentication/drivers/updatelocation")
    fun sendLocation(@QueryMap options:Map<String, String> ) : Observable<LoginResponse>
}

fun createUpdateLocationRequest():UpdateLocationService{
    return RetrofitCreation.createRetrofit().create(UpdateLocationService::class.java)
}
