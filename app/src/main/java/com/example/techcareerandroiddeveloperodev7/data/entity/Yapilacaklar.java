package com.example.techcareerandroiddeveloperodev7.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity(tableName = "yapilacaklar")
public class Yapilacaklar implements Serializable {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    @NonNull
    private int id;


    @ColumnInfo(name="yapilacak_ad")
    @NonNull
    private String yapilacak_ad;

    public Yapilacaklar() {
    }

    public Yapilacaklar(int id, @NonNull String yapilacak_ad) {
        this.id = id;
        this.yapilacak_ad = yapilacak_ad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getYapilacak_ad() {
        return yapilacak_ad;
    }

    public void setYapilacak_ad(@NonNull String yapilacak_ad) {
        this.yapilacak_ad = yapilacak_ad;
    }
}
