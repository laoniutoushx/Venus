package sos.haruhi.sys.dao;

import sos.haruhi.sys.idao.IPositionDao;
import sos.haruhi.sys.model.Position;
import org.springframework.stereotype.Repository;
import sos.nagato.basedao.BaseDao;

import java.util.List;

@Repository("positionDao")
public class PositionDao extends BaseDao<Position> implements IPositionDao {

	@Override
	public List<Position> find() {
		return super.list("from Position");
	}

	@Override
	public Position loadBySn(String sn) {
		return (Position)super.loadBySn(sn, Position.class.getName());
	}

	@Override
	public List<Position> listByOrg(int orgId) {
		String hql = "select distinct p from Position p,PersonOrgPos pop where pop.posId=p.id and pop.orgId=?";
		return super.list(hql, orgId);
	}

}
