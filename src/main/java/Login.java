import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginservlet")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Login</title>");
        out.println("<body>");

        // Fetching Name
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(email.equals("mike@gmail.com")){
            Cookie cookie = new Cookie("email", "mike@gmail.com");
            request.getRequestDispatcher("link.html").include(request, response);
            out.println("<h1>Logged in Successfully.    </h1>");
            response.addCookie(cookie);
        }
        else{
            request.getRequestDispatcher("index.jsp").include(request, response);
            out.println("<br>");
            out.println("<h1>Bad Credentials</h1>");
        }

        out.println("</body>");
        out.println("</html>");

    }
}
