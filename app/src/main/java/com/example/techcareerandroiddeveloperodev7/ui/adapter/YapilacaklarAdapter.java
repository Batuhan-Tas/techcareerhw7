package com.example.techcareerandroiddeveloperodev7.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.techcareerandroiddeveloperodev7.data.entity.Yapilacaklar;
import com.example.techcareerandroiddeveloperodev7.databinding.CardTasarimBinding;
import com.example.techcareerandroiddeveloperodev7.ui.fragment.AnasayfaFragmentDirections;
import com.example.techcareerandroiddeveloperodev7.ui.viewmodel.AnasayfaViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class YapilacaklarAdapter extends RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu> {
    private List<Yapilacaklar> yapilacaklarListesi;
    private Context mContext;

    public AnasayfaViewModel viewModel;

    public YapilacaklarAdapter(List<Yapilacaklar> yapilacaklarListesi, Context mContext, AnasayfaViewModel viewModel) {
        this.yapilacaklarListesi = yapilacaklarListesi;
        this.mContext = mContext;
        this.viewModel = viewModel;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private CardTasarimBinding tasarim;

        public CardTasarimTutucu(CardTasarimBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimBinding binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Yapilacaklar yapilacak = yapilacaklarListesi.get(position);
        CardTasarimBinding t = holder.tasarim;

        t.textViewYapilacakAd.setText(yapilacak.getYapilacak_ad());
        t.textViewYapilacakId.setText(String.valueOf(yapilacak.getId()));

        t.imageViewSil.setOnClickListener(v -> {
            Snackbar.make(v, yapilacak.getYapilacak_ad() + " silinsin mi ?", Snackbar.LENGTH_SHORT)
                    .setAction("EVET", v1 -> {
                        viewModel.sil(yapilacak.getId());
                    })
                    .show();
        });

        t.cardViewSatir.setOnClickListener(v -> {
            AnasayfaFragmentDirections.YapilacakDetayGecis gecis = AnasayfaFragmentDirections.yapilacakDetayGecis(yapilacak);
            Navigation.findNavController(v).navigate(gecis);
        });

    }

    @Override
    public int getItemCount() {
        return yapilacaklarListesi.size();
    }

}


