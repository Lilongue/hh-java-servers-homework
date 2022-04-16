import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/counter")
public class ServletGetCounter extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        writer.print("Counter is: " + Counter.getCounter());
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Counter.setCounter();
        PrintWriter writer = resp.getWriter();
        writer.print("Counter is: " + Counter.getCounter());
        writer.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String subValue = req.getParameter("Subtraction-Value");
        if (subValue == null){
            subValue = "0";
        }
        Counter.delCounter(Integer.parseInt(subValue));
        PrintWriter writer = resp.getWriter();
        writer.print("Counter is: " + Counter.getCounter());
        writer.flush();
    }


}
