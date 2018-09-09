package sos.haruhi.auth.idao;

import sos.haruhi.auth.model.Role;
import sos.nagato.ibasedao.IBaseDao;

import java.util.List;

public interface IRoleDao extends IBaseDao<Role> {
	public List<Role> listRole();
	public void deleteRoleUsers(int rid);
}
