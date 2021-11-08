package domain.usecase.user

import domain.models.user.UserLocalModel
import domain.repository.UserRepository

class UserUseCase(private val repository: UserRepository) {

    suspend fun addUser(firstName: String, lastName: String){
        repository.addUser(UserLocalModel(firstName, lastName))
    }

    suspend fun getUsers() = repository.getUsers()
}