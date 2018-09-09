package sos.haruhi.auth.model;

import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName ACL
 * @Description 权限控制关键类，储存主题和资源之间的关系，确定主题能偶对哪些资源进行那些操作
 * @Author Suzumiya Haruhi
 * @Date 2018/9/6 21:06
 * @Version 10032
 **/
@Entity
@Table(name = "t_acl")
public class ACL {
    private int id;
    private String ptype;
    private String rtype;
    private int pid;
    private int rid;
    private int aclState;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /***
     * 主体类型     user role 静态属性 PRINCIPAL_TYPE
     * @return
     */
    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    /***
     * 资源类型     controller menu 静态属性 PRINCIPAL_TYPE
     * @return
     */
    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }

    /***
     * 主体的 id
     * @return
     */
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    /***
     * 资源 id
     * @return
     */
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    /***
     * 对方发的操作状态，存储 一个 32位 整数，可以存储 0~31 位的操作
     * 00000.....1011  CRD
     * 11
     * @return
     */
    public int getAclState() {
        return aclState;
    }

    public void setAclState(int aclState) {
        this.aclState = aclState;
    }

    /**
     * @desc:   设置 类型
     * @auther: Suzumiya Haruhi
     * @date:   2018/9/8 17:25
     **/
    public void setMenuType(){
        this.rtype = MenuResources.RES_TYPE;
    }

    public void setControllerType(){
        this.rtype = ControllerResources.RES_TYPE;
    }

    public void setUserType(){
        this.ptype = User.PRINCIPAL_TYPE;
    }

    public void setRoleType(){
        this.rtype = Role.PRINCIPAL_TYPE;
    }

    /**
     * @title:  setPermission
     * @desc:   设置权限的具体操作，在某个位置设置操作的权限
     * @param:  [pos, permit]   位置，是否可以
     * @return: void
     * @auther: Suzumiya Haruhi
     * @date:   2018/9/8 17:30
     **/
    public void setPermission(int pos, boolean permit){
        Assert.isTrue(pos > -1 && pos < 32, "操作越界");
//        int tarPosNum = (int) Math.pow(2, pos);
        int tarPosNum = 1 << pos;        // 位运算
        if(permit) {    // 设置 为 1
            // 或运算，只有有一位为 1， 则结果为 1
            this.aclState = this.aclState | tarPosNum;
        }else{          // 设置 为 0
            // 指定位置设置为 1
//            tarPosNum = this.aclState | tarPosNum;
            // 指定位置取反
//            this.aclState = tarPosNum - (1 << pos);

            tarPosNum = ~ tarPosNum;
            this.aclState = this.aclState & tarPosNum;

        }
    }

    /**
     * @title:  checkPermission
     * @desc:    检查某个位置的权限
     * @param:  [pos]
     * @return: boolean
     * @auther: Suzumiya Haruhi
     * @date:   2018/9/8 17:32
     **/
    public boolean checkPermission(int pos){
        Assert.isTrue(pos > -1 && pos < 32, "操作越界");
        int tarPosNum = 1 << pos;
        return (this.aclState & tarPosNum) > 0;
    }
    public static boolean checkPermission(int pos, int state){
        Assert.isTrue(pos > -1 && pos < 32, "操作越界");
        int tarPosNum = 1 << pos;
        return (state & tarPosNum) > 0;
    }
}
