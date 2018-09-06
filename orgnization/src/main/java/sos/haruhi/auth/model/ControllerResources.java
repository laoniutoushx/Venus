package sos.haruhi.auth.model;

import javax.persistence.*;

/**
 * @ClassName ControllerResources
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/6 20:26
 * @Version 10032
 **/
@Entity
@Table(name = "t_controller_resources")
public class ControllerResources implements SystemResources {

    public static final String PRINCIPAL_TYPE = "controller";

    /*
    资源的标识
     */
    private int id;
    /*
    资源的名称，中文名称，组织机构管理，用户管理
     */
    private String name;
    /*
    资源的唯一标识， 类名
     */
    private String sn;
    /*
    资源父类标识
     */
    private String psn;
    /*
    资源所对应 类：有可能又 多个 类， 所以通过 | 进行分割
    sos.haruhi.web.controller.OrgTypeController|sos.haruhi.web.controller.orgController
     */
    private String className;
    /*
    资源排序号
     */
    private int orderNum;

    /*
    资源的父类，主要功能是为了再授权的时候进行选择，通过树的方式进行选择
     */
    private ControllerResources parent;

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

    public String getPsn() {
        return psn;
    }

    public void setPsn(String psn) {
        this.psn = psn;
    }

    @Column(name = "class_name")
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Column(name = "order_num")
    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    @ManyToOne
    @JoinColumn(name = "pid")
    public ControllerResources getParent() {
        return parent;
    }

    public void setParent(ControllerResources parent) {
        this.parent = parent;
    }
}
