package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.BucketDao;
import ua.lviv.lgs.dao.daoimpl.BucketDaoImpl;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.service.BucketService;
import ua.lviv.lgs.servlet.Product;

public class BucketServiceImpl implements BucketService{
	private BucketDao bucketDao;
	private static BucketService bucketServiceImpl;
	private static final Logger LOGGER = Logger.getLogger(BucketServiceImpl.class);
	
	private BucketServiceImpl() {
		try {
			bucketDao = new BucketDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
	}
	public static BucketService getBucketServiceImpl() {
		if(bucketServiceImpl==null) {
			bucketServiceImpl=new BucketServiceImpl();
		}
		return bucketServiceImpl;
	}

	@Override
	public void readByAll() throws SQLException {
		try {
			bucketDao.readByAll();
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public Bucket create(Bucket bucket) throws SQLException {
		return bucketDao.create(bucket);
	}

	@Override
	public Bucket read(Integer id) throws SQLException {
		return bucketDao.read(id);
	}

	@Override
	public Bucket update(Bucket bucket, Integer id) throws SQLException {
		return bucketDao.update(bucket, id);
	}

	@Override
	public void delete(Integer id) throws SQLException {
		bucketDao.delete(id);
	}

	@Override
	public void dropTableIfExists() throws SQLException {
		bucketDao.dropTableIfExists();
	}

	@Override
	public List<Bucket> readAll() throws SQLException, Exception {
		return bucketDao.readAll();
	}
	@Override
	public List<Integer> readAllId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
