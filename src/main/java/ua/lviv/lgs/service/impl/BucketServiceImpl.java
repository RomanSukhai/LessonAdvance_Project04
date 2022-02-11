package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.lgs.dao.BucketDao;
import ua.lviv.lgs.dao.daoimpl.BucketDaoImpl;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.service.BucketService;

public class BucketServiceImpl implements BucketService{
	private BucketDao bucketDao;
	
	public BucketServiceImpl() {
		try {
			bucketDao = new BucketDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readByAll() throws SQLException {
		try {
			bucketDao.readAll();
		} catch (Exception e) {
			e.printStackTrace();
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
}
