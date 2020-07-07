package com.example.rickmortyktaula.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.content.Context
import com.example.rickmortyktaula.model.Character
import com.example.rickmortyktaula.repository.RepositoryRickMorty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelRoom : ViewModel() {

    val repository = RepositoryRickMorty()
    val listResult = MutableLiveData<MutableList<Character>>()

    fun inserirItem(context: Context, favorito: Character) = CoroutineScope(Dispatchers.IO).launch {
        repository.inserirItensNaLista(context,favorito)
    }

    fun removerFavorito(context: Context, favorito: Character) = CoroutineScope(Dispatchers.IO).launch {
        repository.removerIntens(context,favorito)
    }

    fun getTimesFavoritos(context: Context) = CoroutineScope(Dispatchers.IO).launch {
        repository.pegarTodaLista(context).let { ListResultado ->
            listResult.postValue(ListResultado)
        }
    }
}