package com.tazine.basic.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author frank
 * @since 1.0.0
 */
@WebServlet(value = "/hello")
public class HelloServlet extends HttpServlet{

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Servlet Init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("kobe","24");
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req,resp);
        System.out.println("Servlet doGet");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Servlet Destory");
    }
}
