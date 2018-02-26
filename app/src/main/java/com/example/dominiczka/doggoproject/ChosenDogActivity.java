package com.example.dominiczka.doggoproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class ChosenDogActivity extends AppCompatActivity {


    DogAccess dogAccess = new DogAccess();
    Dog chosenDog;
    DogDetailsFragment dogDetailsFragment;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosen_dog);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        dogAccess.initDog(getApplicationContext());

        chosenDog = dogAccess.getChosenDog(score);

        dogDetailsFragment = new DogDetailsFragment();
        bundle = new Bundle();
        bundle.putParcelable("item_selected_key", chosenDog);
        dogDetailsFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.chosen_dog_container, dogDetailsFragment).commit();
    }

}
