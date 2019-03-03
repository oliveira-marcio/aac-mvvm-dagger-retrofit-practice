package com.marcio.ebookshop.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface BookDAO {
    @Insert
    public void insert(Book book);

    @Update
    public void update(Book book);

    @Delete
    public void delete(Book book);

    @Query("SELECT * FROM books")
    public LiveData<List<Book>> getAllBooks();

    @Query("SELECT * FROM books WHERE category_id = :categoryId")
    public LiveData<Book> getBooks(int categoryId);
}
