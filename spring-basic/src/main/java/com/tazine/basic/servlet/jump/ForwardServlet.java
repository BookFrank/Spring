package com.tazine.basic.servlet.jump;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ForwardServlet
 *
 * @author frank
 * @since 1.0.0
 */
public class ForwardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String destination = req.getParameter("f");
        RequestDispatcher dis;
        if (null == destination){
            resp.getWriter().print("请输入 forward 参数（file、jsp、servlet）");
        }else {
            if ("file".equalsIgnoreCase(destination)){
                dis = req.getRequestDispatcher("/WEB-INF/web.xml");
            }else if ("jsp".equalsIgnoreCase(destination)){
                dis = req.getRequestDispatcher("/WEB-INF/jsp/forward.jsp");
            }else if ("servlet".equalsIgnoreCase(destination)){
                dis = req.getRequestDispatcher("/cgi");
            }else {
                dis = req.getRequestDispatcher("/WEB-INF/web.xml");
            }
            dis.forward(req,resp);
        }
    }
}
