package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojos.User;
import utils.DbUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value="/login",loadOnStartup=1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDaoImpl userDao;
	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		//dao inst
		try {
         userDao=new UserDaoImpl();
		}
		catch(Exception e)
		{
		 throw new ServletException("err in init"+getClass().getName(),e);	
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			userDao.cleanUp();
			DbUtils.closeConnection(); 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try(PrintWriter pw= response.getWriter())
		{
			String email = request.getParameter("em");
			String password =  request.getParameter("pass");
			
			
			try {
				User user =  userDao.validateUser(email, password);
				
				if(user==null)
				{
				 pw.print("<h5>Invalid User, Please <a href='login.html'>Retry</a></h5>");	
				}
				else {
					//pw.print("<h5>Login Successful!!!</h5>");
					//pw.print("<h5>Validated User Details"+user+"</h5>");
					//session tracking through cookie storage 
					Cookie c1=new Cookie("validated_user_details",user.toString());
					response.addCookie(c1);
					response.sendRedirect("candidates");
				}
			}
			catch(Exception e)
			{
				throw new ServletException("err in dopost"+getClass().getName(),e);
			}
			
		}
	}

}
