package com.shizhan.dao;

import com.shizhan.model.BookStudent;
import com.shizhan.model.User;
import com.shizhan.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {

    public User getUser(String username,String password) {
        QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
        Connection connection = null;
        User dbUser=null;
        try {
            String sql = "select * from admin where username=? and password=?";
            dbUser = queryRunner.query(sql, new BeanHandler<User>(User.class),username,password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dbUser;
    }

    public int registerUser(String rusername,String rpassword){
        QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
        Connection connection = null;
        int row=0;
        try {
            String sql = "insert into admin(username,password,avatarUrl) values (?,?,'http://rongcloud-web.qiniudn.com/docs_demo_rongcloud_logo.png')";
            row = queryRunner.update(sql,rusername,rpassword);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }

    public User findPassword(String fusername){
        QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
        Connection connection = null;
        User fUser=null;
        try {
            String sql = "select * from admin where username=?";
            fUser = queryRunner.query(sql, new BeanHandler<User>(User.class),fusername);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return fUser;
    }

    public int updatePassword(String fpassword,String fusername){
        QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
        Connection connection = null;
        int row;
        try {
            String sql = "update admin set password=? where username=?";
            row = queryRunner.update(sql,fpassword,fusername);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }


}
