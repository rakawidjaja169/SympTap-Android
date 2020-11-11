package com.example.android.symptap

import android.content.Context

class ArticleRepository(private val articleDao: ArticleDao) : ArticleDao by articleDao {
    companion object {

        fun getInstance(context: Context): ArticleRepository {
            val articleDao = ArticleDatabase.getInstance(context).dataDao()

            return ArticleRepository(articleDao)
        }
    }
}