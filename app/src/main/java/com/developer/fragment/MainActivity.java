package com.developer.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements BlankFragment1.FragmentAListener,BlankFragment2.FragmentBListener{

    BlankFragment1 fragmentA;
    BlankFragment2 fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentA = new BlankFragment1();
        fragmentB = new BlankFragment2();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_a,fragmentA).replace(R.id.frame_b,fragmentB)
                .commit();


    }

    @Override
    public void onInputASent(CharSequence input) {
        fragmentB.updateChar(input);
    }

    @Override
    public void onInputBSent(CharSequence input) {
        fragmentA.updateChar(input);
    }
}