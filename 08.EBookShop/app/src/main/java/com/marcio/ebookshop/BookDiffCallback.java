package com.marcio.ebookshop;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.marcio.ebookshop.model.Book;

import java.util.List;

public class BookDiffCallback extends DiffUtil.Callback {

    private List<Book> oldBookList;
    private List<Book> newBookList;

    public BookDiffCallback(List<Book> oldBookList, List<Book> newBookList) {
        this.oldBookList = oldBookList;
        this.newBookList = newBookList;
    }

    @Override
    public int getOldListSize() {
        return oldBookList != null ? oldBookList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return newBookList != null ? newBookList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldBookPosition, int newBookPosition) {
        return oldBookList.get(oldBookPosition).getBookId() == newBookList.get(newBookPosition).getBookId();
    }

    @Override
    public boolean areContentsTheSame(int oldBookPosition, int newBookPosition) {
        return oldBookList.get(oldBookPosition).equals(newBookList.get(newBookPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
