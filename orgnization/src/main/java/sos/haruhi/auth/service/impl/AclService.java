package sos.haruhi.auth.service.impl;

import org.springframework.stereotype.Service;
import sos.haruhi.auth.idao.IAclDao;
import sos.haruhi.auth.iservice.IAclService;
import sos.haruhi.auth.model.Acl;
import sos.haruhi.auth.model.ControllerResources;
import sos.haruhi.auth.model.Role;
import sos.haruhi.auth.model.User;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("aclService")
public class AclService implements IAclService {
	@Resource
	private IAclDao aclDao;

	@Override
	public Acl loadAcl(int pid, String ptype, int rid, String rtype) {
		return aclDao.loadAcl(pid, ptype, rid, rtype);
	}

	@Override
	public Acl loadAclByRole(int roleId, int rid, String rtype) {
		return aclDao.loadAcl(roleId, Role.PRINCIPAL_TYPE, rid, rtype);
	}

	@Override
	public Acl loadAclByUser(int userId, int rid, String rtype) {
		return aclDao.loadAcl(userId, User.PRINCIPAL_TYPE, rid, rtype);
	}

	@Override
	public List<Integer> listRoleOperIdsByRes(Integer rid, String rtype,
			Integer roleId) {
		return aclDao.listRoleOperIdsByRes(rid, rtype, roleId);
	}

	@Override
	public List<Integer> listUserOperIdsByRes(Integer rid, String rtype,
			Integer userId) {
		return aclDao.listUserOperIdsByRes(rid, rtype, userId);
	}

	@Override
	public List<Integer> listUserSelfOperIdsByRes(Integer rid, String rtype,
			Integer userId) {
		return aclDao.listUserSelfOperIdsByRes(rid, rtype, userId);
	}

	@Override
	public Map<String, List<String>> listAllControllerResAndOperByRole(Integer roleId) {
		return aclDao.listAllResAndOperByRole(roleId, ControllerResources.RES_TYPE);
	}

	@Override
	public Map<String, List<String>> listAllControllerResAndOperByUser(Integer userId) {
		return aclDao.listAllResAndOperByUser(userId, ControllerResources.RES_TYPE);
	}

	@Override
	public List<String> listMenuSnByRole(Integer roleId) {
		return aclDao.listMenuSnByRole(roleId);
	}

	@Override
	public List<String> listMenuSnByUser(Integer userId) {
		return aclDao.listMenuSnByUser(userId);
	}

	@Override
	public List<Integer> listMenuIdByRole(Integer roleId) {
		return aclDao.listMenuIdByRole(roleId);
	}

	@Override
	public List<Integer> listMenuIdByUser(Integer userId) {
		return aclDao.listMenuIdByUser(userId);
	}

	@Override
	public List<Integer> listMenuIdByUserSelf(Integer userId) {
		return aclDao.listMenuIdByUserSelf(userId);
	}

	@Override
	public void add(Acl acl) {
		aclDao.add(acl);
	}
}
