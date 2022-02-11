package ua.lviv.lgs.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.mappers.UserMapper;
import ua.lviv.lgs.untils.ConectorUtils;

public class UserDaoImpl implements UserDao{
	private final static String READ_BY_ALL 			= "SELECT * FROM user";
	private final static String CREATE_BY				= "INSERT INTO user(userEmail,userName,password) VALUES (?,?,?)";
	private final static String READ_BY_ID 				= "SELECT * FROM user WHERE id = ?";
	private final static String UPDATE_BY_ID 			= "UPDATE user SET nameEmail=?,userName =?,password =? WHERE id = ?";
	private final static String DELETE_BY_ID 			= "DELETE FROM user WHERE  id = ?";
	private final static String READ_BY_USERNAME 		= "SELECT userName FROM user";
	private final static String READ_BY_USEREMAIL 		= "SELECT userEmail FROM user";
	private final static String DROP_TABLE 				= "DROP TABLE IF EXISTS user";
	
	
	private Connection connection;
	private PreparedStatement preparedStatement ;
	
	
	
	public UserDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConectorUtils.connection();
	}

	@Override
	public User create(User user)  {
		try {
			preparedStatement = connection.prepareStatement(CREATE_BY,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1,user.getUserEmail());
			preparedStatement.setString(2,user.getUserName());
			preparedStatement.setString(3,user.getPassword());
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			user.setId(resultSet.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public User read(Integer id){
		User user = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			Integer userid = resultSet.getInt("id");
			String nameEmail = resultSet.getString("nameEmail");
			String userName = resultSet.getString("userName");
			String password = resultSet.getString("password");
			user = new User(userid,password, nameEmail,userName);
		} catch (SQLException e) {
		}return user;	
	}

	@Override
	public void delete(Integer id){
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1,id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void dropTableIfExists(){
		try {
			preparedStatement = connection.prepareStatement(DROP_TABLE);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User update(User user, Integer id){
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1,user.getUserEmail());
			preparedStatement.setString(2,user.getUserName());
			preparedStatement.setString(3,user.getPassword());
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	}

	@Override
	public void readByAll(){
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ALL);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void readByUserName() {
		try {
			preparedStatement = connection.prepareStatement(READ_BY_USERNAME);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void readByUserEmail() {
		try {
			preparedStatement = connection.prepareStatement(READ_BY_USEREMAIL);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> readAll() {
		List<User> user = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ALL);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user.add(UserMapper.map(resultSet));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
			return user;
	}
	

	
}
