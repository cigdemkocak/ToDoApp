package com.cigdemkocak.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.cigdemkocak.todoapp.R
import com.cigdemkocak.todoapp.databinding.FragmentYapilacakKayitBinding
import com.cigdemkocak.todoapp.ui.viewmodel.YapilacakKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YapilacakKayitFragment : Fragment() {
    private lateinit var tasarim:FragmentYapilacakKayitBinding
    private lateinit var viewModel: YapilacakKayitViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_yapilacak_kayit, container, false)
        tasarim.yapilacakKayitFragment = this
        tasarim.yapilacakKayitToolbarBaslik = "Yapılacak İş Kayıt"

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:YapilacakKayitViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonKaydet(yapilacak_Is:String){
        viewModel.kaydet(yapilacak_Is)
    }


}