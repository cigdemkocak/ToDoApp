package com.cigdemkocak.todoapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.cigdemkocak.todoapp.R
import com.cigdemkocak.todoapp.data.entity.YapilacakIsler
import com.cigdemkocak.todoapp.databinding.CardTasarimBinding
import com.cigdemkocak.todoapp.databinding.FragmentYapilacaklarBinding
import com.cigdemkocak.todoapp.ui.fragment.YapilacaklarFragmentDirections
import com.cigdemkocak.todoapp.ui.viewmodel.YapilacaklarViewModel
import com.cigdemkocak.todoapp.utils.gecisYap
import com.google.android.material.snackbar.Snackbar

class YapilacaklarAdapter(var mContext: Context,
                          var yapilacaklarListesi:List<YapilacakIsler>,
                          var viewModel:YapilacaklarViewModel)
    : RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim:CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_tasarim, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yapilacakIs = yapilacaklarListesi.get(position)
        val t = holder.tasarim
        t.yapilacakIsNesnesi = yapilacakIs
        t.satirCard.setOnClickListener{
            val gecis = YapilacaklarFragmentDirections.yapilacakDetayGecis(yapilacakIs = yapilacakIs)
            Navigation.gecisYap(it,gecis)
        }
        t.imageViewSil.setOnClickListener{
            Snackbar.make(it,"${yapilacakIs.yapilacak_Is} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                    viewModel.sil(yapilacakIs.yapilacak_Is_Id)
                }.show()
        }
    }


    override fun getItemCount(): Int {
        return yapilacaklarListesi.size
    }

}