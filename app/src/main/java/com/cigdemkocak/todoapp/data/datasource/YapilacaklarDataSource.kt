package com.cigdemkocak.todoapp.data.datasource

import android.util.Log
import com.cigdemkocak.todoapp.data.entity.YapilacakIsler
import com.cigdemkocak.todoapp.room.YapilacaklarDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YapilacaklarDataSource(var ydao:YapilacaklarDao) {

    suspend fun kaydet(yapilacak_Is:String){
        val yeniIs = YapilacakIsler(0,yapilacak_Is)
        ydao.kaydet(yeniIs)
    }

    suspend fun guncelle(yapilacak_Is_Id:Int, yapilacak_Is:String){
        val guncellenenIs = YapilacakIsler(yapilacak_Is_Id,yapilacak_Is)
        ydao.guncelle(guncellenenIs)

    }

    suspend fun yapilacaklariYukle() :List<YapilacakIsler> =
        withContext(Dispatchers.IO){
            ydao.yapilacakIsleriYukle()
        }

    suspend fun ara(aramaKelimesi:String) :List<YapilacakIsler> =
        withContext(Dispatchers.IO){
            ydao.ara(aramaKelimesi)
        }

    suspend fun sil(yapilacak_Is_Id:Int){
        val silinenIs = YapilacakIsler(yapilacak_Is_Id,"")
        ydao.sil(silinenIs)
    }
}