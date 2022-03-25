package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import com.google.gson.Gson;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.dto.UserLogin;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.UserServiceImpl;


@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserServiceImpl();
	private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);

     
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailUser = request.getParameter("emailUser");
		String passwordUser = request.getParameter("passwordUser");
		User user = null;
		
		try {
			user = userService.getByUseremail(emailUser)   ;
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		if(user!=null && user.getUserEmail().equals(emailUser) && user.getPassword().equals(passwordUser)) {
			HttpSession session = request.getSession();
			session.setAttribute("user_id",user.getId());
			session.setAttribute("role",user.getRole().toString());
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
		else {
			request.getRequestDispatcher("LoginPages.jsp").forward(request, response);
		}
	}


}
