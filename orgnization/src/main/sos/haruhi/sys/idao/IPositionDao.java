package haruhi.sys.idao;

import java.util.List;

import org.konghao.basic.dao.IBaseDao;
import org.konghao.sys.org.model.Position;

public interface IPositionDao extends IBaseDao<Position> {
	public List<Position> find();
	public Position loadBySn(String sn);
	/**
	 * 获取某个组织中存在的所有岗位列表
	 * @param orgId
	 * @return
	 */
	public List<Position> listByOrg(int orgId);
}
