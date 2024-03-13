package com.example.supplementseshopmanagmentsystem;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;

import eightbitlab.com.blurview.BlurView;

public class chooseAdd extends Fragment{

    private BlurView blurView;
    private Button addPro;
    private Button addSup;
    private Fragment frag;
    private FrameLayout chooseAdd;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_choose_add, container, false);
        blurView =  view.findViewById(R.id.blurView);
        chooseAdd = (FrameLayout) view.findViewById(R.id.choose_add);
        addPro = view.findViewById(R.id.addProduct);
        addPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().remove(frag).commit();
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new addNewProductFrag()).addToBackStack(null).commit();
            }
        });
        addSup = view.findViewById(R.id.addSupplier);
        addSup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().remove(frag).commit();
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new addNewSupplierFrag()).addToBackStack(null).commit();
            }
        });
        frag = this;

        chooseAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                getParentFragmentManager().beginTransaction().remove(frag).commit();
                return true;
            }
        });
        blurBackground();
        return view;
    }

    public void blurBackground(){

        float radius = 15f;
        Window window = getActivity().getWindow();
        View decorView = window.getDecorView();

        ViewGroup rootView = decorView.findViewById(android.R.id.content);

        Drawable windowsBackground = decorView.getBackground();

        blurView.setupWith(rootView)
                .setFrameClearDrawable(windowsBackground)
                .setBlurRadius(radius)
                .setBlurAutoUpdate(true);
    }

}