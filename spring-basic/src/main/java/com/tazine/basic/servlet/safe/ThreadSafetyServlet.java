package com.tazine.basic.servlet.safe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ThreadSafetyServlet
 *
 * @author frank
 * @since 1.0.0
 */
public class ThreadSafetyServlet extends HttpServlet {

    private String name;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        name = req.getParameter("name");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resp.getWriter().println("req.getParameter(name) = " + req.getParameter("name"));
        resp.getWriter().println("name = " + name);
    }
}
