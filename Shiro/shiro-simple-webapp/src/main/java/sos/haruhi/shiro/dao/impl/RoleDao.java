package sos.haruhi.shiro.dao.impl;

import org.springframework.stereotype.Repository;
import sos.haruhi.shiro.dao.IRoleDao;
import sos.haruhi.shiro.model.Res;
import sos.haruhi.shiro.model.Role;
import sos.haruhi.shiro.model.RoleRes;
import sos.haruhi.shiro.model.UserRole;
import sos.nagato.basedao.BaseDao;

import java.util.List;

/**
 * @ClassName RoleDao
 * @Description 角色操作
 * @Author Suzumiya Haruhi
 * @Date 2018/9/18 21:05
 * @Version 10032
 **/
@Repository
public class RoleDao extends BaseDao<Role> implements IRoleDao {
    @Override
    public List<Role> list() {
        return super.list("from Role");
    }

    @Override
    public List<Role> listRolesOfUser(int userId) {
        return super.list("select r from Role r, UserRole ur, User u " +
                "where r.id = ur.roleId and u.id = ur.userId and u.id = ?", userId);
    }

    @Override
    public List<Integer> listRoleIdsOfUser(int userId) {
        return super.listObj("select r.id from Role r, UserRole ur, User u " +
                "where r.id = ur.roleId and u.id = ur.userId and u.id = ?", userId);
    }

    @Override
    public UserRole loadUserRole(int userId, int roleId) {
        return (UserRole) super.queryObject("from UserRole ur where ur.userId = ? and ur.roleId = ?", userId, roleId);
    }

    @Override
    public void addUserRole(int userId, int roleId) {
        UserRole userRole = this.loadUserRole(userId, roleId);
        if(userRole == null) {
            userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            super.saveOrUpdateEntity(userRole);
        }
    }

    @Override
    public void deleteUserRole(int userId, int roleId) {
        UserRole userRole = this.loadUserRole(userId, roleId);
        if(userRole != null) {
            super.deleteEntity(userRole);
        }
    }

    @Override
    public void deleteRoleOfUser(int userId, int roleId) {
        this.deleteUserRole(userId, roleId);
    }

    @Override
    public List<Res> listResesByRole(int roleId) {
        return super.listObj("select res from Res res, RoleRes rr " +
                "where res.id = rr.resId and rr.roleId = ?", roleId);
    }

    @Override
    public void addRoleRes(int roleId, int resId) {
        RoleRes roleRes = this.loadRoleRes(roleId, resId);
        if(roleRes == null) {
            roleRes = new RoleRes();
            roleRes.setResId(resId);
            roleRes.setRoleId(roleId);
            super.saveOrUpdateEntity(roleRes);
        }
    }

    @Override
    public void deleteRoleRes(int roleId, int resId) {
        RoleRes roleRes = this.loadRoleRes(roleId, resId);
        if(roleRes != null) {
            super.deleteEntity(roleRes);
        }
    }

    @Override
    public RoleRes loadRoleRes(int roleId, int resId) {
        return (RoleRes) super.queryObject("from RoleRes rr where rr.roleId = ? and rr.resId = ?", roleId, resId);
    }
}
