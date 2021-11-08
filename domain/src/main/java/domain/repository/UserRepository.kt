package domain.repository

import domain.models.user.UserLocalModel

interface UserRepository {

    suspend fun addUser(user: UserLocalModel)
    suspend fun getUsers(): List<UserLocalModel>
}