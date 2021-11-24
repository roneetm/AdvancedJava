import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ProfileServlet")
public class Profile extends HttpServlet {
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
        Cookie[] cookies = request.getCookies();
       if(cookies!= null){
            String email = cookies[1].getValue();
            request.getRequestDispatcher("link.html").include(request, response);
            out.println("<h1>Your email is " +email + "</h1>");
       }
       else{
           request.getRequestDispatcher("link.html").include(request, response);
           out.println("<h1>Please login to your account</h1>");
       }

        out.println("</body>");
        out.println("</html>");
    }
}
