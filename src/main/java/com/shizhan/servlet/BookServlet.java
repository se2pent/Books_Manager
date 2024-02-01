package com.shizhan.servlet;

import com.shizhan.model.Book;
import com.shizhan.model.User;
import com.shizhan.service.BookService;
import com.shizhan.service.impl.BookServiceImpl;
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

@WebServlet("/books")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService=new BookServiceImpl();
        List<Book> bookList = bookService.getBookList();
        Context context=new Context();
        HttpSession session = req.getSession();
        User user= (User) session.getAttribute("user");


        context.setVariable("user",user);
        context.setVariable("book_list",bookList);
        context.setVariable("book_list_status",bookList);


        resp.setContentType("text/html;charset=utf8");

        ThymeleafUtil.getEngine().process("books.html",context,resp.getWriter());


    }
}
