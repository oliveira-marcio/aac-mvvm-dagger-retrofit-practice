package com.marcio.ebookshop;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marcio.ebookshop.databinding.BookListItemBinding;
import com.marcio.ebookshop.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookViewHolder> {

    private OnItemClickListener listener;
    private List<Book> books = new ArrayList<>();

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        BookListItemBinding bookListItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.book_list_item,
                viewGroup,
                false
        );
        return new BookViewHolder(bookListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder bookViewHolder, int position) {
        Book book = books.get(position);
        bookViewHolder.bookListItemBinding.setBook(book);
    }

    @Override
    public int getItemCount() {
        return books != null ? books.size() : 0;
    }

    public void setBooks(List<Book> newBooks) {
        final DiffUtil.DiffResult result = DiffUtil.calculateDiff(new BookDiffCallback(books, newBooks), false);
        books = newBooks;
        result.dispatchUpdatesTo(BooksAdapter.this);
    }

    class BookViewHolder extends RecyclerView.ViewHolder {

        private BookListItemBinding bookListItemBinding;

        public BookViewHolder(@NonNull final BookListItemBinding bookListItemBinding) {
            super(bookListItemBinding.getRoot());
            this.bookListItemBinding = bookListItemBinding;
            bookListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int clickedPosition = getAdapterPosition();

                    if (listener != null && clickedPosition != RecyclerView.NO_POSITION) {
                        listener.onItemClick(books.get(clickedPosition));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Book book);
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}
