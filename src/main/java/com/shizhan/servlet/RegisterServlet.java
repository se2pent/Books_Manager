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
import java.io.IOException;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context=new Context();
        resp.setContentType("text/html;charset=utf8");
        ThymeleafUtil.getEngine().process("register.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf8s");
        String rusername = req.getParameter("rusername");
        String rpassword=req.getParameter("rpassword");

        UserService userService=new UserServiceImpl();
        User user = userService.getUser(rusername, rpassword);
        if (user==null){
            int row = userService.registerUser(rusername, rpassword);

            if (row>0){
                resp.sendRedirect("login");
            }

        }else {
            Context context=new Context();
            context.setVariable("rfailure",true);
            ThymeleafUtil.getEngine().process("register.html",context,resp.getWriter());

        }





    }
}
