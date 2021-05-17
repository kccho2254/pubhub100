package examples.pubhub.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.BookDAO;
import examples.pubhub.dao.TagDAO;
import examples.pubhub.model.Book;
import examples.pubhub.model.Tag;
import examples.pubhub.utilities.DAOUtilities;

/**
 * Servlet implementation class ViewBookDetailsServlet
 */

// This is a "View" servlet, and has been named accordingly. All it does is send the user to a new JSP page
// But it also takes the opportunity to populate the session or request with additional data as needed.
@WebServlet("/SearchBooksByTag")
public class SearchBookByTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// The bookDetails.jsp page needs to have the details of the selected book saved to the request,
		// Otherwise it won't know what details to display. Ergo, we need to fetch those details before we
//		request.getRequestDispatcher("bookDetailsByTag.jsp").forward(request, response);
//		
//		// Actually redirect the user.
		
		BookDAO dao = DAOUtilities.getBookDAO();
		HashMap<String, List<String>> book = dao.getBooksAndTags();
	    	
		request.getSession().setAttribute("books", book);
		request.getRequestDispatcher("bookDetailsByTag.jsp").forward(request, response);
		
	}
}
