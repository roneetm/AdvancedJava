import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        request.getRequestDispatcher("links.html").include(request, response);

        HttpSession session = request.getSession(false);
        if(session!=null){
            out.println("<br>");
            out.println("Session Creation time "+session.getCreationTime());
            out.println("<br>");
            out.println("Session new or old "+session.isNew());
            out.println("<br>");
            out.println("Session Last Accessed Time "+session.getLastAccessedTime());
            out.println("<br>");
            out.println("Session Attribute Name "+session.getAttributeNames());
            out.println("<br>");
        } else {
            out.println("<br>");
            out.println("Please login first");
        }

    }
}
