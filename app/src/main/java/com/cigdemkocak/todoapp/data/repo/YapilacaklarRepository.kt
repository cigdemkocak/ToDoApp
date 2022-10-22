package com.cigdemkocak.todoapp.data.repo

import com.cigdemkocak.todoapp.data.datasource.YapilacaklarDataSource
import com.cigdemkocak.todoapp.data.entity.YapilacakIsler

class YapilacaklarRepository(var yds:YapilacaklarDataSource) {

    suspend fun kaydet(yapilacak_Is:String) = yds.kaydet(yapilacak_Is)
    suspend fun guncelle(yapilacak_Is_Id:Int,yapilacak_Is:String) = yds.guncelle(yapilacak_Is_Id,yapilacak_Is)
    suspend fun yapilacaklariYukle() :List<YapilacakIsler> = yds.yapilacaklariYukle()
    suspend fun ara(aramaKelimesi:String) :List<YapilacakIsler> = yds.ara(aramaKelimesi)
    suspend fun sil(yapilacak_Id:Int) = yds.sil(yapilacak_Id)

}