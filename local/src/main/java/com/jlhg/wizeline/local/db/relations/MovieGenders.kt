package com.jlhg.wizeline.local.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.jlhg.wizeline.local.db.entities.GenderEntity
import com.jlhg.wizeline.local.db.entities.MovieDetailsEntity

data class MovieGenders(
    @Embedded val movieDetailsEntity: MovieDetailsEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "idMovie",
    )
    val genders: List<GenderEntity>,
)
