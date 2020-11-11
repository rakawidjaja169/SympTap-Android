package com.example.android.symptap

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Article(val id: String, val Article: String) {

    @Entity(tableName = "article_table")
    class Data(@PrimaryKey val id: String, val article: String)

}