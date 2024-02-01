package com.shizhan.service;

import com.shizhan.model.User;

public interface UserService {
    User getUser(String username,String password);

    int registerUser(String rusername,String rpassword);

    User findPassword(String fusername);

    int updatePassword(String fpassword,String fusername);
}
