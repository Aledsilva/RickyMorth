package com.example.rickmortyktaula.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.rickmortyktaula.model.Result


@Dao
interface CharactersDAO {

    @Query("SELECT * FROM characters")
    suspend fun getAllCharactersRoom() : MutableList<Result>

    @Insert
    suspend fun inserirPersonagem(result: Result)

    @Delete
    suspend fun retirarPersonagem(result: Result)

}