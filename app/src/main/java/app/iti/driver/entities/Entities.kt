package app.iti.driver.entities

// response of login api
data class LoginResponse(val message: String, val auth_token:String, val user: LoginedUser)
// user login entity
data class LoginedUser(val name: String,val email: String, val phone: String, val avatar: Avatar)
// user avatar
data class Avatar(val url: String)
