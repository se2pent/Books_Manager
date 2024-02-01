package com.shizhan.servlet;

import com.shizhan.model.User;
import com.shizhan.service.BorrowService;
import com.shizhan.service.impl.BorrowServiceImpl;
import com.shizhan.utils.ThymeleafUtil;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/return-book")
public class ReturnBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bid=req.getParameter("id");

        BorrowService borrowService=new BorrowServiceImpl();

        if (bid!=null){
            borrowService.returnBook(Integer.valueOf(bid));
            resp.sendRedirect("index");
        }


    }
}
