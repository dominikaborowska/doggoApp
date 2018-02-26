package com.example.dominiczka.doggoproject;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dominiczka on 08.01.2018.
 */

public class Dog implements Parcelable {

    private String breedName;
    private String longDescription;
    private String shortDescription;
    private int point;
    private int imageDirectory;

    public Dog() { }

    public Dog(String breedName, String longDescription, String shortDescription, int point, int imageDirectory) {
        this.breedName = breedName;
        this.longDescription = longDescription;
        this.shortDescription = shortDescription;
        this.point = point;
        this.imageDirectory = imageDirectory;
    }


    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getImageDirectory() {
        return imageDirectory;
    }

    public void setImageDirectory(int imageDirectory) {
        this.imageDirectory = imageDirectory;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(breedName);
        parcel.writeString(longDescription);
        parcel.writeString(shortDescription);
        parcel.writeInt(point);
        parcel.writeInt(imageDirectory);
    }

    public static final Parcelable.Creator<Dog> CREATOR = new Parcelable.Creator<Dog>() {
        public Dog createFromParcel(Parcel in) {
            return new Dog(in);
        }

        public Dog[] newArray(int size) {
            return new Dog[size];
        }
    };

    private Dog(Parcel in) {
        breedName = in.readString();
        longDescription = in.readString();
        shortDescription = in.readString();
        point = in.readInt();
        imageDirectory = in.readInt();

    }
}
