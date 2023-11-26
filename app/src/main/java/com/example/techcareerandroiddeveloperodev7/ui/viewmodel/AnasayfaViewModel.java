package com.example.techcareerandroiddeveloperodev7.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.techcareerandroiddeveloperodev7.data.entity.Yapilacaklar;
import com.example.techcareerandroiddeveloperodev7.data.repo.YapilacaklarDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaViewModel extends ViewModel {
    public YapilacaklarDaoRepository yrepo;
    public MutableLiveData<List<Yapilacaklar>> yapilacaklarListesi;

    @Inject
    public AnasayfaViewModel(YapilacaklarDaoRepository yrepo){
        this.yrepo = yrepo;
        yapilacaklariYukle();
        yapilacaklarListesi = yrepo.yapilacaklarListesi;
    }

    public void ara(String aramaKelimesi){
        yrepo.ara(aramaKelimesi);
    }

    public void sil(int yapilacak_id){
        yrepo.sil(yapilacak_id);
    }

    public void yapilacaklariYukle(){
        yrepo.yapilacaklariYukle();
    }
}
