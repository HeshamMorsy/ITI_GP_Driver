package app.iti.driver.services

import app.iti.driver.entities.LoginResponse
import app.iti.driver.utilities.RetrofitCreation
import io.reactivex.Observable
import retrofit2.http.POST
import retrofit2.http.QueryMap

interface SignOutService {

    @POST("authentication/drivers/signout")
    fun signOut(@QueryMap options:Map<String, String> ) : Observable<LoginResponse>
}

fun createSignOutRequest():SignOutService{
    return RetrofitCreation.createRetrofit().create(SignOutService::class.java)
}
