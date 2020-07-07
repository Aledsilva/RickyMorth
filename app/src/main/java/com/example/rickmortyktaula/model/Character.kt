package com.example.rickmortyktaula.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "characters")
data class Character(
    val created: String = "",
    val gender: String = "",

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "images")
    val image: String = "",

    @ColumnInfo(name = "names")
    val name: String = "",

    val species: String = "",
    val status: String = "",
    val type: String = "",
    val url: String = ""
) : Parcelable