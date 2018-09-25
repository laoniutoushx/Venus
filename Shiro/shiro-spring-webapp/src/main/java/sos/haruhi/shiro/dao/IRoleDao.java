package sos.haruhi.shiro.dao;

import sos.haruhi.shiro.model.Res;
import sos.haruhi.shiro.model.RoleRes;
import sos.haruhi.shiro.model.Role;
import sos.haruhi.shiro.model.UserRole;
import sos.nagato.ibasedao.IBaseDao;

import java.util.List;

public interface IRoleDao extends IBaseDao<Role> {
    public List<Role> list();

    public List<Role> listRolesOfUser(int userId);

    public List<Integer> listRoleIdsOfUser(int userId);

    public UserRole loadUserRole(int userId, int roleId);

    public void addUserRole(int userId, int roleId);

    public void deleteUserRole(int userId, int roleId);

    /**
     * @title:
     * @desc:   删除某个用户角色
     * @param:
     * @return:
     * @auther: Suzumiya Haruhi
     * @date:   2018/9/18 20:35
     **/
    public void deleteRoleOfUser(int userId, int roleId);

    public List<Res> listResesByRole(int roleId);

    public void addRoleRes(int roleId, int resId);

    public void deleteRoleRes(int roleId, int resId);

    public RoleRes loadRoleRes(int roleId, int resId);
}
