package ua.lviv.lgs.dao;

import java.sql.SQLException;

import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.shared.AbstractCRUD;

public interface MagazineDao extends AbstractCRUD<Magazine>{
	void readByName() throws SQLException;
	void readByPages() throws SQLException;
	void readByPrice() throws SQLException;
}
