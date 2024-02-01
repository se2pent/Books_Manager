package com.shizhan.servlet;

import com.shizhan.model.User;
import com.shizhan.service.UserService;
import com.shizhan.service.impl.UserServiceImpl;
import com.shizhan.utils.ThymeleafUtil;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/findpassword2")
public class FindPasswordServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf8");
        Context context=new Context();
        ThymeleafUtil.getEngine().process("findpassword2.html",context,resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf8");
        String fpassword=req.getParameter("fpassword");
        UserService userService=new UserServiceImpl();
        HttpSession session = req.getSession();
        User fuser = (User) session.getAttribute("fuser");
        int row = userService.updatePassword(fpassword, fuser.getUsername());
        if (row>0&&!(fpassword.equals(fuser.getPassword()))){
            resp.sendRedirect("login");
        }else {
            Context context=new Context();
            context.setVariable("ffailure",true);
            ThymeleafUtil.getEngine().process("findpassword2.html",context,resp.getWriter());
        }
    }
}
