package listeners;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class SessionListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public SessionListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Init web");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Destroy web");    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session was init: " + se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session was destroyed: " + se.getSession());
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        System.out.println("Session attribute was added: " + sbe.getName() + " " + sbe.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        System.out.println("Session attribute was removed: " + sbe.getName() + " " + sbe.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        System.out.println("Session attribute was replaced: " + sbe.getName() + " " + sbe.getValue());
    }
}
