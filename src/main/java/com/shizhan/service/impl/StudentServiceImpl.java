package com.shizhan.service.impl;

import com.shizhan.dao.StudentDao;
import com.shizhan.dao.UserDao;
import com.shizhan.model.Student;
import com.shizhan.model.User;
import com.shizhan.service.StudentService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> getStudentList() {
        StudentDao studentDao=new StudentDao();
        return studentDao.getStudentList();
    }
}
