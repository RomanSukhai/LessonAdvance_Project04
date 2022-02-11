package ua.lviv.lgs.mappers;

import java.sql.Date;
import java.sql.ResultSet;
import javax.xml.crypto.Data;
import ua.lviv.lgs.domain.Bucket;

public class BucketMapper {
	public static Bucket map(ResultSet resultSet) throws Exception {
		Integer user_id= resultSet.getInt("name_animal");
		Integer product_id = resultSet.getInt("type_animal");
		Date purchase_date = resultSet.getDate("purchase_date");
		return new Bucket(user_id, product_id, (Data) purchase_date);
	}
}
