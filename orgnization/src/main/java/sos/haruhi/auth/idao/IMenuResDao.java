package sos.haruhi.auth.idao;

import java.util.List;

import org.konghao.basic.dao.IBaseDao;
import org.konghao.sys.auth.dto.LeftMenuDto;
import org.konghao.sys.auth.model.MenuResources;
import org.konghao.sys.dto.TreeDto;

/**
 * 菜单资源对象的接口
 * @author Konghao
 *
 */
public interface IMenuResDao extends IBaseDao<MenuResources> {

	public void add(MenuResources mr, String psn);
	/**
	 * 根据菜单的位置和父类Menu的sn获取所有的菜单资源对象
	 * @param psn
	 * @param pos
	 * @return
	 */
	public List<MenuResources> listModelMenuByType(String psn, int pos);
	/**
	 * 获取顶部的菜单资源对象
	 * @return
	 */
	public List<MenuResources> listTopMenu();
	/**
	 * 获取左边导航的菜单资源对象
	 * @return
	 */
	public List<LeftMenuDto> listLeftNav();
	
	public List<TreeDto> tree();
	
	public List<MenuResources> listByParent(Integer pid);
	
	public MenuResources loadBySn(String sn);
	
}
