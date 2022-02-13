package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.dao.daoimpl.UserDaoImpl;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	private static UserService userServiceImpl;
	
	private UserServiceImpl() {
		try {
			userDao = new UserDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
	}
	public static UserService getUserServiceImpl() {
		if(userServiceImpl==null) {
			userServiceImpl=new UserServiceImpl();
		}
		return userServiceImpl;
	}

	@Override
	public void readByAll() {
		try {
			userDao.readAll();
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public User create(User user) throws SQLException {
		return userDao.create(user);
	}

	@Override
	public User read(Integer id) throws SQLException {
		return userDao.read(id);
	}

	@Override
	public User update(User user, Integer id) throws SQLException {
		return userDao.update(user, id);
	}

	@Override
	public void delete(Integer id) throws SQLException {
		userDao.delete(id);
	}

	@Override
	public void dropTableIfExists() throws SQLException {
		userDao.dropTableIfExists();
	}

	@Override
	public List<User> readAll() throws SQLException, Exception {
		return userDao.readAll();
	}
	@Override
	public User getByUseremail(String userEmail) throws SQLException {
		return userDao.getByUseremail(userEmail);
	}
}
