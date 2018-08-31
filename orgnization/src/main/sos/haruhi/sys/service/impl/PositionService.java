package haruhi.sys.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.konghao.sys.org.idao.IPositionDao;
import org.konghao.sys.org.iservice.IPositionService;
import org.konghao.sys.org.model.Position;
import org.konghao.sys.org.model.SysException;
import org.springframework.stereotype.Service;

@Service("positionService")
public class PositionService extends AbstractBaseService implements
		IPositionService {
	@Inject
	private IPositionDao positionDao;
	
	@Override
	public void add(Position pos) {
		if(positionDao.loadBySn(pos.getSn())!=null) throw new SysException("添加的岗位的sn已经存在");
		positionDao.add(pos);
	}

	@Override
	public void update(Position pos) {
		//if(positionDao.loadBySn(pos.getSn())!=null) throw new SysException("添加的岗位的sn已经存在");
		positionDao.update(pos);
	}

	@Override
	public void delete(int id) {
		positionDao.delete(id);
	}

	@Override
	public Position load(int id) {
		return positionDao.load(id);
	}

	@Override
	public List<Position> find() {
		return positionDao.find();
	}

	@Override
	public List<Position> listByOrg(int orgId) {
		return positionDao.listByOrg(orgId);
	}

}
