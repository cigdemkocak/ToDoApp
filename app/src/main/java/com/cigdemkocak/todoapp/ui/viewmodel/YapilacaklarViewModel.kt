package com.cigdemkocak.todoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cigdemkocak.todoapp.data.entity.YapilacakIsler
import com.cigdemkocak.todoapp.data.repo.YapilacaklarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class YapilacaklarViewModel @Inject constructor(var yrepo: YapilacaklarRepository) : ViewModel() {
    var yapilacaklarListesi = MutableLiveData<List<YapilacakIsler>>()

    init {
        kisileriYukle()
    }

    fun kisileriYukle(){
        CoroutineScope(Dispatchers.Main).launch{
            yapilacaklarListesi.value = yrepo.yapilacaklariYukle()
        }
    }

    fun ara(aramaKelimesi:String){
        CoroutineScope(Dispatchers.Main).launch{
            yapilacaklarListesi.value = yrepo.ara(aramaKelimesi)
        }
    }

    fun sil(yapilacak_Id:Int){
        CoroutineScope(Dispatchers.Main).launch{
            yrepo.sil(yapilacak_Id)
            kisileriYukle()
        }
    }

}