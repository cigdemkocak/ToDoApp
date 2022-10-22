package com.cigdemkocak.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.cigdemkocak.todoapp.data.repo.YapilacaklarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class YapilacakKayitViewModel @Inject constructor(var yrepo: YapilacaklarRepository) : ViewModel() {

    fun kaydet(yapilacak_Is:String) {
        CoroutineScope(Dispatchers.Main).launch{
            yrepo.kaydet(yapilacak_Is)
        }
    }
}