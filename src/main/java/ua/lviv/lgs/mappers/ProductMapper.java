package ua.lviv.lgs.mappers;

import java.sql.ResultSet;
import ua.lviv.lgs.domain.Magazine;

public class ProductMapper {
	
	public static  Magazine map(ResultSet resultSet) throws Exception {
		Integer id = resultSet.getInt("id");
		String name= resultSet.getString("name");
		Integer pages = resultSet.getInt("pages");
		String information = resultSet.getString("information");
		Double price = resultSet.getDouble("price");
		return new Magazine(id,name, pages, information, price);
	}
}
