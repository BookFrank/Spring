package com.tazine.basic.servlet.jump;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * RefreshServlet
 *
 * @author frank
 * @since 1.0.0
 */
public class RefreshServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String page = req.getParameter("page");
        // 默认刷新本页面
        if (null == page || "1".equalsIgnoreCase(page)){
            resp.setHeader("Refresh","1000; URL=http://localhost:8080/basic/refresh?page=1");
        }else {
            resp.setHeader("Refresh","1000; URL=http://localhost:8080/basic/cgi");
        }
    }
}
