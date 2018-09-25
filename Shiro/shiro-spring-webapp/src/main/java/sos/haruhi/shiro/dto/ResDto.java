package sos.haruhi.shiro.dto;

import sos.haruhi.shiro.model.Res;

/**
 * @ClassName RoleDto
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/23 22:40
 * @Version 10032
 **/
public class ResDto extends Res {
    private Boolean isChecked;

    public ResDto(Res res, Boolean isChecked){
        if(isChecked == null){
            this.isChecked = false;
        }else{
            this.isChecked = isChecked;
        }
        super.id = res.getId();
        super.resname = res.getResname();
        super.url = res.getUrl();
        super.permission = res.getPermission();
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }
}
