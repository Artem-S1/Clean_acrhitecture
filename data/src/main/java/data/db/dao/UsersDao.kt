package data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import data.db.entities.UserEntity

@Dao
interface UsersDao {

    @Query("SELECT * FROM users")
    fun getUsers(): List<UserEntity>

    @Query("SELECT * FROM users WHERE userId = :id")
    fun getUser(id: String): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(user: UserEntity)

    @Query("DELETE FROM users")
    fun clearUsers()
}