package com.example.techcareerandroiddeveloperodev7.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.techcareerandroiddeveloperodev7.data.repo.YapilacaklarDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class YapilacakKayitViewModel extends ViewModel {

    public YapilacaklarDaoRepository yrepo;

    @Inject
    public YapilacakKayitViewModel(YapilacaklarDaoRepository yrepo){
        this.yrepo = yrepo;
    }

    public void kaydet(String yapilacak_ad){
        yrepo.kaydet(yapilacak_ad);
    }
}
