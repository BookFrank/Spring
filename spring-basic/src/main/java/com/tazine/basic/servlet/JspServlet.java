package com.tazine.basic.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lina on 2017/12/23.
 *
 * @author frank
 * @since 1.0.0
 */
@WebServlet(value = "/jsp")
public class JspServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a = req.getParameter("type") == null ? 0 : Integer.parseInt(req.getParameter("type"));
        if (a == 1){
            req.setAttribute("filename","poem.jsp");
        }else {
            req.setAttribute("filename","lyric.jsp");
        }
        req.getRequestDispatcher("/WEB-INF/jsp/inner/inner.jsp").forward(req,resp);
    }
}
