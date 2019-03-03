package com.marcio.ebookshop.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface CategoryDAO {

    @Insert
    public void insert(Category category);

    @Update
    public void update(Category category);

    @Delete
    public void delete(Category category);

    @Query("SELECT * FROM categories")
    public LiveData<List<Category>> getAllCategories();
}
