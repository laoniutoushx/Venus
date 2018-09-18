package sos.haruhi.shiro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName Role
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/18 20:06
 * @Version 10032
 **/
@Entity
@Table(name = "t_role")
public class Role {
    private int id;
    private String rolename;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
