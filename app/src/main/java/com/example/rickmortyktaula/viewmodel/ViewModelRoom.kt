package com.example.rickmortyktaula.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import com.example.rickmortyktaula.model.Result
import com.example.rickmortyktaula.repository.RepositoryRickMorty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelRoom : ViewModel() {

    val repository = RepositoryRickMorty()
    val listResult = MutableLiveData<MutableList<Result>>()

    fun inserirItem(context: Context, favorito: Result) = CoroutineScope(Dispatchers.IO).launch {
        repository.inserirItensNaLista(context,favorito)
    }

    fun removerFavorito(context: Context, favorito: Result) = CoroutineScope(Dispatchers.IO).launch {
        repository.removerIntens(context,favorito)
    }

    fun getTimesFavoritos(context: Context) = CoroutineScope(Dispatchers.IO).launch {
        repository.pegarTodaLista(context).let { ListResultado ->
            listResult.postValue(ListResultado)
        }
    }
}