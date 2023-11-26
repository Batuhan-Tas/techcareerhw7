package com.example.techcareerandroiddeveloperodev7.di;


import android.content.Context;

import androidx.room.Room;

import com.example.techcareerandroiddeveloperodev7.data.repo.YapilacaklarDaoRepository;
import com.example.techcareerandroiddeveloperodev7.room.Veritabani;
import com.example.techcareerandroiddeveloperodev7.room.YapilacaklarDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public YapilacaklarDaoRepository provideYapilacaklarDaoRepository(YapilacaklarDao ydao){
        return new YapilacaklarDaoRepository(ydao);
    }

    @Provides
    @Singleton
    public YapilacaklarDao provideYapilacaklarDao(@ApplicationContext Context context){
        Veritabani vt = Room.databaseBuilder(context, Veritabani.class,"yapilacaklar.sqlite").createFromAsset("yapilacaklar.sqlite").build();
        return vt.getYapilacaklarDao();
    }

}
