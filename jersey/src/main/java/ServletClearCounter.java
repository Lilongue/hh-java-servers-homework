import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(urlPatterns = "/counter/clear")
public class ServletClearCounter extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        boolean isValid = Arrays.stream(cookies)
                .anyMatch(cookie -> cookie.getName().equals("hh-auth")  && cookie.getValue().length() > 10);

        if (isValid){
            Counter.nullCounter();
        }
        PrintWriter writer = resp.getWriter();
        writer.print("Counter is: " + Counter.getCounter());
        writer.flush();
    }
}
