package com.example.rickmortyktaula.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "characters")
data class Result(
    val created: String = "",
    val episode: List<String> = mutableListOf(),
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