package com.cigdemkocak.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cigdemkocak.todoapp.data.entity.YapilacakIsler

@Database(entities = [YapilacakIsler::class],version = 1)
abstract class Veritabani : RoomDatabase() {
    abstract fun getYapilacaklarDao() : YapilacaklarDao
}