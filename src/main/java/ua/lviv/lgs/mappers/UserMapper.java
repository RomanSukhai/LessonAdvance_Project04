package ua.lviv.lgs.mappers;

import java.sql.ResultSet;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.domain.UserRole;

public class UserMapper {
	public static User map(ResultSet resultSet) throws Exception {
		Integer id = resultSet.getInt("id");
		String UserEmail = resultSet.getString("userEmail");
		String UserName = resultSet.getString("userName");
		String password = resultSet.getString("password");
		String role = resultSet.getString("role");
		return new User(id,password, UserEmail, UserName,UserRole.valueOf(role));
	}
}
