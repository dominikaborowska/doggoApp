package com.example.dominiczka.doggoproject;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dominiczka on 10.01.2018.
 */

public class DogAccess {

    List<Dog> dogList = new ArrayList<>();
    DatabaseHandler databaseHandler;


    public int getLength(){return dogList.size();}

    public Dog getChosenDog(int score){
        Dog chosenDog = new Dog();

       for(int i = 0; i < getLength(); i++){
           if (getPoint(i) == score){
               chosenDog = getDog(i);
           }
       }
        return chosenDog;
    }


    public Dog getDog (int position) {return  dogList.get(position);}

    public String getName(int position) {return dogList.get(position).getBreedName();}

    public String getLongDescription(int position) {return dogList.get(position).getLongDescription();}

    public String getShortDescription(int position) {return dogList.get(position).getShortDescription();}

    public int getImageDirectory(int position) {return dogList.get(position).getImageDirectory();}

    public int getPoint (int position) {return dogList.get(position).getPoint();}

    public void initDog(Context context){
        databaseHandler = new DatabaseHandler(context);
        dogList = databaseHandler.SelectAllDogs();
        if(dogList.isEmpty()){

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Cavalier),
                    context.getResources().getString(R.string.Cavalier_long),
                    context.getResources().getString(R.string.Cavalier_short),
                    7,
                    R.drawable.cavalier));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Chihuahua),
                    context.getResources().getString(R.string.chihuahua_long),
                    context.getResources().getString(R.string.chihuahua_short),
                    0,
                    R.drawable.chihuahua));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Pomeranian),
                    context.getResources().getString(R.string.Pomeranian_long),
                    context.getResources().getString(R.string.Pomeranian_short),
                    3,
                    R.drawable.pomeranian));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.German_shepherd),
                    context.getResources().getString(R.string.German_shepherd_long),
                    context.getResources().getString(R.string.German_shepherd_short),
                    13,
                    R.drawable.owczarek_niemiecki));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Pembroke_welsh_corgi),
                    context.getResources().getString(R.string.Pembroke_welsh_corgi_long),
                    context.getResources().getString(R.string.Pembroke_welsh_corgi_short),
                    6,
                    R.drawable.corgi));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.French_bulldog),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    14,
                    R.drawable.buldog_francuski));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Vizsla),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    20,
                    R.drawable.vizsla));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Pitbull),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    11,
                    R.drawable.pitbull));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.American_staffordshire_terrier),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    25,
                    R.drawable.amstaff));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Labrador_retriever),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    16,
                    R.drawable.labrador));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Rottweiler),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    26,
                    R.drawable.rottweiler));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Beagle),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    8,
                    R.drawable.beagle));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.English_bulldog),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    10,
                    R.drawable.buldog_angielski));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Golden_retriever),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    17,
                    R.drawable.golden));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Great_dane),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    21,
                    R.drawable.dog));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Dachshund),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    5,
                    R.drawable.jamnik));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Pug),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    2,
                    R.drawable.pub));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Chow_chow),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    22,
                    R.drawable.chow_chow));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Italian_greyhound),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    9,
                    R.drawable.charcik));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Yorkshire_terrier),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    1,
                    R.drawable.york));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Alaskan_malamute),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    23,
                    R.drawable.alaskan));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Samoyed),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    27,
                    R.drawable.samoyed));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Old_english_sheepdog),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    19,
                    R.drawable.owczarek_staroangielski));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Shiba_inu),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    18,
                    R.drawable.shiba));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Australian_shepherd_dog),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    12,
                    R.drawable.aussie));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Doberman),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    24,
                    R.drawable.dobreman));

            databaseHandler.InsertDog(new Dog(context.getResources().getString(R.string.Poodle),
                    context.getResources().getString(R.string.longDescription),
                    context.getResources().getString(R.string.shortDescription),
                    4,
                    R.drawable.pudel));

            dogList = databaseHandler.SelectAllDogs();
        }
    }
}
