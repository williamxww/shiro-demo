package com.bow.spring.springmvc.jetty;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author acer
 * @since 2016年5月17日
 */
public class JettyServer {

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        connector.setHost("localhost");
        server.addConnector(connector);

        // 添加servlet
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // http://localhost:8080/hello
        context.addServlet(new ServletHolder(new HelloServlet()), "/hello");

        // spring
        ServletContextHandler springMvcHandler = new ServletContextHandler();
        springMvcHandler.setContextPath("/spring");
        XmlWebApplicationContext ac = new XmlWebApplicationContext();
        ac.setConfigLocations(new String[] { "classpath:com/bow/spring/springmvc/jetty/applicationContext.xml" });
        springMvcHandler.addEventListener(new ContextLoaderListener(ac));
        springMvcHandler.addServlet(new ServletHolder(new DispatcherServlet(ac)), "/*");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { springMvcHandler });
        server.setHandler(handlers);

        server.start();
        server.join();
    }

}
