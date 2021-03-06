package ua.lviv.lgs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ua.lviv.lgs.dto.UserLogin;

@WebServlet(name = "forwardLogin", urlPatterns = { "/forwardLogin" })
public class ForwardLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserLogin userLogin = new UserLogin();
		userLogin.destinationUrl = "LoginPages.jsp";
		Gson gsonr = new Gson();
		String jsonr = gsonr.toJson(userLogin);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonr);
		response.getWriter().close();
		
	}

}
