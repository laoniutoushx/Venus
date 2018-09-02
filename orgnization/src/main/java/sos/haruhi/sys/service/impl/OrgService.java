package sos.haruhi.sys.service.impl;


import sos.haruhi.sys.dto.TreeDto;
import sos.haruhi.sys.idao.IOrgDao;
import sos.haruhi.sys.idao.IOrgTypeDao;
import sos.haruhi.sys.iservice.IOrgService;
import sos.haruhi.sys.model.Org;
import sos.haruhi.sys.model.SysException;
import org.springframework.stereotype.Service;
import sos.nagato.pojo.Pager;

import javax.annotation.Resource;
import java.util.List;

@Service("orgService")
public class OrgService extends AbstractBaseService implements IOrgService {
	@Resource
	private IOrgDao orgDao;
	
	@Resource
	private IOrgTypeDao orgTypeDao;
	
	private void checkChildOrgNum(Org cOrg, Org pOrg) {
		if(pOrg==null) return;
		int rnum = orgTypeDao.loadOrgRuleNum(pOrg.getTypeId(), cOrg.getTypeId());
		if(rnum<0) return ;
		int hnum = orgDao.loadNumByType(pOrg.getId(), cOrg.getTypeId());
		if(hnum>=rnum)throw new SysException(pOrg.getName()+"下的"+cOrg.getName()+"的数量已经达到最大化");
	}
	
	//parent已经存在的添加
	@Override
	public void add(Org org) {
		checkChildOrgNum(org, org.getParent());
		if(org.getParent()==null) {
			org.setOrderNum(orgDao.getMaxOrder(null)+1);
		} else {
			org.setOrderNum(orgDao.getMaxOrder(org.getParent().getId())+1);
		}
		
		orgDao.add(org);
	}

	@Override
	public void add(Org org, Integer pid) {
		if(pid!=null) {
			Org p = orgDao.load(pid);
			if(p==null) throw new SysException("要添加的父亲组织不存在!");
			checkChildOrgNum(org,p);
			org.setParent(p);
		}
		org.setOrderNum(orgDao.getMaxOrder(pid)+1);
		orgDao.add(org);
	}

	@Override
	public void update(Org org) {
		orgDao.update(org);
	}

	@Override
	public void delete(int id) {
		orgDao.delete(id);
	}

	@Override
	public Org load(int id) {
		return orgDao.load(id);
	}

	@Override
	public Pager<Org> findByParent(Integer pid, Integer typeId) {
		return orgDao.findByParent(pid,typeId);
	}

	@Override
	public List<TreeDto> tree() {
		return orgDao.tree();
	}


	@Override
	public void addRule(int orgId, int cid) {
		orgDao.addRule(orgId, cid);
	}

	@Override
	public void deleteRule(int orgId, int cid) {
		orgDao.deleteRule(orgId, cid);
	}

	@Override
	public List<Integer> listAllChildIdsByOrg(int id) {
		return orgDao.listAllChildIdsByOrg(id);
	}


	@Override
	public List<Org> listAllChildByOrg(int id) {
		return orgDao.listAllChildByOrg(id);
	}

	@Override
	public List<TreeDto> listAllChildTreeByOrg(int id) {
		return orgDao.listAllChildTreeByOrg(id);
	}

	@Override
	public void addRule(int orgId, Integer[] cids) {
		orgDao.addRule(orgId, cids);
	}

	@Override
	public List<Integer> listManagerRuleIds(int orgId) {
		return orgDao.listManagerRuleIds(orgId);
	}

	@Override
	public List<TreeDto> listParentTreeByOrgType(String sn) {
		return orgDao.listParentTreeByOrgType(sn);
	}

}
