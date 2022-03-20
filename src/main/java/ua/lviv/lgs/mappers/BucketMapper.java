package ua.lviv.lgs.mappers;

import java.sql.Date;
import java.sql.ResultSet;
import ua.lviv.lgs.domain.Bucket;

public class BucketMapper {
	public static Bucket map(ResultSet resultSet) throws Exception {
		Integer id =resultSet.getInt("id"); 
		Integer user_id= resultSet.getInt("user_id");
		Integer product_id = resultSet.getInt("product_id");
		Date purchase_date = resultSet.getDate("purchase_date");
		return new Bucket(id,user_id, product_id, purchase_date);
	}
}
