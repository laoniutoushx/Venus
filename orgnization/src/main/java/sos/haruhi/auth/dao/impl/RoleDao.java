package sos.haruhi.auth.dao.impl;


import org.springframework.stereotype.Repository;
import sos.haruhi.auth.idao.IRoleDao;
import sos.haruhi.auth.model.Role;
import sos.nagato.basedao.BaseDao;

import java.util.List;

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
