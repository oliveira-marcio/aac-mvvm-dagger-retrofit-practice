package com.marcio.ebookshop;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.marcio.ebookshop.databinding.ActivityMainBinding;
import com.marcio.ebookshop.model.Book;
import com.marcio.ebookshop.model.Category;
import com.marcio.ebookshop.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mainActivityViewModel;
    private List<Category> categoriesList;
    private List<Book> booksList;
    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandlers handlers;
    private Category selectedCategory;
    private RecyclerView booksRecyclerView;
    private BooksAdapter booksAdapter;
    private int selectedBookId;

    public static final int ADD_BOOK_REQUEST_CODE = 1;
    public static final int EDIT_BOOK_REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        handlers = new MainActivityClickHandlers();
        activityMainBinding.setClickHandlers(handlers);

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mainActivityViewModel.getAllCatgories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(@Nullable List<Category> categories) {
                categoriesList = categories;
                showSpinner();
            }
        });
    }

    private void showSpinner() {
        ArrayAdapter<Category> categoryArrayAdapter = new ArrayAdapter<Category>(this, R.layout.spinner_item, categoriesList);
        categoryArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        activityMainBinding.setSpinnerAdapter(categoryArrayAdapter);
    }

    private void loadBooksList(int categoryId) {
        mainActivityViewModel.getBooksOfASelectedCategory(categoryId).observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(@Nullable List<Book> books) {
                booksList = books;
                loadRecyclerView();
            }
        });
    }

    private void loadRecyclerView() {
        booksRecyclerView = activityMainBinding.rvBooks;
        booksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        booksRecyclerView.setHasFixedSize(true);

        booksAdapter = new BooksAdapter();
        booksRecyclerView.setAdapter(booksAdapter);

        booksAdapter.setBooks(booksList);
        booksAdapter.setListener(new BooksAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Book book) {
                selectedBookId = book.getBookId();
                Intent intent = new Intent(MainActivity.this, AddAndEditActivity.class);
                intent.putExtra(AddAndEditActivity.BOOK_ID, selectedBookId);
                intent.putExtra(AddAndEditActivity.BOOK_NAME, book.getBookName());
                intent.putExtra(AddAndEditActivity.BOOK_PRICE, book.getUnitPrice());
                startActivityForResult(intent, EDIT_BOOK_REQUEST_CODE);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                Book bookToDelete = booksList.get(viewHolder.getAdapterPosition());
                mainActivityViewModel.deleteNewBook(bookToDelete);

            }
        }).attachToRecyclerView(booksRecyclerView);
    }

    public class MainActivityClickHandlers {

        public void onFABClicked(View view) {
            Intent intent = new Intent(MainActivity.this, AddAndEditActivity.class);
            startActivityForResult(intent, ADD_BOOK_REQUEST_CODE);
        }

        public void onSelectItem(AdapterView<?> parent, View view, int pos, long id) {
            selectedCategory = (Category) parent.getItemAtPosition(pos);
            loadBooksList(selectedCategory.getId());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK) {
            return;
        }

        int selectedCategoryId = selectedCategory.getId();

        Book book = new Book();
        book.setCategoryId(selectedCategoryId);
        book.setBookName(data.getStringExtra(AddAndEditActivity.BOOK_NAME));
        book.setUnitPrice(data.getStringExtra(AddAndEditActivity.BOOK_PRICE));

        switch (requestCode) {
            case ADD_BOOK_REQUEST_CODE:
                mainActivityViewModel.addNewBook(book);
                break;
            case EDIT_BOOK_REQUEST_CODE:
                book.setBookId(selectedBookId);
                mainActivityViewModel.updateNewBook(book);
                break;
        }
    }
}
