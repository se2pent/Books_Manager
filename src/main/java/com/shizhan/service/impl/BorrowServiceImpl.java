package com.shizhan.service.impl;

import com.shizhan.dao.BorrowDao;
import com.shizhan.model.BookStudent;
import com.shizhan.service.BorrowService;

import java.util.List;

public class BorrowServiceImpl implements BorrowService {
    @Override
    public int insertBorrow(int bookId, int stuId) {
        BorrowDao borrowDao=new BorrowDao();
        int row=borrowDao.insertBorrow(bookId,stuId);
        return row;
    }

    @Override
    public List<BookStudent> getBorrowList() {
        BorrowDao borrowDao=new BorrowDao();
        List<BookStudent> bookStudentList = borrowDao.getBorrowList();
        return bookStudentList;
    }

    @Override
    public int returnBook(int id) {
        BorrowDao borrowDao=new BorrowDao();
        int row= borrowDao.returnBook(id);
        return row;
    }
}
