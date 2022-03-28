package com.example.kursakademiaandroida.core.database

import androidx.room.TypeConverter
import com.example.kursakademiaandroida.features.characters.data.local.model.CharacterCached

class CharacterConverters {

    companion object {

        private val separator = ","

        @TypeConverter
        @JvmStatic
        fun convertCharacterLocationCachedToString(
            convertItem: CharacterCached.CharacterLocationCached
        ): String {
            val stringBuild = StringBuilder()
            stringBuild.append(convertItem.name).append(separator).append(convertItem.url)
            return stringBuild.toString()
        }

        @TypeConverter
        @JvmStatic
        fun convertCharacterOriginCachedToString(
            convertItem: CharacterCached.CharacterOriginCached
        ): String {
            val stringBuild = StringBuilder()
            stringBuild.append(convertItem.name).append(separator).append(convertItem.url)
            return stringBuild.toString()
        }

        @TypeConverter
        @JvmStatic
        fun convertStringToCharacterLocationCached(string: String): CharacterCached.CharacterLocationCached {
            val (name, url) = string.split(separator)
            return CharacterCached.CharacterLocationCached(name = name, url = url)
        }

        @TypeConverter
        @JvmStatic
        fun convertStringToCharacterOriginCached(string: String): CharacterCached.CharacterOriginCached {
            val (name, url) = string.split(separator)
            return CharacterCached.CharacterOriginCached(name = name, url = url)
        }

    }
}