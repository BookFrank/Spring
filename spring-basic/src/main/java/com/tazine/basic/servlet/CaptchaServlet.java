package com.tazine.basic.servlet;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * VerificationCode Servlet
 *
 * @author frank
 * @since 1.0.0
 */
public class CaptchaServlet extends HttpServlet {

    private static final char[] CHARS = {'2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

    private static Random random = new Random();

    private static String getRandString() {
        StringBuffer sb = new StringBuffer();
        sb.append(CHARS[random.nextInt(CHARS.length)]);
        sb.append(CHARS[random.nextInt(CHARS.length)]);
        sb.append(CHARS[random.nextInt(CHARS.length)]);
        sb.append(CHARS[random.nextInt(CHARS.length)]);
        return sb.toString();
    }

    private static Color getRandColor() {
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    private static Color getReverseColor(Color c) {
        return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/jpeg");

        String randString = getRandString();
        req.getSession().setAttribute("randomString", randString);

        int width = 100;
        int height = 30;

        Color color = getRandColor();
        Color reverse = getReverseColor(color);

        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        g.setColor(color);
        g.fillRect(0, 0, width, height);
        g.setColor(reverse);
        g.drawString(randString, 18, 20);
        for (int i = 0, n = random.nextInt(100); i < n; i++) {
            g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
        }
        ServletOutputStream out = resp.getOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);

        encoder.encode(bi);
        out.flush();
    }

}
