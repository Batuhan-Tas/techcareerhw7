package com.example.techcareerandroiddeveloperodev7.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.techcareerandroiddeveloperodev7.R;
import com.example.techcareerandroiddeveloperodev7.databinding.FragmentYapilacakKayitBinding;
import com.example.techcareerandroiddeveloperodev7.ui.viewmodel.YapilacakKayitViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class YapilacakKayitFragment extends Fragment {

    private FragmentYapilacakKayitBinding binding;
    private YapilacakKayitViewModel viewModel;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentYapilacakKayitBinding.inflate(inflater, container, false);
        binding.buttonKaydet.setOnClickListener(v->{
            String yapilacak_ad = binding.editTextYapilacakAd.getText().toString();

            viewModel.kaydet(yapilacak_ad);
        });



        return binding.getRoot();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(YapilacakKayitViewModel.class);
    }
}