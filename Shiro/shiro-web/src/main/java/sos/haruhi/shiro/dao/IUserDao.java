package sos.haruhi.shiro.dao;

import sos.haruhi.shiro.vo.User;

import java.util.List;

/**
 * @ClassName IUserDao
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/10/9 21:23
 * @Version 10032
 **/
public interface IUserDao {
    User getUserByUsername(String username);

    List<String> listRolesByUsername(String username);
}
