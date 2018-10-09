package sos.haruhi.shiro.dao.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import sos.haruhi.shiro.dao.IUserDao;
import sos.haruhi.shiro.vo.User;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/10/9 21:23
 * @Version 10032
 **/
@Repository
public class UserDao implements IUserDao {

    @Resource
    private JdbcTemplate template;

    @Override
    public User getUserByUsername(String username) {
        String sql = "SELECT USERNAME,PASSWORD FROM T_USER WHERE USERNAME = ?";
        List<User> list = template.query(sql, new String[]{username}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        });
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<String> listRolesByUsername(String username) {
        String sql = "select r.sn as sn from t_role r " +
                "inner join t_user_role ur on ur.role_id = r.id " +
                "inner join t_user u on u.id = ur.user_id " +
                "where u.username = ?";
        List<String> list = template.query(sql, new String[]{username}, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString("sn");
            }
        });
        return list;
    }
}
