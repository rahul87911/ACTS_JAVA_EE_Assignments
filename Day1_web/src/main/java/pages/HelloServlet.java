package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("in init : invoked by"+Thread.currentThread());	
	}

	@Override
	public void destroy() {
		System.out.println("in destroy : invoked by"+Thread.currentThread());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("in DoGet invoked by :"+Thread.currentThread());
	
	resp.setContentType("text/html");
	
	try(PrintWriter pw=resp.getWriter())
	{
	  pw.print("<h5>Welcome to Servlet..."+LocalDateTime.now()+"</h5>");	
	}
	}
	
	
	
	
}
