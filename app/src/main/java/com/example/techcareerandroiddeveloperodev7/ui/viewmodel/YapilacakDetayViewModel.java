package com.example.techcareerandroiddeveloperodev7.ui.viewmodel;


import androidx.lifecycle.ViewModel;

import com.example.techcareerandroiddeveloperodev7.data.repo.YapilacaklarDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class YapilacakDetayViewModel extends ViewModel {
    public YapilacaklarDaoRepository yrepo;

    @Inject
    public YapilacakDetayViewModel(YapilacaklarDaoRepository yrepo){
        this.yrepo = yrepo;
    }

    public void guncelle(int yapilacak_id,String yapilacak_ad){
        yrepo.guncelle(yapilacak_id,yapilacak_ad);
    }
}
