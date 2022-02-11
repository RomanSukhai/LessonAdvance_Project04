package ua.lviv.lgs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.domain.Shop;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
     
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Shop shop = new Shop();
		String emailUser = request.getParameter("emailUser");
		String passwordUser = request.getParameter("passwordUser");
		User user = Shop.getShop().getUser(emailUser);
		if(user==null) {
			request.getRequestDispatcher("HeaderPages.jsp").forward(request, response);
		}
		if(!user.getUserEmail().equals(emailUser) && !user.getPassword().equals(passwordUser)) {
			response.sendError(response.SC_FORBIDDEN,"Regestration error");
		}
		else if(user.getUserEmail().equals(emailUser) && user.getPassword().equals(passwordUser)) {
			request.setAttribute("emailUser", emailUser);
			request.setAttribute("passwordUser", passwordUser);
			request.getRequestDispatcher("PagesWithMagazines.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		doPost(request, response);
		
	}

}
