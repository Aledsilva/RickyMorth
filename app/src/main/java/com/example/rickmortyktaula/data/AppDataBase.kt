package com.example.rickmortyktaula.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.example.rickmortyktaula.model.Result

abstract class AppDataBase {

    @Database(
        entities = [Result::class],
        version = 2,
        exportSchema = false
    )
    //@TypeConverters(UsuarioTypeConverter::class)

    abstract class AppDatabase : RoomDatabase() {

        abstract fun accessCharacter(): CharactersDAO

    }

    object DatabaseBuilder {
        private var instance: AppDatabase? = null

        @JvmStatic
        fun getAppDatabase(context: Context) = instance
            ?: build(context)

        private fun build(context: Context): AppDatabase {


            val database = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "database"
            ) .fallbackToDestructiveMigration() // usar para limpar o database q foi modificado,usar durante desenvolvimento evite apelar assim..

            database.allowMainThreadQueries()
            val appDatabase = database.build()
            instance = appDatabase
            return appDatabase
        }
        @JvmStatic
        fun destroyInstance() {
            instance = null
        }
    }
}