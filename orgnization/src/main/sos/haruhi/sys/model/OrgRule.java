package haruhi.sys.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 组织规则表
 *
 * 用来确定 组织 之间的管理关系
 * 用户登录以后 可以管理的组织
 */
@Entity
@Table(name = "t_org_rule")
public class OrgRule {
    // 默认管理类型  ，  一个组织只能管理下面的所有 子组织
    public static int DEFAULT_TYPE = 0;
    // 可以管理所有组织机构
    public static int ALL_TYPE = 1;
    // 自定义管理类型，为该类型时，需要到 managerOrg  获取所有可以管理的组织
    public static int DEF_TYPE = 2;

    // 不具备管理功能
    public static int NO_TYPE = -1;

    private int id;
    // 组织 id
    private int orgId;

    /**
     * 具体的管理组织 ，当管理类型为 DEF_TYPE 时，就从改字段中找到所有可以管理的组织
     * 2|3|4
     * 这里存储的是管理组织的根组织
     */

    private String managerOrg;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getManagerOrg() {
        return managerOrg;
    }

    public void setManagerOrg(String managerOrg) {
        this.managerOrg = managerOrg;
    }
}
