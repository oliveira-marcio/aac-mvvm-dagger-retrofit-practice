package com.marcio.ebookshop.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.marcio.ebookshop.model.Book;
import com.marcio.ebookshop.model.Category;
import com.marcio.ebookshop.model.EBookShopRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private EBookShopRepository eBookShopRepository;
    private LiveData<List<Category>> allCatgories;
    private LiveData<List<Book>> booksOfASelectedCategory;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        eBookShopRepository = new EBookShopRepository(application);
    }

    public LiveData<List<Category>> getAllCatgories(){
        allCatgories = eBookShopRepository.getCategories();
        return allCatgories;
    }

    public LiveData<List<Book>> getBooksOfASelectedCategory(int categoryId){
        booksOfASelectedCategory = eBookShopRepository.getBooks(categoryId);
        return booksOfASelectedCategory;
    }

    public void addNewBook(Book book){
        eBookShopRepository.insertBook(book);
    }

    public void updateNewBook(Book book){
        eBookShopRepository.updateBook(book);
    }

    public void deleteNewBook(Book book){
        eBookShopRepository.deleteBook(book);
    }
}
