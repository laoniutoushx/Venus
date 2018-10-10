package sos.haruhi.shiro.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @ClassName RolesOrFilter
 * @Description 多个角色，满足一个即可
 * @Author Suzumiya Haruhi
 * @Date 2018/10/10 20:29
 * @Version 10032
 **/
public class RolesOrFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        Subject subject = this.getSubject(request, response);
        String[] roles = (String[]) mappedValue;
        if(roles == null || roles.length == 0){
            return true;
        }

        for(String role:roles){
            if(subject.hasRole(role)){
                return true;
            }
        }

        return false;
    }
}
