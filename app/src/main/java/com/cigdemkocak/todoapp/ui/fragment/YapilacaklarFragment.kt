package com.cigdemkocak.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.cigdemkocak.todoapp.R
import com.cigdemkocak.todoapp.data.entity.YapilacakIsler
import com.cigdemkocak.todoapp.databinding.FragmentYapilacaklarBinding
import com.cigdemkocak.todoapp.ui.adapter.YapilacaklarAdapter
import com.cigdemkocak.todoapp.ui.viewmodel.YapilacakKayitViewModel
import com.cigdemkocak.todoapp.ui.viewmodel.YapilacaklarViewModel
import com.cigdemkocak.todoapp.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YapilacaklarFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var tasarim:FragmentYapilacaklarBinding
    private lateinit var viewModel:YapilacaklarViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_yapilacaklar, container, false)
        tasarim.yapilacaklarFragment = this

        tasarim.yapilacaklarToolbarBaslik = "Yapılacaklar"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarYapilacaklar)

        viewModel.yapilacaklarListesi.observe(viewLifecycleOwner){
            val adapter = YapilacaklarAdapter(requireContext(),it,viewModel)
            tasarim.yapilacaklarAdapter = adapter
        }

        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item = menu.findItem(R.id.action_ara)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@YapilacaklarFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false

            }
        },viewLifecycleOwner,Lifecycle.State.RESUMED)

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: YapilacaklarViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabTikla(view :View){
        Navigation.gecisYap(view,R.id.yapilacakKayitGecis)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.ara(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle()
    }

}