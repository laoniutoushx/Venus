package sos.haruhi.shiro.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * @ClassName UrlPermissionResolver
 * @Description 权限字符串路径解析
 * @Author Suzumiya Haruhi
 * @Date 2018/9/23 13:19
 * @Version 10032
 **/
public class UrlPermissionResolver implements PermissionResolver {
    @Override
    public Permission resolvePermission(String permissionString) {
        if(permissionString.startsWith("/"))
            return new UrlPermission(permissionString);
        return new WildcardPermission(permissionString);
    }
}
