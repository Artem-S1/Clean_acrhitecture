package data.repository

import data.db.dao.UsersDao
import data.db.entities.UserEntity
import domain.models.user.UserLocalModel
import domain.repository.UserRepository

class UserRepositoryImpl(private val dao: UsersDao): UserRepository {

    override suspend fun addUser(user: UserLocalModel) {
        dao.saveUser(UserEntity(firstName = user.userFirstName, lastName = user.userLastName))
    }

    override suspend fun getUsers(): List<UserLocalModel> {
        return dao.getUsers().map { it.convertToLocal() }
    }
}