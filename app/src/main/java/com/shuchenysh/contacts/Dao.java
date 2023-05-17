package com.shuchenysh.contacts;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Query("SELECT * FROM contacts")
    LiveData<List<Contact>> getContacts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(Contact contact);

    @Query("DELETE FROM contacts WHERE id = :id")
    void remove(int id);
}
