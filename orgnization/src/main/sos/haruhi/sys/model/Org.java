package haruhi.sys.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 组织对象，完整的组织树
 * 北科维拓  公司
 * 财务部    部门
 * 张三      人员
 */
@Entity
@Table(name = "t_org")
public class Org {
    /**
     * 组织机构 id
     */
    private int id;
    /**
     * 组织机构 名称
     */
    private String name;
    // 组织机构所属类型 id
    private String typeId;
    // 组织机构所属类型 名称
    private String typeName;
    // 组织序号
    private int orderNum;
    // 父级组织
    private Org parent;
    private String address;
    private String phone;
    // 扩展属性
    private String att1;
    private String att2;
    private String att3;

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

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public Org getParent() {
        return parent;
    }

    public void setParent(Org parent) {
        this.parent = parent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAtt1() {
        return att1;
    }

    public void setAtt1(String att1) {
        this.att1 = att1;
    }

    public String getAtt2() {
        return att2;
    }

    public void setAtt2(String att2) {
        this.att2 = att2;
    }

    public String getAtt3() {
        return att3;
    }

    public void setAtt3(String att3) {
        this.att3 = att3;
    }
}
