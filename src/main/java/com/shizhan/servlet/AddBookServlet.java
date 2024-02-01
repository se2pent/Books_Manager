package com.shizhan.servlet;

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
@WebServlet("/add-book")
public class AddBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf8");
        req.setCharacterEncoding("utf8");
        HttpSession session = req.getSession();
        User user= (User) session.getAttribute("user");

        Context context=new Context();

        context.setVariable("user",user);

        String title=req.getParameter("title");
        String desc=req.getParameter("desc");
        String sPrice = req.getParameter("price");
        if (title!=null&&desc!=null&&sPrice!=null){
            BookService bookService=new BookServiceImpl();
            int row = bookService.insertBook(title, desc, Double.valueOf(sPrice));
            if (row>0){
                req.getRequestDispatcher("books").forward(req,resp);
            }
        }

        ThymeleafUtil.getEngine().process("add-book.html",context,resp.getWriter());




    }
}
