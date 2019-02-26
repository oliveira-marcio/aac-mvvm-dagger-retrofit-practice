package com.anushka.androidtutz.contactmanager.db.entity;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ContactDAO {

    @Insert
    public long addContact(Contact contact);

    @Update
    public void updateContact(Contact contact);

    @Delete
    public void deleteContact(Contact contact);

    @Query("SELECT * from contacts")
    List<Contact> getContacts();

    @Query("SELECT * from contacts where contact_id == :contactId")
    public Contact getContact(long contactId);
}
