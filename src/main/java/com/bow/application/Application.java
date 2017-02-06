package com.bow.application;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author vv
 * @since 2017/1/28.
 */
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public void start() {
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.addConnector(connector);

        // ServletContextHandler context = new
        // ServletContextHandler(ServletContextHandler.SESSIONS);
        WebAppContext webAppContext = new WebAppContext("webapp", "/shiro-demo");
        // webAppContext.setContextPath("/shiro-demo");
        webAppContext.setDescriptor("webapp/WEB-INF/web.xml");
        webAppContext.setResourceBase("webapp");
        webAppContext.setDisplayName("shiro-demo");
        webAppContext.setClassLoader(Thread.currentThread().getContextClassLoader());
        webAppContext.setConfigurationDiscovered(true);
        webAppContext.setParentLoaderPriority(true);
        server.setHandler(webAppContext);

        try {
            server.start();
            LOGGER.info("----- success to start jetty server -----");
        } catch (Exception e) {

        }
    }

}
