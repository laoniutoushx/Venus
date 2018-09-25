package sos.haruhi.shiro.dto;

import sos.haruhi.shiro.model.Role;

/**
 * @ClassName RoleDto
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/23 22:40
 * @Version 10032
 **/
public class RoleDto extends Role {
    private Boolean isChecked;

    public RoleDto(Role role, Boolean isChecked){
        if(isChecked == null){
            this.isChecked = false;
        }else{
            this.isChecked = isChecked;
        }
        super.id = role.getId();
        super.rolename = role.getRolename();
        super.sn = role.getSn();
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }
}
