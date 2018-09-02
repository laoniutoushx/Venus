package sos.haruhi.sys.service.impl;


import sos.haruhi.sys.idao.IPositionDao;
import sos.haruhi.sys.iservice.IPositionService;
import sos.haruhi.sys.model.Position;
import sos.haruhi.sys.model.SysException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("positionService")
public class PositionService extends AbstractBaseService implements
		IPositionService {
	@Resource
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
