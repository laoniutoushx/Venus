package sos.haruhi.auth.dto;

import java.util.List;

import org.konghao.sys.auth.model.MenuResources;

public class LeftMenuDto implements Comparable<LeftMenuDto>{
	private MenuResources parent;
	private List<MenuResources> childs;
	
	public MenuResources getParent() {
		return parent;
	}
	public void setParent(MenuResources parent) {
		this.parent = parent;
	}
	public List<MenuResources> getChilds() {
		return childs;
	}
	public void setChilds(List<MenuResources> childs) {
		this.childs = childs;
	}
	
	@Override
	public boolean equals(Object obj) {
		LeftMenuDto lmd = (LeftMenuDto)obj;
		return lmd.getParent().getId()==this.getParent().getId();
	}
	
	@Override
	public int compareTo(LeftMenuDto o) {
		if(this.parent.getOrderNum()>o.getParent().getOrderNum()) return 1; 
		else if(this.parent.getOrderNum()<o.getParent().getOrderNum()) return -1;
		else return 0;
	}
}
