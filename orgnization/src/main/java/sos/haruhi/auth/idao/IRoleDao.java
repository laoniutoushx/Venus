package sos.haruhi.auth.idao;

import java.util.List;

import org.konghao.basic.dao.IBaseDao;
import org.konghao.sys.auth.model.Role;

public interface IRoleDao extends IBaseDao<Role> {
	public List<Role> listRole();
	public void deleteRoleUsers(int rid);
}
