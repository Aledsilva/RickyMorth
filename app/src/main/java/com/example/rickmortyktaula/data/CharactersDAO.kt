package com.example.rickmortyktaula.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.rickmortyktaula.model.Character


@Dao
interface CharactersDAO {

    @Query("SELECT * FROM characters")
    suspend fun getAllCharactersRoom() : MutableList<Character>

    @Insert
    suspend fun inserirPersonagem(character: Character)

    @Delete
    suspend fun retirarPersonagem(character: Character)

}