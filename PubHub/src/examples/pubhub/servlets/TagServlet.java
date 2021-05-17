package examples.pubhub.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.TagDAO;
import examples.pubhub.model.Book;
import examples.pubhub.utilities.DAOUtilities;

/*
 * This servlet will take you to the homepage for the Book Publishing module (level 100)
 */
@WebServlet("/BookPublishing")
public class TagServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	// http route for getting books by tag
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tag = request.getParameter("tag");
		
		TagDAO tao = DAOUtilities.getTagDAO();
		List<Book> books = tao.getBooksByTag(tag);

		request.setAttribute("books", books);
		request.setAttribute("tag", tag);
		
		request.getRequestDispatcher("bookPublishingHome.jsp").forward(request, response);
	}
}