package com.example.rickmortyktaula.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickmortyktaula.model.Character
import com.example.rickmortyktaula.repository.RepositoryRickMorty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    val listMutableCharacter = MutableLiveData<MutableSet<Character>>()
    private val repository = RepositoryRickMorty()

    fun getAllCharacters() = CoroutineScope(IO).launch {
        repository.getCharacterService().let { charactersResponse ->
            listMutableCharacter.postValue(charactersResponse.characters)
            Log.i("TA AI -> ", "PARO NO COROUTINE")
        }
    }

}