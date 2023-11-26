package com.example.techcareerandroiddeveloperodev7.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.techcareerandroiddeveloperodev7.R;
import com.example.techcareerandroiddeveloperodev7.data.entity.Yapilacaklar;
import com.example.techcareerandroiddeveloperodev7.databinding.FragmentYapilacakDetayBinding;
import com.example.techcareerandroiddeveloperodev7.ui.viewmodel.YapilacakDetayViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class YapilacakDetayFragment extends Fragment {
    private FragmentYapilacakDetayBinding binding;
    private YapilacakDetayViewModel viewModel;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentYapilacakDetayBinding.inflate(inflater, container, false);

        YapilacakDetayFragmentArgs bundle = YapilacakDetayFragmentArgs.fromBundle(getArguments());
        Yapilacaklar gelenYapilacak = bundle.getYapilacak();

        binding.editTextYapilacakAd.setText(gelenYapilacak.getYapilacak_ad());

        binding.buttonGuncelle.setOnClickListener(view -> {
            String yapilacak_ad = binding.editTextYapilacakAd.getText().toString();

            viewModel.guncelle(gelenYapilacak.getId(),yapilacak_ad);
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(YapilacakDetayViewModel.class);
    }
}