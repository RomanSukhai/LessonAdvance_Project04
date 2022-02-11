package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;
import ua.lviv.lgs.dao.MagazineDao;
import ua.lviv.lgs.dao.daoimpl.MagazineDaoImpl;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.service.MagazineService;

public class MagazineServiceImpl implements MagazineService{
	MagazineDao productDao;
	
	public MagazineServiceImpl() {
		try {
			productDao = new MagazineDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readByAll() throws SQLException {
		try {
			productDao.readAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Magazine create(Magazine product) throws SQLException {
		return productDao.create(product);
	}

	@Override
	public Magazine read(Integer id) throws SQLException {
		return productDao.read(id);
	}

	@Override
	public Magazine update(Magazine product, Integer id) throws SQLException {
		return productDao.update(product, id);
	}

	@Override
	public void delete(Integer id) throws SQLException {
		productDao.delete(id);
	}

	@Override
	public void dropTableIfExists() throws SQLException {
		productDao.dropTableIfExists();
	}

	@Override
	public List<Magazine> readAll() throws SQLException, Exception {
		return productDao.readAll();
	}

	

	
}
