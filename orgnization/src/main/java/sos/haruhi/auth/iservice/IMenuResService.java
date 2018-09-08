package sos.haruhi.auth.iservice;

import java.util.List;

import org.konghao.sys.auth.dto.LeftMenuDto;
import org.konghao.sys.auth.model.MenuResources;
import org.konghao.sys.dto.TreeDto;

public interface IMenuResService {
	
	public void add(MenuResources mr);
	
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
	
	public void initMenuResources(String[] packages);
	
}
