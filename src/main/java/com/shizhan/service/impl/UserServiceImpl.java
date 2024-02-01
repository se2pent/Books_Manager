package com.shizhan.service.impl;

import com.shizhan.dao.UserDao;
import com.shizhan.model.User;
import com.shizhan.service.StudentService;
import com.shizhan.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User getUser(String username,String password) {
        UserDao userDao=new UserDao();
        User user = userDao.getUser(username,password);

        return user;
    }

    @Override
    public int registerUser(String rusername, String rpassword) {
        UserDao userDao=new UserDao();
        int row = userDao.registerUser(rusername, rpassword);
        return row;
    }

    @Override
    public User findPassword(String fusername) {
        UserDao userDao=new UserDao();
        User user=userDao.findPassword(fusername);
        return user;
    }

    @Override
    public int updatePassword(String fpassword,String fusername) {
        UserDao userDao=new UserDao();
        int row = userDao.updatePassword(fpassword, fusername);
        return row;
    }
}
