package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.User;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     response.setContentType("text/html");
     
     try(PrintWriter pw= response.getWriter())
     { 
    	HttpSession session =  request.getSession();
    	System.out.println("from logout page"+session.isNew());
    	System.out.println("Id:"+session.getId());
    	
    	User userDetails =  (User) session.getAttribute("user_details");
    	
    	if(userDetails != null)
    	{
    		pw.print("<h5>Hello,"+userDetails.getFirstName()+"</h5>");
    	}
    	session.invalidate();
    	pw.print("<h5>You have logged out...</h5>");
    	pw.print("<h5><a href='login.html'>Visit Again</a></h5>");
     }
	}

}
