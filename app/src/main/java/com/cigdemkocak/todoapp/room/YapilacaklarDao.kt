package com.cigdemkocak.todoapp.room

import androidx.room.*
import com.cigdemkocak.todoapp.data.entity.YapilacakIsler

@Dao
interface YapilacaklarDao {
    @Query("SELECT * FROM yapilacakIsler")
    suspend fun yapilacakIsleriYukle() :List<YapilacakIsler>

    @Insert
    suspend fun kaydet(yapilacakIs:YapilacakIsler)

    @Update
    suspend fun guncelle(yapilacakIs:YapilacakIsler)

    @Delete
    suspend fun sil(yapilacakIs: YapilacakIsler)

    @Query("SELECT * FROM yapilacakIsler WHERE yapilacak_Is like '%' || :aramaKelimesi ||'%' ")
    suspend fun ara(aramaKelimesi:String) :List<YapilacakIsler>

}