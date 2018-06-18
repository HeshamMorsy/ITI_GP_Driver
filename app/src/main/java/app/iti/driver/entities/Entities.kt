package app.iti.driver.entities

// response of login api
data class LoginResponse( val auth_token:String, val driver: Driver)
// user avatar
data class Avatar(val url: String)
// response of about api
data class AboutResponse(val message: String, val about_us: String)
// response of history api
data class HistoryResponse(val message: String)
// response of terms and conditions api
data class TermsResponse(val message: String)
// driver entity
data class Driver(val status: String, val id: Int, val latitude: Double, val longitude: Double , val name: String,
                  val phone: String, val email: String , val password_digest:String, val vehicle_kind: String,
                  val  created_at: String, val updated_at: String,
                  val device_token: String, val city: String)


/*
{
    "auth_token": "eyJhbGciOiJIUzI1NiJ9.eyJkcml2ZXJfaWQiOjEsImV4cCI6MTUyOTQzMTA2NX0.CS9bOtuCkvsbfK7XbyFizgZHRKHvpE1RdZbKjNacOx8",
    "driver": {
        "status": "online",
        "id": 1,
        "latitude": 31,
        "longitude": 30,
        "name": "Fahd",
        "phone": "01120044177",
        "email": "fahdyousri@gmail.com",
        "password_digest": "123456",
        "vehicle_kind": "vesba",
        "city": "El Beheira Governorate",
        "created_at": "2018-06-17T22:46:12.507Z",
        "updated_at": "2018-06-18T16:46:31.361Z",
        "device_token": "dF-NRvAWrzM:APA91bFgrF_hLoWkZyRhdFcNIAmo7lchi7nHzwbL30gj-_mHoY8pWRI4hNtOjDGt5c1ejNnOS61cDU7pEndimpAsusWNSKrDf_HNG9KvDA6vt5bvkuJaUvkTEveUuqwP_J6NwHzQFYd9"
    }
}
 */