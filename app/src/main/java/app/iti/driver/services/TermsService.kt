package app.iti.driver.services

import app.iti.driver.entities.TermsResponse
import app.iti.driver.utilities.RetrofitCreation
import io.reactivex.Observable
import retrofit2.http.GET


interface TermsService {
    @GET("")
    fun getTerms(): Observable<TermsResponse>
}

fun createTermsRequest():TermsService{
    return RetrofitCreation.createRetrofit().create(TermsService::class.java)
}
