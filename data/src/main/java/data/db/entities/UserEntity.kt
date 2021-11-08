package data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import domain.models.user.UserLocalModel

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val userId: Int = 0,
    val firstName: String,
    val lastName: String,
) {
    fun convertToLocal(): UserLocalModel = UserLocalModel(firstName, lastName)
}