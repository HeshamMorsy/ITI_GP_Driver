package app.iti.driver.services

import app.iti.driver.entities.LoginResponse
import app.iti.driver.utilities.RetrofitCreation
import io.reactivex.Observable
import retrofit2.http.POST
import retrofit2.http.QueryMap

interface LoginService {

    @POST("authentication/signin")
    fun getTokin(@QueryMap options:Map<String, String> ) : Observable<LoginResponse>
}

fun createLoginRequest():LoginService{
    return RetrofitCreation.createRetrofit().create(LoginService::class.java)
}
