package com.example.android.symptap

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ArticleDao {

    @Insert
    fun insertData(data: List<Article>)

    @Query("SELECT * FROM article_table WHERE id = :id")
    suspend fun getArticle(id: Int): Article
}