package com.cigdemkocak.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.cigdemkocak.todoapp.data.repo.YapilacaklarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class YapilacakDetayViewModel @Inject constructor(var yrepo: YapilacaklarRepository) : ViewModel() {

    fun guncelle(yapilacak_Is_Id:Int,yapilacak_Is:String){
        CoroutineScope(Dispatchers.Main).launch{
            yrepo.guncelle(yapilacak_Is_Id,yapilacak_Is)
        }
    }
}