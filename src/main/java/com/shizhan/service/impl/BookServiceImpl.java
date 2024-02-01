package com.shizhan.service.impl;

import com.shizhan.dao.BookDao;
import com.shizhan.model.Book;
import com.shizhan.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public List<Book> getBookList() {
        BookDao bookDao=new BookDao();
        return bookDao.getBookList();
    }

    @Override
    public int deleteBook(int bid) {
        BookDao bookDao=new BookDao();
        int row = bookDao.deleteBook(bid);
        return row;
    }

    @Override
    public int insertBook(String title, String desc, double price) {
        BookDao bookDao=new BookDao();
        int row = bookDao.insertBook(title, desc, price);
        return row;
    }
}
