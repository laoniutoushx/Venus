package sos.nagato.shiro.permission;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * @ClassName MyPermissionResolver
 * @Description 授权信息解析  shiro.ini
 * @Author Suzumiya Haruhi
 * @Date 2018/9/16 21:25
 * @Version 10032
 **/
public class MyPermissionResolver implements PermissionResolver {
    @Override
    public Permission resolvePermission(String s) {
        if(StringUtils.isNotBlank(s) && StringUtils.startsWith(s, "+")){
            return new MyPermission(s);
        }
        return new WildcardPermission(s);
    }
}
