package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidatesDaoImpl;
import pojos.*;

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
			pw.print("<h5>Candidates List</h5>");
			//get http get session fro m wc
			HttpSession hs=request.getSession();
			System.out.println("from topics page"+hs.isNew());
			System.out.println("id"+hs.getId());//has to be same for same client
			
			User user=(User)hs.getAttribute("user_details");
			
			if (user != null) {
				// get candidate dao from session
				CandidatesDaoImpl dao = (CandidatesDaoImpl) hs.getAttribute("candidate_dao");
				pw.print("<h5> Hello , " + user.getFirstName() + " " + user.getLastName() + "</h5>");
//					//5. get candidate list from candidate dao
				
				
				List<Candidates> candidates = dao.getAllCandidates();
				
				// dynamic form generation
				
				pw.print("<form action='logout' method='post'>");
				// iterate over candidate list
				for (Candidates c : candidates)
					pw.print("<h5> <input type='radio' "
							+ "name='candidate_id' "
							+ "value='" + c.getId() + "'/>"
							+ c.getName() + "</h5>");
				//submit button
				pw.print("<h6> <input type='submit' value='Cast A Vote'/></h6>");
				pw.print("</form>");

			}

			else
				pw.print("<h5> Can't remember the clnt , No Cookies!!!!!!</h5>");

		}
		catch (Exception e) {
			// re throw the exc to the WC -- by wrapping it in the SE
			throw new ServletException("err in do-get of " + getClass(), e);
		}
	}
}
		
		
			 
				


