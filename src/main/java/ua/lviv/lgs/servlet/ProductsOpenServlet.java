package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.service.MagazineService;
import ua.lviv.lgs.service.impl.MagazineServiceImpl;

/**
 * Servlet implementation class ProductsOpenServlet
 */
@WebServlet(name = "magazines", urlPatterns = { "/magazines" })
public class ProductsOpenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MagazineService magazineService = MagazineServiceImpl.getMagazineServiceImpl();
	private static final Logger LOGGER = Logger.getLogger(ProductsOpenServlet.class);
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Magazine> listoMagazines = magazineService.readAll();
			Gson gsonr = new Gson();
			String jsonr = gsonr.toJson(listoMagazines);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonr);
			response.getWriter().close();
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}
	
	


}
