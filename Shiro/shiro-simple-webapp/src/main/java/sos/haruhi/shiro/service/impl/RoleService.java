package sos.haruhi.shiro.service.impl;

import org.springframework.stereotype.Service;
import sos.haruhi.shiro.dao.IRoleDao;
import sos.haruhi.shiro.model.Res;
import sos.haruhi.shiro.model.Role;
import sos.haruhi.shiro.model.RoleRes;
import sos.haruhi.shiro.model.UserRole;
import sos.haruhi.shiro.service.IRoleService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName RoleService
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/18 21:51
 * @Version 10032
 **/
@Service
public class RoleService implements IRoleService {
    @Resource
    private IRoleDao roleDao;

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public void delete(int id) {
        roleDao.delete(id);
    }

    @Override
    public void update(Role role) {
        roleDao.update(role);
    }

    @Override
    public Role load(int id) {
        return roleDao.load(id);
    }

    @Override
    public List<Role> list() {
        return roleDao.list();
    }

    @Override
    public List<Role> listRolesOfUser(int userId) {
        return roleDao.listRolesOfUser(userId);
    }

    @Override
    public UserRole loadUserRole(int userId, int roleId) {
        return roleDao.loadUserRole(userId, roleId);
    }

    @Override
    public void addUserRole(int userId, int roleId) {
        roleDao.addUserRole(userId, roleId);
    }

    @Override
    public void deleteUserRole(int userId, int roleId) {
        roleDao.deleteUserRole(userId, roleId);
    }

    @Override
    public void deleteRoleOfUser(int userId, int roleId) {
        roleDao.deleteRoleOfUser(userId, roleId);
    }

    @Override
    public List<Res> listResesByRole(int roleId) {
        return roleDao.listResesByRole(roleId);
    }

    @Override
    public void addRoleRes(int roleId, int resId) {
        roleDao.addRoleRes(roleId, resId);
    }

    @Override
    public void deleteRoleRes(int roleId, int resId) {
        roleDao.deleteRoleRes(roleId, resId);
    }

    @Override
    public RoleRes loadRoleRes(int roleId, int resId) {
        return roleDao.loadRoleRes(roleId, resId);
    }
}
