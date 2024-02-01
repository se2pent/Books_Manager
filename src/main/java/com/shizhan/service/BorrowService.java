package com.shizhan.service;

import com.shizhan.model.BookStudent;

import java.util.List;

public interface BorrowService {
    public int insertBorrow(int bookId,int stuId);
    public List<BookStudent> getBorrowList();
    public int returnBook(int id);
}
