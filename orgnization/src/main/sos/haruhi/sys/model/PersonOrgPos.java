package haruhi.sys.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 人员 组织 岗位 对应关系表
 *
 * 存储人员组织岗位的对应关系
 */
@Entity
@Table(name = "t_person_org_pos")
public class PersonOrgPos {
    /**
     * 关系标识
     */
    private int id;
    // 人员 id
    private int personId;
    // 组织 id
    private int orgId;
    // 岗位 id
    private int posId;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public int getPosId() {
        return posId;
    }

    public void setPosId(int posId) {
        this.posId = posId;
    }
}
