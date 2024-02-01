package com.shizhan.servlet;

import com.shizhan.service.BookService;
import com.shizhan.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-book")
public class DeleteBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService=new BookServiceImpl();
        String bid = req.getParameter("bid");
        int row = bookService.deleteBook(Integer.valueOf(bid));
        if (row!=0){
            resp.sendRedirect("books");
        }
    }
}
