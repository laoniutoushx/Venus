package sos.haruhi.auth.model;

/**
 * @title:  MenuPosition
 * @desc:   菜单位置
 * @auther: Suzumiya Haruhi
 * @date:   2018/9/6 20:54
 **/
public enum MenuPosition {
    NAV_LEFT("左边导航"),
    NAV_TOP("顶部菜单"),
    NAV_MODULE("模块导航"),
    NAV_OPER("模块操作");

    private String name;

    MenuPosition(String name) {
        this.name = name;
    }
}
