package com.shizhan.servlet;

import com.shizhan.dao.StudentDao;
import com.shizhan.model.Book;
import com.shizhan.model.Borrow;
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
import java.util.List;

@WebServlet("/add-borrow")
public class AddBorrowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf8");
        HttpSession session = req.getSession();
        User user= (User) session.getAttribute("user");

        StudentService studentService=new StudentServiceImpl();
        List<Student> studentList = studentService.getStudentList();
        BookService bookService=new BookServiceImpl();
        List<Book> bookList = bookService.getBookList();

        Context context=new Context();
        context.setVariable("user",user);
        context.setVariable("student_list",studentList);
        context.setVariable("book_list",bookList);
        ThymeleafUtil.getEngine().process("add-borrow.html",context,resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //实例化student和book接口实现类


        String bookId=req.getParameter("book");
        String stuId=req.getParameter("student");



        if (bookId!=null&&stuId!=null){

            BorrowService borrowService=new BorrowServiceImpl();
            int row = borrowService.insertBorrow(Integer.valueOf(bookId), Integer.valueOf(stuId));

            if (row>0){
                resp.sendRedirect("index");
            }
        }




    }
}
