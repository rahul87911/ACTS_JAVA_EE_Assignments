package pages;

import java.io.IOException;
import java.sql.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IUserDao;
import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class VoterRegisterServlet
 */
@WebServlet("/register")
public class VoterRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      
      String firstName = request.getParameter("firstName");
      String lastName = request.getParameter("lastName");
      String email = request.getParameter("email");
      String password = request.getParameter("password");
      Date dob = Date.valueOf(request.getParameter("dob")); 
      
      try {
          // Create a UserDao instance
          IUserDao userDao = new UserDaoImpl();

          // Call the addUser method to add the new user
          User newUser = userDao.addUser(firstName, lastName, email, password, dob);

          if (newUser != null) {
              // User added successfully
              response.getWriter().println("User added successfully!");
          } else {
              // Failed to add user
              response.getWriter().println("Failed to add user!");
          }
	}
      catch(Exception e)
      {
    	  throw new ServletException("Error in doPost of " + getClass(), e);  
      }

}
}
