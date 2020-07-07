package com.example.rickmortyktaula.repository

import android.content.Context
import com.example.rickmortyktaula.data.AppDataBase
import com.example.rickmortyktaula.model.CharacterResponse
import com.example.rickmortyktaula.model.Character
import com.example.rickmortyktaula.network.EndPointApi
import com.example.rickmortyktaula.network.RetrofitInit



class RepositoryRickMorty{

    private var url = "https://rickandmortyapi.com/api/"
    private var service = EndPointApi::class
    //private var chave = "asdpoighasiohjgoisahjg"

    private val serviceRick = RetrofitInit(url).create(service)

    private fun initDataBase(context : Context) = AppDataBase.DatabaseBuilder.getAppDatabase(context)

    suspend fun getCharacterService(): CharacterResponse = serviceRick.getResponseCharacter()

    //Insere ao bando de dados
    suspend fun inserirItensNaLista(context: Context, team: Character):
            Unit= initDataBase(context).accessCharacter().inserirPersonagem(team)

    //remove
    suspend fun removerIntens(context: Context, team: Character):
            Unit= initDataBase(context).accessCharacter().retirarPersonagem(team)


    suspend fun pegarTodaLista(context: Context):
            MutableList<Character> = initDataBase(context).accessCharacter().getAllCharactersRoom()
}