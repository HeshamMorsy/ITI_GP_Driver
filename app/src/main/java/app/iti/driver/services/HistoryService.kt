package app.iti.driver.services

import app.iti.driver.entities.HistoryResponse
import app.iti.driver.utilities.RetrofitCreation
import io.reactivex.Observable
import retrofit2.http.GET


interface HistoryService {
    @GET("")
    fun getHistory(): Observable<HistoryResponse>
}

fun createHistoryRequest():HistoryService{
    return RetrofitCreation.createRetrofit().create(HistoryService::class.java)
}
