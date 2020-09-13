package com.sbtechnologies.organicfood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        initiate();
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    private void initiate() {


        List<com.sbtechnologies.organicfood.Activity.ProductList> productList = new ArrayList<>();
        List<com.sbtechnologies.organicfood.Activity.ProductSize> productSizes_apple = new ArrayList<>();
        List<com.sbtechnologies.organicfood.Activity.ProductSize> productSizes_mango = new ArrayList<>();
        List<com.sbtechnologies.organicfood.Activity.ProductSize> productSizes_orange = new ArrayList<>();
        List<com.sbtechnologies.organicfood.Activity.ProductSize> productSizes_pomegranate = new ArrayList<>();
        productSizes_apple.add(new com.sbtechnologies.organicfood.Activity.ProductSize("1 Kg","200","10 %","180"));
        productSizes_mango.add(new com.sbtechnologies.organicfood.Activity.ProductSize("1 Kg","200","10 %","180"));
        productSizes_orange.add(new com.sbtechnologies.organicfood.Activity.ProductSize("1 Kg","200","10 %","180"));
        productSizes_pomegranate.add(new com.sbtechnologies.organicfood.Activity.ProductSize("1 Kg","200","10 %","180"));

        productList.add(new com.sbtechnologies.organicfood.Activity.ProductList("Fruits","Fresh",
                "Apple",R.drawable.apple,productSizes_apple));
        productList.add(new com.sbtechnologies.organicfood.Activity.ProductList("Fruits","Fresh",
                "Apple",R.drawable.apple,productSizes_apple));
        productList.add(new com.sbtechnologies.organicfood.Activity.ProductList("Fruits","Fresh",
                "Apple",R.drawable.apple,productSizes_apple));
        productList.add(new com.sbtechnologies.organicfood.Activity.ProductList("Fruits","Fresh",
                "Apple",R.drawable.apple,productSizes_apple));

    }
}