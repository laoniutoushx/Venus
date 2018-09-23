package sos.haruhi.shiro.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;

/**
 * @ClassName UrlPermission
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/23 13:12
 * @Version 10032
 **/
public class UrlPermission implements Permission {
    private String url;

    public UrlPermission() {
    }

    public UrlPermission(String url) {
        this.url = url;
    }

    @Override
    public boolean implies(Permission p) {
        if(p == null) return false;
        if(!(p instanceof UrlPermission)) return false;
        /***
         * /admin/role/**
         */
        UrlPermission urlPermission = (UrlPermission) p;
        PatternMatcher matcher = new AntPathMatcher();
        System.out.println("权限匹配：" + this.getUrl() + ", " + urlPermission.getUrl() + ", "
                + matcher.matches(this.getUrl(), urlPermission.getUrl()));
        return matcher.matches(this.getUrl(), urlPermission.getUrl());
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
