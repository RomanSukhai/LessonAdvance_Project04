package ua.lviv.lgs.shared;

import java.sql.SQLException;
import java.util.List;

public interface AbstractCRUD<T> {
	void readByAll() throws SQLException;
	T create(T t) throws SQLException;
	T read(Integer i) throws SQLException;
	T update(T t,Integer id) throws SQLException;
	void delete(Integer id) throws SQLException;
	void dropTableIfExists() throws SQLException;
	List<T> readAll() throws SQLException, Exception;
}
