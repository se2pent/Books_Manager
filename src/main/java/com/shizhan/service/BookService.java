package com.shizhan.service;

import com.shizhan.model.Book;

import java.util.List;

public interface BookService {
    public List<Book> getBookList();

    public int deleteBook(int bid);

    public int insertBook(String title,String desc,double price);
}
