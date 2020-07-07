package com.example.rickmortyktaula.view

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModelProviders.*
import com.example.rickmortyktaula.R
import com.example.rickmortyktaula.WebViewAct
import com.example.rickmortyktaula.model.Character
import com.example.rickmortyktaula.view.adapter.AdapterCharacter
import com.example.rickmortyktaula.viewmodel.CharacterViewModel

class MainActivity : AppCompatActivity() {

    private var results = mutableSetOf<Character>()
    private val viewModelCharacter by lazy {
        of(this).get(CharacterViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.recycler_home)


        //como se fosse fidby do viewModel
        //config recycler
        val adapterCharacter = AdapterCharacter(results, this)
        recycler.adapter = adapterCharacter
        val layoutManager =
            GridLayoutManager(this, 2)
        recycler.layoutManager = layoutManager

        viewModelCharacter.getAllCharacters()
        viewModelCharacter.listMutableCharacter.observe(this, Observer {
            it?.let { itChar -> results.addAll(itChar) }
            adapterCharacter.notifyDataSetChanged()
        })
    }
}
