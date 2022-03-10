package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.service.BucketService;
import ua.lviv.lgs.service.impl.BucketServiceImpl;


@WebServlet(name = "bucket", urlPatterns = { "/bucket" })
public class BucketControllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BucketService bucketService =  BucketServiceImpl.getBucketServiceImpl();
	private static final Logger LOGGER = Logger.getLogger(BucketControllServlet.class);

       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String productId = request.getParameter("productId");
			HttpSession session = request.getSession();
			Integer userId =(Integer) session.getAttribute("user_id");
			java.util.Date date = new java.util.Date();
			Bucket bucket = new Bucket(userId,Integer.parseInt(productId),new Date(date.getTime()));
			bucketService.create(bucket);
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
		response.getWriter().close();
		
	}

}
