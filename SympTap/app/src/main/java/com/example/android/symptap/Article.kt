package com.example.android.symptap

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article_table")
data class Article(@PrimaryKey val id: String, val Article: String) {}