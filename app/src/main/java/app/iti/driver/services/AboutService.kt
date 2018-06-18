package app.iti.driver.services

import app.iti.driver.entities.AboutResponse
import app.iti.driver.utilities.RetrofitCreation
import io.reactivex.Observable
import retrofit2.http.GET


interface AboutService {
    @GET("about")
    fun getAbout(): Observable<AboutResponse>
}

fun createAboutRequest():AboutService{
    return RetrofitCreation.createRetrofit().create(AboutService::class.java)
}
