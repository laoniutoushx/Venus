package haruhi.sys.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用来确定组之间的关系
 */
@Entity
@Table(name="t_org_type_rule")
public class OrgTypeRule {
    // 规则标识
    private int id;
    // 规则父 id
    private int pid;
    // 规则子 id
    private int cid;
    // 两者之间的数量, -1 表示 无限个 0 表示 没有
    private int num;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
