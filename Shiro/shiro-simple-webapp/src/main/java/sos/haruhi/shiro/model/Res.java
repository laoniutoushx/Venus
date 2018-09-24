package sos.haruhi.shiro.model;

import javax.persistence.*;

/**
 * @ClassName Res
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/18 20:07
 * @Version 10032
 **/
@Entity
@Table(name = "t_res")
public class Res {
    protected int id;
    protected String resname;
    protected String permission;
    protected String url;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResname() {
        return resname;
    }

    public void setResname(String resname) {
        this.resname = resname;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return this.getId() + "|" + this.getUrl() + ": " + this.getResname() + ": " + this.getPermission();
    }
}
