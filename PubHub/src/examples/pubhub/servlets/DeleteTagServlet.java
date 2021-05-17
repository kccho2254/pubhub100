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


@WebServlet("/DeleteTag")

public class DeleteTagServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        boolean isSuccess = false;
		
		// remove tags
        String isbn13 = req.getParameter("isbn13");
        Tag tag = new Tag();
        
		System.out.println("firing?");


        tag.setIsbn13(isbn13);
        tag.setTag(req.getParameter("tag"));

        TagDAO tao = DAOUtilities.getTagDAO();
        isSuccess =  tao.deleteTag(isbn13, tag);
        
        if(isSuccess){
			req.getSession().setAttribute("message", "Tag deleted");
			req.getSession().setAttribute("messageClass", "alert-success");
	        res.sendRedirect(req.getContextPath() + "/ViewBookDetails?isbn13=" + isbn13);
		} else {
			req.getSession().setAttribute("message", "There was a problem deleting this tag");
			req.getSession().setAttribute("messageClass", "alert-danger");
			res.sendRedirect("BookPublishing");
		}
     
    }		
}