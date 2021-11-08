package data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import data.db.dao.UsersDao
import data.db.entities.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TestDatabase : RoomDatabase() {
    abstract fun usersDao(): UsersDao

    companion object {
        private const val DATABASE_NAME = "testDB.db"
        const val DATABASE_VERSION: Int = 1

        @Volatile
        private var instance: TestDatabase? = null

        fun getInstance(context: Context): TestDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): TestDatabase {
            return Room.databaseBuilder(context, TestDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }
}