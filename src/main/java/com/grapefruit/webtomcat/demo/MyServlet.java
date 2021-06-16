package com.grapefruit.webtomcat.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Grapefruit
 * @version 1.0
 * @date 2021/4/10
 */
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("===servlet===>");
    }

    public String doIndex() {
        System.out.println("===servlet===>");
        return LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
    }
}
