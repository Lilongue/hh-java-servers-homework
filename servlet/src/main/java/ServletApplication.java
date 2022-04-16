import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import resource.CounterResource;

import javax.ws.rs.core.Application;
import java.util.Set;

public class ServletApplication{

  private static Server createServer(int port){
    Server server = new Server(port);

    ServletContextHandler contextHandler = new ServletContextHandler();
    server.setHandler(contextHandler);

    ServletHolder servletHolder = contextHandler.addServlet(ServletContainer.class, "/*");
    servletHolder.setInitOrder(1);
    servletHolder.setInitParameter("jersey.config.server.provider.packages", "resource"); //javax.ws.rs.core.Application
    return server;
  }

  public static void main(String[] args) {
    // run, Jetty, run!
    int port = 8089;
    Server server = createServer(port);
    try{
      server.start();
      server.join();
    }
    catch (Exception e){
      System.out.println("something wrong");
    }
  }
}
