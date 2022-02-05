package ua.lviv.lgs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailUser = request.getParameter("emailUser");
		String nameUser = request.getParameter("nameUser");
		String passwordUser = request.getParameter("passwordUser");
		User user = Shop.getShop().getUser(emailUser);
		if(user==null) {
			if(emailUser==null || nameUser==null || passwordUser==null) {
				response.sendError(response.SC_FORBIDDEN,"Regestration error");
			}else {
				Shop.getShop().addUser(new User(nameUser,passwordUser,emailUser));
				HttpSession session = request.getSession(true);
				session.setAttribute("nameUser", nameUser);
				session.setAttribute("emailUser", emailUser);
				session.setAttribute("passwordUser", passwordUser);
				request.getRequestDispatcher("PagesWithMagazines.jsp").forward(request, response);
			}
		}
		else if(emailUser==null || nameUser==null || passwordUser==null) {
			response.sendError(response.SC_FORBIDDEN,"Regestration error");
		}else if(user.getEmailUser().equals(emailUser)){
		    request.getRequestDispatcher("LoginPages.jsp").forward(request, response);
		}else {
			Shop.getShop().addUser(new User(nameUser,passwordUser,emailUser));
			HttpSession session = request.getSession(true);
			session.setAttribute("nameUser", nameUser);
			session.setAttribute("emailUser", emailUser);
			session.setAttribute("passwordUser", passwordUser);
			request.getRequestDispatcher("PagesWithMagazines.jsp").forward(request, response);
		}
	}
}
