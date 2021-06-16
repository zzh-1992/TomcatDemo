/*
 *Copyright @2021 Grapefruit. All rights reserved.
 */

package com.grapefruit.webtomcat.demo;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

/**
 * @author Grapefruit
 * @version 1.0
 * @date 2021/4/10
 */
public class TomcatTest {
    private static final String SERVLET_NAME = "servlet";

    public static void main(String[] args) {

        Tomcat tomcat = new Tomcat();
        Connector connector = new Connector();
        connector.setPort(8888);
        connector.setURIEncoding("UTF-8");

        tomcat.getService().addConnector(connector);

        MyServlet myServlet = new MyServlet();

        // http://127.0.0.1:8888/project/xxxx
        Context context = tomcat.addContext("project", null);
        Tomcat.addServlet(context, SERVLET_NAME, myServlet);
        context.addServletMappingDecoded("/index", SERVLET_NAME);

        try {
            tomcat.start();

            // 阻塞tomcat,等待请求
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
