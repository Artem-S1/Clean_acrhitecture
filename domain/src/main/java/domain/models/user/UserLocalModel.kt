package domain.models.user

data class UserLocalModel(
    val userFirstName: String,
    val userLastName: String
) {
    fun getUserFullName(): String{
        return "$userFirstName $userLastName"
    }
}
