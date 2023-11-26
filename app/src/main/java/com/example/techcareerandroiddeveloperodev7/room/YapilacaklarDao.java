package com.example.techcareerandroiddeveloperodev7.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.techcareerandroiddeveloperodev7.data.entity.Yapilacaklar;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface YapilacaklarDao {
    @Query("SELECT * FROM yapilacaklar")
    Single<List<Yapilacaklar>> yapilacaklariYukle();

    @Insert
    Completable kaydet(Yapilacaklar yapilacak);

    @Update
    Completable guncelle(Yapilacaklar yapilacak);

    @Delete
    Completable sil(Yapilacaklar yapilacak);

    @Query("SELECT * FROM yapilacaklar WHERE yapilacak_ad LIKE '%' ||:aramaKelimesi|| '%'")
    Single<List<Yapilacaklar>> ara(String aramaKelimesi);


}
