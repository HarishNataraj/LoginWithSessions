

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet{
	

	public void init() {
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			String name = (String) session.getAttribute("name");
			out.print("<h2>Profile Page</h2><br>Welcome, "+name);
			out.print("<a href='LogoutServlet'>Logout</a>");
		} else {
			out.print("Login to view profile");
			request.getRequestDispatcher("login.html").include(request, response);
		}
	}
	
}
