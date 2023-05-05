package com.jlhg.wizeline.local.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_genders")
data class GenderEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val idMovie: Int,
)

fun Gender.toGenderEntity(idMovie: Int): GenderEntity {
    return GenderEntity(id, name, idMovie)
}
