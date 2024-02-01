package com.shizhan.dao;

import com.shizhan.model.Book;
import com.shizhan.model.BookStudent;
import com.shizhan.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
    public List<Book> getBookList(){
        QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
        String sql="select * from book";
        Connection connection=null;
        List<Book> bookList=null;
        try {
            bookList = queryRunner.query(sql,new BeanListHandler<Book>(Book.class));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return bookList;
    }

    public int deleteBook(int bid){
        QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
        String sql="delete from book where bid=?";
        Connection connection=null;
        int row=0;
        try {

            row = queryRunner.update(sql, bid);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    return row;
    }

    public int insertBook(String title, String desc, double price) {
        QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
        String sql="insert into book(title,`desc`,price) values (?,?,?)";
        Connection connection=null;
        int row=0;
        try {
            row = queryRunner.update(sql, title,desc,price);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }


}
