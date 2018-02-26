package com.example.dominiczka.doggoproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dominiczka on 03.01.2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "dog_quiz_database";

    private static final String TABLE_DOG = "dog";
    private static final String COLUMN_ID_DOG = "id";
    private static final String COLUMN_DOG_NAME = "dogName";
    private static final String COLUMN_DOG_LONG_DESCRIPTION = "dogLongDesc";
    private static final String COLUMN_DOG_SHORT_DESCRIPTION = "dogShortDesc";
    private static final String COLUMN_DOG_POINT = "dogPoint";
    private static final String COLUMN_DOG_IMAGE_DIRECTORY = "imageDir";

    private static final String CREATE_TABLE_DOG = "CREATE TABLE " + TABLE_DOG + " ("
            + COLUMN_ID_DOG + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DOG_NAME + " TEXT, "
            + COLUMN_DOG_LONG_DESCRIPTION + " TEXT, "
            + COLUMN_DOG_SHORT_DESCRIPTION + " TEXT, "
            + COLUMN_DOG_POINT + " INTEGER, "
            + COLUMN_DOG_IMAGE_DIRECTORY + " INTEGER);";

    public static final String DELETE_DOG =
            "DROP TABLE IF EXISTS " + TABLE_DOG;

    SQLiteDatabase database;


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        database = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_DOG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
            db.execSQL(DELETE_DOG);
        onCreate(db);
    }

    public long InsertDog (Dog dog){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DOG_NAME, dog.getBreedName());
        values.put(COLUMN_DOG_LONG_DESCRIPTION, dog.getLongDescription());
        values.put(COLUMN_DOG_SHORT_DESCRIPTION, dog.getShortDescription());
        values.put(COLUMN_DOG_POINT, dog.getPoint());
        values.put(COLUMN_DOG_IMAGE_DIRECTORY, dog.getImageDirectory());
        long id = db.insert(TABLE_DOG, null, values);
        return id;
    }

    public List<Dog> SelectAllDogs() {

        List<Dog> dogList = new ArrayList<Dog>();

        String selectQuery = "SELECT * FROM " + TABLE_DOG;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if(c.moveToFirst()) {
            do {
                Dog dog = new Dog();

                String breedName = c.getString(c.getColumnIndex(COLUMN_DOG_NAME));
                dog.setBreedName(breedName);

                String longDescription = c.getString(c.getColumnIndex(COLUMN_DOG_LONG_DESCRIPTION));
                dog.setLongDescription(longDescription);

                String shortDescription = c.getString(c.getColumnIndex(COLUMN_DOG_SHORT_DESCRIPTION));
                dog.setShortDescription(shortDescription);

                int point = c.getInt(c.getColumnIndex(COLUMN_DOG_POINT));
                dog.setPoint(point);

                int imageDirectory = c.getInt(c.getColumnIndex(COLUMN_DOG_IMAGE_DIRECTORY));
                dog.setImageDirectory(imageDirectory);

                dogList.add(dog);
            } while(c.moveToNext());
        }
        return dogList;
    }
}

