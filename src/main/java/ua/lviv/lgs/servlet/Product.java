package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.google.gson.Gson;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.domain.Shop;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.dto.UserLogin;
import ua.lviv.lgs.service.MagazineService;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.MagazineServiceImpl;
import ua.lviv.lgs.service.impl.UserServiceImpl;


@WebServlet( name = "product", urlPatterns = { "/product" })
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MagazineService magazineService = MagazineServiceImpl.getMagazineServiceImpl();
	private static final Logger LOGGER = Logger.getLogger(RegistrationServlet.class);
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pages =request.getParameter("pages");
		String information = request.getParameter("information");
		String price = request.getParameter("price");
		
		Integer pages_Integer = Integer.valueOf(pages);
		Double  price_Double  = Double.valueOf(price);
		
		Magazine magazine = Shop.getShop().getMagazine(name);
		
		if(!name.isEmpty() && !pages.isEmpty() && !information.isEmpty()) {
			if(magazine == null) {
				try {
					magazineService.create(new Magazine(name,pages_Integer,information,price_Double));
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
				
			}else if(magazine.getName().equals(name)){
				UserLogin userLogin = new UserLogin();
				userLogin.destinationUrl = "LoginPages.jsp";
				
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
	//to create new Magazine
   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	//to 

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

	

}
