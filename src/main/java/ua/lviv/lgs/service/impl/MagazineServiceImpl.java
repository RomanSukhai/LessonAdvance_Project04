package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.MagazineDao;
import ua.lviv.lgs.dao.daoimpl.MagazineDaoImpl;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.service.MagazineService;

public class MagazineServiceImpl implements MagazineService{
	private MagazineDao productDao;
	private static MagazineService magazineServiceImpl;
	private static final Logger LOGGER = Logger.getLogger(MagazineServiceImpl.class);

	private MagazineServiceImpl() {
		try {
			productDao = new MagazineDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
	}
	public static MagazineService getMagazineServiceImpl() {
		if(magazineServiceImpl==null) {
			magazineServiceImpl=new MagazineServiceImpl();
		}
		return magazineServiceImpl;
	}

	@Override
	public void readByAll() throws SQLException {
		try {
			productDao.readAll();
		} catch (Exception e) {
			LOGGER.error(e);
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
	@Override
	public Map<Integer,Magazine> readAllMap() throws SQLException, Exception {
		List<Magazine> list = readAll();
		return list.stream().collect(Collectors.toMap(Magazine::getId, Function.identity()));
	}
	

	
}
