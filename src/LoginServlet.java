

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
	

	public void init() {	
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(name.equals("admin") && password.equals("admin")) {
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
//			request.getRequestDispatcher("ProfileServlet").include(request, response);
			response.sendRedirect("ProfileServlet");
		} else {
			out.print("Invalid credentials");
			request.getRequestDispatcher("login.html").include(request, response);	
		}
		
	}
	
}
