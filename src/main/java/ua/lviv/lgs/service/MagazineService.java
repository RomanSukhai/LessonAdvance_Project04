package ua.lviv.lgs.service;

import java.sql.SQLException;
import java.util.Map;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.shared.AbstractCRUD;

public interface MagazineService extends AbstractCRUD<Magazine>{
	Map<Integer,Magazine> readAllMap() throws SQLException, Exception;
}
