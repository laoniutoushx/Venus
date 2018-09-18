package sos.haruhi.shiro.model;

import javax.persistence.*;

/**
 * @ClassName UserRole
 * @Description 用户-角色
 * @Author Suzumiya Haruhi
 * @Date 2018/9/18 20:06
 * @Version 10032
 **/
@Entity
@Table(name = "t_user_role")
public class UserRole {
    private int id;
    private int userId;
    private int roleId;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
