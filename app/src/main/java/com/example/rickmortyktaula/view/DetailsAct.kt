package com.example.rickmortyktaula.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.rickmortyktaula.R
import com.example.rickmortyktaula.model.Character
import com.example.rickmortyktaula.viewmodel.ViewModelRoom
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*


class DetailsAct : AppCompatActivity() {

    private lateinit var imagePersonagem: ImageView
    private lateinit var namePersonagem: TextView
    private lateinit var resultado : Character
    private lateinit var viewModelRoom : ViewModelRoom
    var context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        viewModelRoom = ViewModelProviders.of(this).get(ViewModelRoom::class.java)
        namePersonagem = findViewById(R.id.text_name)
        imagePersonagem = findViewById(R.id.image_details_comic)

        if (intent != null) {
            resultado = intent.extras?.getParcelable("COMICAO") ?: Character()
            namePersonagem.text = resultado.name

            Picasso.get().load(resultado.image).into(image_details_comic)
        } else {
            Toast.makeText(this,"Ué",Toast.LENGTH_LONG).show()
        }

        image_details_comic.setOnClickListener(View.OnClickListener {
            viewModelRoom.inserirItem(context,resultado)
            Toast.makeText(this,"Lápis da silva!",Toast.LENGTH_LONG).show()
        })
    }
}