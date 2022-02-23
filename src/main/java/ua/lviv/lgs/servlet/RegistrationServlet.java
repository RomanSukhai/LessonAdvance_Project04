package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

import ua.lviv.lgs.domain.Shop;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.dto.UserLogin;
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
				UserLogin userLogin = new UserLogin();
				userLogin.destinationUrl = "PagesWithMagazines.jsp";
				
				Gson gsonr = new Gson();
				String jsonr = gsonr.toJson(userLogin);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(jsonr);
				response.getWriter().close();
				
			}else if(user.getUserEmail().equals(emailUser)){
				UserLogin userLogin = new UserLogin();
				userLogin.destinationUrl = "PagesWithMagazines.jsp";
				
				Gson gsonr = new Gson();
				String jsonr = gsonr.toJson(userLogin);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(jsonr);
				response.getWriter().close();
			    
			}else{
				try{
					userService.create(new User(passwordUser,emailUser,nameUser));
				}catch (SQLException e) {
					LOGGER.error(e);
				}
				UserLogin userLogin = new UserLogin();
				userLogin.destinationUrl = "PagesWithMagazines.jsp";
				userLogin.UserEmail = user.getUserEmail();
				
				Gson gsonr = new Gson();
				String jsonr = gsonr.toJson(userLogin);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(jsonr);
				response.getWriter().close();
			}
		}else{
			LOGGER.error("Error)");
		}
	}
	
}
