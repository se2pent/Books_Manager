package com.shizhan.servlet;

import com.shizhan.model.Book;
import com.shizhan.model.BookStudent;
import com.shizhan.model.Student;
import com.shizhan.model.User;
import com.shizhan.service.BookService;
import com.shizhan.service.BorrowService;
import com.shizhan.service.StudentService;
import com.shizhan.service.impl.BookServiceImpl;
import com.shizhan.service.impl.BorrowServiceImpl;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context=new Context();
        resp.setContentType("text/html;charset=utf8");
        HttpSession session = req.getSession();
        User dbUser= (User) session.getAttribute("user");

        StudentService studentService=new StudentServiceImpl();
        List<Student> studentList = studentService.getStudentList();

        BookService bookService=new BookServiceImpl();
        List<Book> bookList = bookService.getBookList();

        BorrowService borrowService=new BorrowServiceImpl();
        List<BookStudent> borrow_list = borrowService.getBorrowList();







        context.setVariable("borrow_list",borrow_list);
        context.setVariable("user",dbUser);
        context.setVariable("student_count",studentList.size());
        context.setVariable("book_count",bookList.size());




        ThymeleafUtil.getEngine().process("index.html",context,resp.getWriter());
    }
}
