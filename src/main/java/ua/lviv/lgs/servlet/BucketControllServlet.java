package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.dto.BucketDto;
import ua.lviv.lgs.service.BucketService;
import ua.lviv.lgs.service.MagazineService;
import ua.lviv.lgs.service.impl.BucketServiceImpl;
import ua.lviv.lgs.service.impl.MagazineServiceImpl;


@WebServlet(name = "bucket", urlPatterns = { "/bucket" })
public class BucketControllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BucketService bucketService =  BucketServiceImpl.getBucketServiceImpl();
	MagazineService magazineService = MagazineServiceImpl.getMagazineServiceImpl();
	private static final Logger LOGGER = Logger.getLogger(BucketControllServlet.class);

       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Map<Integer,Magazine> map = magazineService.readAllMap();
			List<Bucket> list = bucketService.readAll();
			List<Integer> integers = bucketService.readAllId();
			List<BucketDto> bucketDtos = maper(map, list,integers,request,response);
			
			Gson gsonr = new Gson();
			String jsonr = gsonr.toJson(bucketDtos);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonr);
			response.getWriter().close();
			
		} catch (Exception e) {
			LOGGER.error(e);
		}
		
		
		
	}
	public List<BucketDto> maper(Map<Integer,Magazine> map,List<Bucket> list,List<Integer> integers,HttpServletRequest request, HttpServletResponse response){
		return list.stream().map(bucket->{
			BucketDto bucketDto = new BucketDto();
			bucketDto.bucket_id = bucket.getId();
			bucketDto.purchase_date = bucket.getPurchase_date();
			
			Magazine magazine = map.get(bucket.getProduct_id());
			
			bucketDto.name = magazine.getName();
			bucketDto.information = magazine.getInformation();
			bucketDto.price = magazine.getPrice();
			
			return bucketDto;
			
		}).collect(Collectors.toList());
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String productId = request.getParameter("productId");
			HttpSession session = request.getSession(true);
			
			
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
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
			try {
				String bucketId = req.getParameter("bucketId");
				bucketService.delete(Integer.parseInt(bucketId));
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write("Success");
		resp.getWriter().close();
	}

}
