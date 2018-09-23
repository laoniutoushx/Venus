package sos.haruhi.shiro.model;

import javax.persistence.*;

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
    protected int id;
    protected String sn;

    protected String rolename;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }


}
