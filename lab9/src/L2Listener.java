import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class L2Listener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public L2Listener() {
    }

    public void contextInitialized(ServletContextEvent sce) {

    }

    public void contextDestroyed(ServletContextEvent sce) {

    }

    public void sessionCreated(HttpSessionEvent se) {

    }

    public void sessionDestroyed(HttpSessionEvent se) {    }

    public void attributeAdded(HttpSessionBindingEvent sbe) {
        System.out.println("SessionListener: attributeAdded: attributeID = " + sbe.getSession().getId());
        System.out.println("SessionListener: attributeAdded: attributeName = " + sbe.getName());
        System.out.println("SessionListener: attributeAdded: attributeValue = " + sbe.getValue());
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        System.out.println("SessionListener: attributeRemoved: attributeID = " + sbe.getSession().getId());
        System.out.println("SessionListener: attributeRemoved: attributeName = " + sbe.getName());
        System.out.println("SessionListener: attributeRemoved: attributeValue = " + sbe.getValue());

    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        System.out.println("SessionListener: attributeReplaced: attributeID = " + sbe.getSession().getId());
        System.out.println("SessionListener: attributeReplaced: attributeName = " + sbe.getName());
        System.out.println("SessionListener: attributeReplaced: attributeValue = " + sbe.getValue());
    }
}
