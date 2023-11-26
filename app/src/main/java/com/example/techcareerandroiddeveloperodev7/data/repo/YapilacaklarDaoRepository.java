package com.example.techcareerandroiddeveloperodev7.data.repo;

import androidx.lifecycle.MutableLiveData;

import com.example.techcareerandroiddeveloperodev7.data.entity.Yapilacaklar;
import com.example.techcareerandroiddeveloperodev7.room.YapilacaklarDao;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class YapilacaklarDaoRepository {

    public MutableLiveData<List<Yapilacaklar>> yapilacaklarListesi = new MutableLiveData<>();

    public YapilacaklarDao ydao;

    public YapilacaklarDaoRepository(YapilacaklarDao ydao) {
        this.ydao = ydao;
    }
    public void kaydet(String yapilacak_ad) {
        Yapilacaklar yeniYapilacak = new Yapilacaklar(0, yapilacak_ad);
        ydao.kaydet(yeniYapilacak).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

        public void guncelle(int id, String yapilacak_ad){
            Yapilacaklar guncellenenYapilacak = new Yapilacaklar(id, yapilacak_ad);
            ydao.guncelle(guncellenenYapilacak).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new CompletableObserver() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onComplete() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }
                    });

        }


        public void ara(String aramaKelimesi){
            ydao.ara(aramaKelimesi).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SingleObserver<List<Yapilacaklar>>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onSuccess(List<Yapilacaklar> yapilacaklars) {
                            yapilacaklarListesi.setValue(yapilacaklars);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }
                    });
        }

        public void sil(int id){
            Yapilacaklar silinenYapilacak = new Yapilacaklar(id,"");
            ydao.sil(silinenYapilacak).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new CompletableObserver() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onComplete() {
                            yapilacaklariYukle();
                        }

                        @Override
                        public void onError(Throwable e) {

                        }
                    });
        }

        public void yapilacaklariYukle(){
            ydao.yapilacaklariYukle().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SingleObserver<List<Yapilacaklar>>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onSuccess(List<Yapilacaklar> yapilacaklars) {
                            yapilacaklarListesi.setValue(yapilacaklars);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }
                    });
        }



    }






