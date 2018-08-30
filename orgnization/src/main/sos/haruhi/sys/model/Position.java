package haruhi.sys.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 岗位的对象
 * 用来确认每个人员所属的岗位
 * 存储岗位名称
 * 副校长，校长，副处长，处长
 */
@Entity
@Table(name = "t_position")
public class Position {
    private int id;
    private String name;
    private String sn;
    private int manage;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public int getManage() {
        return manage;
    }

    public void setManage(int manage) {
        this.manage = manage;
    }
}
