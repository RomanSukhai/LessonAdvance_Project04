package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import ua.lviv.lgs.domain.Shop;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.UserServiceImpl;


public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserServiceImpl();
	private static final Logger LOGGER = Logger.getLogger(RegistrationServlet.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailUser = request.getParameter("emailUser");
		String nameUser = request.getParameter("nameUser");
		String passwordUser = request.getParameter("passwordUser");
		User user = Shop.getShop().getUser(emailUser);

		if(!emailUser.isEmpty() && !nameUser.isEmpty() && !passwordUser.isEmpty()) {
			if(user == null) {
				try {
					userService.create(new User(passwordUser,emailUser,nameUser));
				} catch (SQLException e) {
					LOGGER.error(e);
				}
				getRequest(nameUser, passwordUser, emailUser, request, response,"PagesWithMagazines.jsp");
			}else if(user.getUserEmail().equals(emailUser)){
			    request.getRequestDispatcher("LoginPages.jsp").forward(request, response);
			}else{
				try{
					userService.create(new User(passwordUser,emailUser,nameUser));
				}catch (SQLException e) {
					LOGGER.error(e);
				}
				getRequest(nameUser, passwordUser, emailUser, request, response,"PagesWithMagazines.jsp");
			}
		}else{
			LOGGER.error("Error)");
		}
	}
	private void getRequest(String nameUser,String passwordUser,String emailUser,HttpServletRequest request,HttpServletResponse response,String pages) {
		Shop.getShop().addUser(new User(nameUser,passwordUser,emailUser));
		HttpSession session = request.getSession(true);
		session.setAttribute("nameUser", nameUser);
		session.setAttribute("emailUser", emailUser);
		session.setAttribute("passwordUser", passwordUser);
		try {
			request.getRequestDispatcher(pages).forward(request, response);
		} catch (ServletException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		}
	}
}
