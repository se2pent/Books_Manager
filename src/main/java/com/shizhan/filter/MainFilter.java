package com.shizhan.filter;



import com.shizhan.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class MainFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        String url = request.getRequestURL().toString();
        if(!url.contains("/static/") && !url.endsWith("login")&&!url.endsWith("register")&&!url.endsWith("findpassword1")&&!url.endsWith("findpassword2")){
            HttpSession session = request.getSession();
            User user  = (User) session.getAttribute("user");
            if(user == null) {
                response.sendRedirect("login");
                return;
            }
        }
        filterChain.doFilter(request, response);
    }
}
