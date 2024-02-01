package com.shizhan.servlet;

import com.shizhan.model.Student;
import com.shizhan.model.User;
import com.shizhan.service.StudentService;
import com.shizhan.service.impl.StudentServiceImpl;
import com.shizhan.utils.ThymeleafUtil;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*调用Service*/
        StudentService studentService = new StudentServiceImpl();
        List<Student> studentList = studentService.getStudentList();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");


        Context context=new Context();

        resp.setContentType("text/html;charset=utf8");
        context.setVariable("student_list",studentList);
        context.setVariable("user",user);
        ThymeleafUtil.getEngine().process("students.html",context,resp.getWriter());
    }

}
