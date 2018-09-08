package sos.haruhi.auth.model;

import javax.persistence.*;

/**
 * @ClassName MenuResources
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/6 20:43
 * @Version 10032
 **/
@Entity
@Table(name = "t_menu_resources")
public class MenuResources implements SystemResources {

    public static final String RES_TYPE = "controller";

    private int id;
    private String name;
    private String sn;
    private MenuPosition menuPosition;
    private String href;
    private String icon;
    private int orderNum;
    private int display;
    private MenuResources parent;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /***
     * 菜单中文名称
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /***
     * 菜单 sn，不能重复，通过这个 sn 自动生成页面的超链接，然后为超链接增加一个属性 auth_sn，这个值就是 sn
     * @return
     */
    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    /***
     * 菜单所在位置
     * @return
     */
    @Column(name = "menu_position")
    public MenuPosition getMenuPosition() {
        return menuPosition;
    }

    public void setMenuPosition(MenuPosition menuPosition) {
        this.menuPosition = menuPosition;
    }

    /***
     * 菜单超链接
     * @return
     */
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    /***
     * 菜单图标
     * @return
     */
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    /***
     * 菜单的排序号
     * @return
     */
    @Column(name = "order_num")
    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    /***
     * 是否显示菜单  1 显示  0  不显示
     * @return
     */
    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }

    /***
     * 菜单的父菜单，方便初始化操作，授权时候方便
     * @return
     */
    @ManyToOne
    @JoinColumn(name = "pid")
    public MenuResources getParent() {
        return parent;
    }

    public void setParent(MenuResources parent) {
        this.parent = parent;
    }
}
