package com.cigdemkocak.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.cigdemkocak.todoapp.R
import com.cigdemkocak.todoapp.databinding.FragmentYapilacakDetayBinding
import com.cigdemkocak.todoapp.ui.viewmodel.YapilacakDetayViewModel
import com.cigdemkocak.todoapp.ui.viewmodel.YapilacakKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YapilacakDetayFragment : Fragment() {
    private lateinit var tasarim:FragmentYapilacakDetayBinding
    private lateinit var viewModel: YapilacakDetayViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_yapilacak_detay, container, false)
        tasarim.yapilacakDetayFragment = this

        tasarim.yapilacakDetayToolbarBaslik= "Yapılacak İş Detay"

        val bundle:YapilacakDetayFragmentArgs by navArgs()
        val gelenYapilacakIs = bundle.yapilacakIs

       tasarim.yapilacakIsNesnesi = gelenYapilacakIs


        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: YapilacakDetayViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonGuncelle(yapilacak_Is_Id:Int,yapilacak_Is:String){
        viewModel.guncelle(yapilacak_Is_Id,yapilacak_Is)

    }


}