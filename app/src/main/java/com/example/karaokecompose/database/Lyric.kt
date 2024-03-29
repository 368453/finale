package com.example.karaoke.db.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lyrics")
data class Lyric(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val songName: String,
    val songArtist: String,
    val songLyric: String
) {
    override fun toString(): String {
        return "Lyric(id=$id, songName='$songName', songArtist='$songArtist', songLyric='$songLyric')"
    }
}
