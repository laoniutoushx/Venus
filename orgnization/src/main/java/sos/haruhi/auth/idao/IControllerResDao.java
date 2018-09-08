package sos.haruhi.auth.idao;

import java.util.List;

import org.konghao.basic.dao.IBaseDao;
import org.konghao.sys.auth.model.ControllerOper;
import org.konghao.sys.auth.model.ControllerResources;
import org.konghao.sys.dto.TreeDto;

public interface IControllerResDao extends IBaseDao<ControllerResources>{
	public void addResources(ControllerResources cr, String psn);
	
	public void addOper(ControllerOper oper, String rsn);
	
	public void updateOper(ControllerOper oper);
	
	public void deleteOper(int operId);
	
	public List<ControllerResources> listResByParent(Integer pid);
	/**
	 * 根据资源id列表资源的操作对象
	 * @param rid
	 * @return
	 */
	public List<ControllerOper> listOperByRes(Integer rid);
	
	public ControllerOper loadOperById(int operId);
	/**
	 * 通过资源的sn和操作的sn获取操作对象
	 * @param rsn
	 * @param sn
	 * @return
	 */
	public ControllerOper loadOperBySn(String rsn, String sn);
	
	public List<TreeDto> tree();
	
	public ControllerResources loadBySn(String sn);
}
