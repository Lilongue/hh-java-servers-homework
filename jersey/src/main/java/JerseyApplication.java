import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class JerseyApplication {

  private static Server createServer(int port){
    Server server = new Server(port);
    ServletHandler servletHandler = new ServletHandler();
    servletHandler.addServletWithMapping(ServletGetCounter.class, "/counter");
    servletHandler.addServletWithMapping(ServletClearCounter.class, "/counter/clear");
    server.setHandler(servletHandler);
    return server;
  }
  public static void main(String[] args) {
    // run, Jetty, run!
    int port = 8090;
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
