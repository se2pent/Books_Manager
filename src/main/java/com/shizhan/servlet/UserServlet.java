package com.shizhan.servlet;

import com.shizhan.model.User;
import com.shizhan.service.UserService;
import com.shizhan.service.impl.UserServiceImpl;
import com.shizhan.utils.JDBCUtils;
import com.shizhan.utils.ThymeleafUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/login")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context=new Context();
        resp.setContentType("text/html;charset=utf8");
        UserService userService=new UserServiceImpl();

        Cookie[] cookies = req.getCookies();
        if (cookies!=null){
                   String username=null;
                   String password=null;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")){
                    username = cookie.getValue();
                }
                if (cookie.getName().equals("password")){
                    password = cookie.getValue();
                }
            }

            if (username!=null&&password!=null){
                User user = userService.getUser(username, password);
                if (user!=null){
                    /*req.getSession().setAttribute("user",user);
                    resp.sendRedirect("index");
                    return;*/
                }
            }
        }

        ThymeleafUtil.getEngine().process("login.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeUsername=req.getParameter("username");
        String typePassword=req.getParameter("password");
        String remember = req.getParameter("remember-me");

        System.out.println(typeUsername);
        System.out.println(typePassword);
        System.out.println(remember);

        UserService userService=new UserServiceImpl();
        User dbUser = userService.getUser(typeUsername,typePassword);


        if (dbUser!=null){
            if (remember!=null){
                Cookie usernameCookie=new Cookie("username",typeUsername);
                Cookie passwordCookie=new Cookie("password",typePassword);
                Cookie rememberCookie=new Cookie("remember-me",remember);
                usernameCookie.setMaxAge(60*60*24*7);
                passwordCookie.setMaxAge(60*60*24*7);
                rememberCookie.setMaxAge(60*60*24*7);
                resp.addCookie(usernameCookie);
                resp.addCookie(passwordCookie);
                resp.addCookie(rememberCookie);
            }
            req.getSession().setAttribute("user",dbUser);
            resp.sendRedirect("index");
        }else {
            resp.setContentType("text/html;charset=utf8");
            Context context=new Context();
            context.setVariable("failure",true);
            ThymeleafUtil.getEngine().process("login.html",context,resp.getWriter());
        }




    }
}
