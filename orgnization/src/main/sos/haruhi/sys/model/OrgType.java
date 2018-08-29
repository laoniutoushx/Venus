package haruhi.sys.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 组织机构类型，用来设定系统中存在哪些组织类型
 * 学校 -》 分校区 -》 校长办  行政部门 专业 班级
 */
@Entity
@Table(name = "t_org_type")
public class OrgType {
    /**
     * 类型标识
     */
    private int id;
    /**
     * 类型的名称
     */
    private String name;
    /**
     * 类型的sn序号
     */
    private String sn;

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
}
