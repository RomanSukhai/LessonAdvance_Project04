package ua.lviv.lgs.dao;

import java.sql.SQLException;

import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.shared.AbstractCRUD;

public interface UserDao extends AbstractCRUD<User>{
	void readByUserName() throws SQLException;
	void readByUserEmail() throws SQLException;
	User getByUseremail(String userEmail) throws SQLException;
	User getByUserPassword(String userEmail) throws SQLException;
}
