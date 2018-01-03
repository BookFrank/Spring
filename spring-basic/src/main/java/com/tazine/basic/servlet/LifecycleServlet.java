package com.tazine.basic.servlet;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet LifeCycle
 *
 * @author frank
 * @since 1.0.0
 */
@WebServlet(
        displayName = "This servlet display the servlet lifecycle",
        value = "/life",
        //urlPatterns = "/life",
        loadOnStartup = 1,
        initParams = {
                @WebInitParam(name = "username", value = "frank")
        }
)
public class LifecycleServlet extends HttpServlet {


    public LifecycleServlet() {
        System.out.println("Servlet Constructor");
    }

    @PostConstruct
    private void post() {
        System.out.println("Servlet @PostConstruct Annotation...");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet Init...");
        super.init();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Servlet Service()...");
        super.service(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet doGet()...");
        resp.setStatus(200);
        resp.getWriter().print("OK");
    }

    @PreDestroy
    private void before() {
        System.out.println("Servlet @PreDestory");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet Destory...");
        super.destroy();
    }
}
