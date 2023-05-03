package com.jlhg.wizeline.capstoneproject.local.db.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jlhg.wizeline.capstoneproject.remote.model.Gender

@ProvidedTypeConverter
class GenderConverter {
    @TypeConverter
    fun fromList(gender: List<Gender>): String {
        return Gson().toJson(
            gender,
            object: TypeToken<ArrayList<Gender>>(){}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun toList(json: String): List<Gender>{
        return Gson().fromJson<ArrayList<Gender>>(
            json,
            object: TypeToken<ArrayList<Gender>>(){}.type
        ) ?: emptyList()
    }
}