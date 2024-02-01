package com.shizhan.dao;

import com.shizhan.model.BookStudent;
import com.shizhan.model.Student;
import com.shizhan.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentDao {

    public List<Student> getStudentList(){
        QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
        String sql="select * from student";
        Connection connection=null;
        List<Student> studentList=null;
        try {
            studentList = queryRunner.query(sql,new BeanListHandler<Student>(Student.class));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return studentList;
    }



}
