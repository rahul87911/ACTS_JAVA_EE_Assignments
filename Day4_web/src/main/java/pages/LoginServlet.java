package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidatesDaoImpl;
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
	private CandidatesDaoImpl candidateDao;
	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		//dao inst
		try {
         userDao=new UserDaoImpl();
         candidateDao=new CandidatesDaoImpl();
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
			candidateDao.cleanUp();
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
					//request  wc to get the session
					HttpSession  session =  request.getSession();
					System.out.println("from login page :"+session.isNew());
					//add validated user details under the session scope
					System.out.println("id"+session.getId());
					session.setAttribute("user_details",user);
					session.setAttribute("user_dao", userDao);
					session.setAttribute("candidate_dao", candidateDao);
					if (user.getRole().equals("admin"))
						response.sendRedirect("admin_page");
					else {
						// voter role
						if (user.isStatus()) // alrdy voted
							response.sendRedirect("logout");
						else // not yet voted
							response.sendRedirect("candidates");
					}
				}
			}
			catch(Exception e)
			{
				throw new ServletException("err in dopost"+getClass().getName(),e);
			}
			
		}
	}

}
