package sos.haruhi.auth.model;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

/**
 * @ClassName ControllerOper
 * @Description controller 操作方法，用来确定某个资源操作对应的方法
 * @Author Suzumiya Haruhi
 * @Date 2018/9/6 20:44
 * @Version 10032
 **/
@Entity
@Table(name = "t_controller_oper")
public class ControllerOper {
    private int id;
    private String sn;
    private String methodName;
    private String name;
    private int indexPos;
    private int rid;
    private String rsn;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /***
     * 资源的标识，默认就通过 ADD,DELETE,UPDATE,READ
     * @return
     */
    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    /***
     * 资源的方法，一个操作默认会对应多个方法   add|addInput
     * 在初始化的时候，可以根据方法的名称来确定，如 add 开头就是 ADD,其他没声明的都是 READ
     * @return
     */
    @Column(name = "method_name")
    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(StringUtils.isBlank(this.methodName)){
            this.methodName = methodName;
        }else{
            if(this.methodName.indexOf(methodName) >= 0){
                // 原有 methodName 已包含
                return;
            }
            this.methodName += "\\|" + methodName;
        }
    }

    /***
     * 方法的索引位置
     * 默认情况：0-->CREATE, 1-->READ, 2-->UPDATE, 3-->DELETE   其他由开发人员手动指定
     * @return
     */
    public int getIndexPos() {
        return indexPos;
    }

    public void setIndexPos(int indexPos) {
        this.indexPos = indexPos;
    }

    /***
     * 所对应的资源 id
     * @return
     */
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    /***
     * 资源 对象 sn
     * @return
     */
    public String getRsn() {
        return rsn;
    }

    public void setRsn(String rsn) {
        this.rsn = rsn;
    }
}
