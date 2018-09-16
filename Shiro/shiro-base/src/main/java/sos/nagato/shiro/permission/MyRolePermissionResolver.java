package sos.nagato.shiro.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

import java.util.Arrays;
import java.util.Collection;

/**
 * @ClassName MyRolePermissionResolver
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/16 22:15
 * @Version 10032
 **/
public class MyRolePermissionResolver implements RolePermissionResolver {
    @Override
    public Collection<Permission> resolvePermissionsInRole(String s) {
        if(s.contains("admin")){
            return Arrays.asList((Permission)new WildcardPermission("classroom:*"));
        }
        return null;
    }
}
