package examples.pubhub.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.TagDAO;
import examples.pubhub.model.Tag;
import examples.pubhub.utilities.DAOUtilities;

@WebServlet("/AddTagRoute")
public class TagAddServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	// http route for adding tag	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		boolean isSuccess= false;

        String isbn13 = req.getParameter("isbn13");
        Tag tag = new Tag();

        tag.setIsbn13(isbn13);
        tag.setTag(req.getParameter("tag"));

        TagDAO tao = DAOUtilities.getTagDAO();
        isSuccess = tao.addTag(isbn13, tag);
                
        if(isSuccess){
			req.getSession().setAttribute("message", "Tag was added");
			req.getSession().setAttribute("messageClass", "alert-success");
			res.sendRedirect("ViewBookDetails?isbn13=" + isbn13);
		} else {
			req.getSession().setAttribute("message", "There was a problem adding this tag");
			req.getSession().setAttribute("messageClass", "alert-danger");
			res.sendRedirect("BookPublishing");
		}
    }
}