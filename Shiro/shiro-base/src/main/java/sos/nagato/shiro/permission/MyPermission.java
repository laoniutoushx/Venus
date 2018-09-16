package sos.nagato.shiro.permission;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName MyPermission
 * @Description 授权实现类
 * @Author Suzumiya Haruhi
 * @Date 2018/9/16 21:11
 * @Version 10032
 **/
public class MyPermission implements Permission {
    private static final Logger logger = LoggerFactory.getLogger(MyPermission.class);
    private String resourceId;
    private String operator;
    private String instanceId;

    public MyPermission(){

    }

    public MyPermission(String permissionStr){
        String[] permissionArr = permissionStr.split("\\+");
        if(permissionArr.length > 1){
            this.setResourceId(permissionArr[1]);
        }
        if(StringUtils.isBlank(this.getResourceId())){
            this.setResourceId("*");
        }

        if(permissionArr.length > 2){
            this.setOperator(permissionArr[2]);
        }

        if(permissionArr.length > 3){
            this.setInstanceId(permissionArr[3]);
        }
        if(StringUtils.isBlank(this.getInstanceId())){
            this.setInstanceId("*");
        }
        logger.info(this.toString());
    }

    @Override
    public String toString() {
        return "resourceId:" + this.resourceId + ", operator:" + this.operator
                + ", instanceId:" + this.instanceId;
    }

    @Override
    public boolean implies(Permission permission) {
        if(!(permission instanceof MyPermission)) return false;
        MyPermission mp = (MyPermission) permission;
        if(!this.getResourceId().equals("*") && !mp.getResourceId().equals(this.getResourceId()))
            return false;
        if(!this.getOperator().equals("*") && !mp.getOperator().equals(this.getOperator()))
            return false;
        if(!this.getInstanceId().equals("*") && !mp.getInstanceId().equals(this.getInstanceId()))
            return false;
        return true;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }
}
