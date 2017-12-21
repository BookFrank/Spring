package com.tazine.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */
@WebServlet("/cars")
public class TaglibServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] cars = new String[]{"BMW", "Audi", "Bens", "Lexus"};
        req.setAttribute("cars", cars);
        req.getRequestDispatcher("/WEB-INF/jsp/tags.jsp").forward(req, resp);
    }
}
