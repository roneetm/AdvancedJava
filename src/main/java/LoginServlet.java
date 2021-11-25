import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequset(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequset(req, resp);
    }

    protected void processRequset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        request.getRequestDispatcher("links.html").include(request, response);

        String name = request.getParameter("email");
        String password = request.getParameter("password");

        if(name.equals("mike@gmail.com")){
            out.println("<br>");
            out.println("<br>");
            out.println("Welcome "+ name);
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
        } else {
            out.println("Bad Credentials");
        }
    }
}
