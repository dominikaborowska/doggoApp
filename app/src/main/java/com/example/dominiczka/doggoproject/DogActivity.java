package com.example.dominiczka.doggoproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class DogActivity extends AppCompatActivity {

    DogListFragment dogListFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);
        dogListFragment = new DogListFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.dogContainer, dogListFragment).commit();
    }

    public void switchContent(int id, Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment, fragment.toString()).addToBackStack(null).commit();
    }

}
