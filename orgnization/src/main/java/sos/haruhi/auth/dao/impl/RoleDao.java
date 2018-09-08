package sos.haruhi.auth.dao.impl;


import java.util.List;

import org.konghao.basic.dao.BaseDao;
import org.konghao.sys.auth.idao.IRoleDao;
import org.konghao.sys.auth.model.Role;
import org.springframework.stereotype.Repository;

@Repository("roleDao")
public class RoleDao extends BaseDao<Role> implements IRoleDao {

	@Override
	public List<Role> listRole() {
		return this.list("from Role");
	}

	@Override
	public void deleteRoleUsers(int rid) {
		this.updateByHql("delete UserRole ur where ur.role.id=?",rid);
	}


}
