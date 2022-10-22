package com.cigdemkocak.todoapp.di

import android.content.Context
import androidx.room.Room
import com.cigdemkocak.todoapp.data.datasource.YapilacaklarDataSource
import com.cigdemkocak.todoapp.data.repo.YapilacaklarRepository
import com.cigdemkocak.todoapp.room.Veritabani
import com.cigdemkocak.todoapp.room.YapilacaklarDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYapilacaklarRepository(yds: YapilacaklarDataSource) : YapilacaklarRepository {
        return YapilacaklarRepository(yds)
    }

    @Provides
    @Singleton
    fun provideYapilacaklarDataSource(ydao:YapilacaklarDao): YapilacaklarDataSource {
        return YapilacaklarDataSource(ydao)
    }

    @Provides
    @Singleton
    fun provideYapilacaklarDao(@ApplicationContext context: Context): YapilacaklarDao {
        val vt = Room.databaseBuilder(context, Veritabani::class.java, "todo.sqlite")
            .createFromAsset("todo.sqlite").build()
        return vt.getYapilacaklarDao()
    }

}