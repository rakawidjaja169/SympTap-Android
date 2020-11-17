package com.example.android.symptap

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = arrayOf(Article::class), version = 1)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun dataDao(): ArticleDao

    companion object {

        @Volatile
        private var INSTANCE: ArticleDatabase? = null

        fun getInstance(context: Context): ArticleDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context): ArticleDatabase {
            val PREPOPULATE_DATA = listOf(
                    Article("1", context.getString(R.string.descCorona), context.getString(R.string.causeCorona), context.getString(R.string.sympCorona), context.getString(R.string.preventCorona)),
                    Article("2", "Tes 2", "tes", "tes", "tes"))

            return Room.databaseBuilder(context.applicationContext,
                    ArticleDatabase::class.java, "Article.db")
                    // prepopulate the database after onCreate was called
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            // insert the data on the IO Thread
                            ioThread {
                                getInstance(context).dataDao().insertData(PREPOPULATE_DATA)
                            }
                        }
                    })
                    .build()
        }
    }
}
