package com.shizhan.dao;

import com.shizhan.model.BookStudent;
import com.shizhan.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BorrowDao {
    public int insertBorrow(int bookId,int stuId){
        Connection connection=null;
        QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
        String sql="insert into borrow(bid,sid,time) values (?,?,NOW())";
        int row=0;
        try {
            row = queryRunner.update(sql, bookId, stuId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }

    public List<BookStudent> getBorrowList(){
        Connection connection=null;
        QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
        String sql="select br.id,bk.title,br.time,sd.name,sd.sid from borrow br left join book bk on br.bid=bk.bid left join student sd on br.sid=sd.sid";
        BookStudent bookStudent=null;
        List<BookStudent> bookStudentList=null;
        try {
            bookStudentList = queryRunner.query(sql, new BeanListHandler<BookStudent>(BookStudent.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookStudentList;
    }

    public int returnBook(int id){
        Connection connection=null;
        QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
        String sql="delete from borrow where id=?";
        BookStudent bookStudent=null;
        int row=0;
        try {
            row = queryRunner.update(sql,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }
}
