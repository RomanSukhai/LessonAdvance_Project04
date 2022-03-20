package ua.lviv.lgs.service;
import java.util.List;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.shared.AbstractCRUD;

public interface BucketService extends AbstractCRUD<Bucket>{
	public List<Integer> readAllId();
}
