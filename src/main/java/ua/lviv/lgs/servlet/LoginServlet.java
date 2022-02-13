package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.UserServiceImpl;


@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserServiceImpl();
	private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);

     
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailUser = request.getParameter("emailUser");
		String passwordUser = request.getParameter("passwordUser");
		User user = null;
		try {
			user = userService.getByUseremail(emailUser);
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		
		if(user!=null && user.getUserEmail().equals(emailUser) && user.getPassword().equals(passwordUser)) {
			request.setAttribute("emailUser", emailUser);
			request.setAttribute("passwordUser", passwordUser);
			request.getRequestDispatcher("PagesWithMagazines.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("LoginPages.jsp").forward(request, response);
		}
	}


}
