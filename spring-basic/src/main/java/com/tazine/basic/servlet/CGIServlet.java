package com.tazine.basic.servlet;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * CGIServlet：没有 JSP 时，JavaWeb 就是这样输出页面的
 *
 * @author frank
 * @since 1.0.0
 */
public class CGIServlet extends HttpServlet {

    @Resource(name = "version")
    private String version;

    @Override
    public void init() throws ServletException {
        System.out.println("CGIServlet Init...");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CGIServlet Service()...");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        resp.setStatus(200);
        resp.setHeader("Content-type", "text/html");

        String remoteAddr = req.getRemoteAddr();
        String remoteHost = req.getRemoteHost();
        int remotePort = req.getRemotePort();
        String remoteUser = req.getRemoteUser();

        String requestedSessionId = req.getRequestedSessionId();


        PrintWriter writer = resp.getWriter();

        writer.write("<h1>");
        writer.write("CGIservlet：没有 JSP 时，JavaWeb 就是这样输出页面的");
        writer.write("</h1>");

        writer.write("<p>");
        writer.write("requestUri：" + req.getRequestURI() + "<br/>");
        writer.write("requestedSessionId：" + requestedSessionId + "<br/>");
        writer.write("<br/><br/>");

        writer.write("remoteAddr：" + remoteAddr + "<br/>");
        writer.write("remoteHost：" + remoteHost + "<br/>");
        writer.write("remotePort：" + remotePort + "<br/>");
        writer.write("remoteUser：" + remoteUser + "<br/>");
        writer.write("<br/><br/>");

        writer.write("读取 web.xml 参数的几种方式： <br/>");
        writer.write("-- 初始化参数 init-param（ServletConfig） <br/>");
        writer.write("-- 上下文参数 context-param（ServletContext）<br/>");
        writer.write("-- 资源注射 @Resource<br/>");
        writer.write("-- 使用 JNDI 获取资源<br/>");
        writer.write("-- 注射数据源<br/>");
        writer.write("<br/><br/>");

        ServletConfig servletConfig = this.getServletConfig();
        writer.write("ServletConfig（Servlet初始化参数）<br/>");
        Enumeration<String> names = servletConfig.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            writer.write(name + "：" + servletConfig.getInitParameter(name) + "<br/>");
        }
        writer.write("<br/><br/>");

        ServletContext servletContext = this.getServletContext();
        String serverInfo = servletContext.getServerInfo();
        writer.write("ServletContext（读取上下文参数）<br/>");
        writer.write("serverInfo：" + serverInfo + "<br/>");
        Enumeration<String> conParams = servletContext.getInitParameterNames();
        while (conParams.hasMoreElements()) {
            String val = names.nextElement();
            writer.write(val + "：" + servletContext.getInitParameter(val) + "<br/>");
        }
        writer.write("<br/><br/>");

        writer.write("@Resource（资源注入）<br/>");
        writer.write("version：" + version + "<br/>");
        writer.write("<br/><br/>");

        try {
            Context ctx = new InitialContext();
            String author = (String) ctx.lookup("author");
            writer.write("JNDI 获取资源（资源注入）- Java 命名与目录接口，Java Naming and Directory Interface<br/>");
            writer.write("author：" + author + "<br/>");
            writer.write("<br/><br/>");
        } catch (NamingException e) {
            e.printStackTrace();
        }

        writer.write("注射数据源<br/>");
        writer.write("Servlet中不仅可以注射String、Integer等类型的变量，还可以注入自定义的 Java Bean以及数据源等复杂类型变量<br/>");
        writer.write("<br/><br/>");


        writer.write("</p>");

        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("CGIServlet Destory...");
    }
}
