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

@WebServlet("/findpassword1")
public class FindPasswordServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context=new Context();
        resp.setContentType("text/html;charset=utf8");
        ThymeleafUtil.getEngine().process("findpassword1.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf8");
        String fusername = req.getParameter("fusername");
        UserService userService=new UserServiceImpl();
        User fuser = userService.findPassword(fusername);
        if (fuser!=null){
            HttpSession session = req.getSession();
            session.setAttribute("fuser",fuser);
            resp.sendRedirect("findpassword2");
        }else {
            Context context=new Context();
            context.setVariable("ffailure",true);
            ThymeleafUtil.getEngine().process("findpassword1.html",context,resp.getWriter());
        }
    }
}
