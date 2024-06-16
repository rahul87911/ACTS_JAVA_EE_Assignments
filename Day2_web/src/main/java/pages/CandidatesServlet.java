package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CandidatesServlet
 */
@WebServlet("/candidates")
public class CandidatesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try(PrintWriter pw=response.getWriter())
		{
			pw.print("<h5>Login Successful</h5>");
			Cookie[] cookies=request.getCookies();
			
			if(cookies != null)
			{
				for(Cookie c:cookies)
			      if(c.getName().equals("validated_user_details")) {
			    	  pw.print("<h5>User details fetched from a Cookie"+c.getValue()+"</h5>");
			    	  break;
			}
			else
				pw.print("<h5>No Cookies</h5>");
			}
					
			
		}
	}

}
