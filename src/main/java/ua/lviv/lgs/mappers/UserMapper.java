package ua.lviv.lgs.mappers;

import java.sql.ResultSet;
import ua.lviv.lgs.domain.User;

public class UserMapper {
	public static User map(ResultSet resultSet) throws Exception {
		String UserEmail = resultSet.getString("userEmail");
		String UserName = resultSet.getString("userName");
		String password = resultSet.getString("password");
		return new User(password, UserEmail, UserName);
	}
}
