package com.shuchenysh.contacts;

import android.app.Application;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Contact.class}, version = 1)
public abstract class Database extends RoomDatabase {

    private static Database instance = null;
    private static final String DB_NAME = "contacts.db";

    public static Database getInstance(Application application) {
        if (instance == null) {
            instance = Room.databaseBuilder(application, Database.class, DB_NAME).build();
        }
        return instance;
    }
}
