import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class L1Listener implements ServletContextListener, ServletContextAttributeListener,
        HttpSessionListener, HttpSessionAttributeListener {

    public L1Listener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextListener: Initialized context");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ContextListener: Destroyed context");
    }

    public void sessionCreated(HttpSessionEvent se) {

    }

    public void sessionDestroyed(HttpSessionEvent se) {

    }

    public void attributeAdded(HttpSessionBindingEvent sbe) {

    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {

    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {

    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent sce) {
        System.out.println("ContextListener: attributeAdded: attributeName = " + sce.getName());
        System.out.println("ContextListener: attributeAdded: attributeValue = " + sce.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent sce) {
        System.out.println("ContextListener: attributeRemoved: attributeName = " + sce.getName());
        System.out.println("ContextListener: attributeRemoved: attributeValue = " + sce.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent sce) {
        System.out.println("ContextListener: attributeReplaced: attributeName = " + sce.getName());
        System.out.println("ContextListener: attributeReplaced: attributeValue = " + sce.getValue());
    }
}
