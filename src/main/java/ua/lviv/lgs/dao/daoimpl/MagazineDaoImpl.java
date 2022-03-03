package ua.lviv.lgs.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.MagazineDao;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.mappers.ProductMapper;
import ua.lviv.lgs.untils.ConectorUtils;

public class MagazineDaoImpl implements MagazineDao{
	private final static String READ_BY_ALL 			= "SELECT * FROM product";
	private final static String CREATE_BY				= "INSERT INTO product(name,pages,information,price) VALUES (?,?,?,?)";
	private final static String READ_BY_ID 				= "SELECT * FROM product WHERE id = ?";
	private final static String UPDATE_BY_ID 			= "UPDATE product SET name=?,pages =?,information =?,price=? WHERE id = ?";
	private final static String DELETE_BY_ID 			= "DELETE FROM product WHERE  id = ?";
	private final static String READ_BY_NAME 			= "SELECT name  FROM product";
	private final static String READ_BY_PAGES 			= "SELECT pages FROM product";
	private final static String READ_BY_PRICE			= "SELECT price FROM product";
	private final static String DROP_TABLE 				= "DROP TABLE IF EXISTS product";
	private final static Logger LOGGER = Logger.getLogger(MagazineDaoImpl.class);
	
	private Connection connection;
	private PreparedStatement preparedStatement ;
	
	
	
	public MagazineDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConectorUtils.connection();
	}

	@Override
	public Magazine create(Magazine product){
		try {
			preparedStatement = connection.prepareStatement(CREATE_BY,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1,product.getName());
			preparedStatement.setInt(2,product.getPages());
			preparedStatement.setString(3,product.getInformation());
			preparedStatement.setDouble(4,product.getPrice());
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			product.setId(resultSet.getInt(1));
					
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return product;
		
	}

	@Override
	public Magazine read(Integer id)  {
		Magazine product = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			Integer productid = resultSet.getInt("id");
			String name = resultSet.getString("name");
			Integer pages = resultSet.getInt("pages");
			String information = resultSet.getString("information");
			Double price = resultSet.getDouble("price");
			product = new Magazine(productid,name, pages, information, price);
			return product;
		} catch (SQLException e) {
			LOGGER.error(e);
		}return product;	
	}

	@Override
	public void delete(Integer id)  {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1,id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void dropTableIfExists() {
		try {
			preparedStatement = connection.prepareStatement(DROP_TABLE);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public Magazine update(Magazine product, Integer id)  {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1,product.getName());
			preparedStatement.setInt(2,product.getPages());
			preparedStatement.setString(3,product.getInformation());
			preparedStatement.setDouble(4, product.getPrice());
			preparedStatement.setInt(5, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return product;
	}

	@Override
	public void readByAll() {
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ALL);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	@Override
	public void readByName() throws SQLException {
		try {
			preparedStatement = connection.prepareStatement(READ_BY_NAME);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		
		
	}

	@Override
	public void readByPages() throws SQLException {
		try {
			preparedStatement = connection.prepareStatement(READ_BY_PAGES);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		
		
	}

	@Override
	public void readByPrice() throws SQLException {
		try {
			preparedStatement = connection.prepareStatement(READ_BY_PRICE);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		
		
	}

	@Override
	public List<Magazine> readAll() {
		List<Magazine> product = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ALL);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				product.add(ProductMapper.map(resultSet));
			}
		} 
		catch (Exception e) {
			LOGGER.error(e);
		}
			return product;
	}

}
