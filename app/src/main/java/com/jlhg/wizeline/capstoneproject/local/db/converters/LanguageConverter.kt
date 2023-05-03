package com.jlhg.wizeline.capstoneproject.local.db.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jlhg.wizeline.capstoneproject.remote.model.Language

@ProvidedTypeConverter
class LanguageConverter {
    @TypeConverter
    fun fromList(language: List<Language>): String {
        return Gson().toJson(
            language,
            object: TypeToken<ArrayList<Language>>(){}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun toList(json: String): List<Language>{
        return Gson().fromJson<ArrayList<Language>>(
            json,
            object: TypeToken<ArrayList<Language>>(){}.type
        ) ?: emptyList()
    }
}