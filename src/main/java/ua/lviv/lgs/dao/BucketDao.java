package ua.lviv.lgs.dao;

import java.sql.SQLException;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.shared.AbstractCRUD;

public interface BucketDao extends AbstractCRUD<Bucket>{
	void readByUser_id() throws SQLException;
	void readByProduct_id() throws SQLException;
	void readByPurchase_date() throws SQLException;
}
