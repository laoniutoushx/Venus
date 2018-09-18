package sos.haruhi.shiro.model;

import javax.persistence.*;

/**
 * @ClassName RoleRes
 * @Description 资源-角色
 * @Author Suzumiya Haruhi
 * @Date 2018/9/18 20:07
 * @Version 10032
 **/
@Entity
@Table(name = "t_role_res")
public class RoleRes {
    private int id;
    private int roleId;
    private int resId;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Column(name = "res_id")
    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
