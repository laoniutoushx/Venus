package sos.haruhi.shiro.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName ResCheckFilter
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/23 12:54
 * @Version 10032
 **/
public class ResCheckFilter extends AccessControlFilter {
    private String errorUrl;

    public String getErrorUrl() {
        return errorUrl;
    }

    public void setErrorUrl(String errorUrl) {
        this.errorUrl = errorUrl;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = super.getSubject(request, response);
        String urlPatternString = super.getPathWithinApplication(request);
        System.out.println(urlPatternString);
        return subject.isPermitted(urlPatternString);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.sendRedirect(getErrorUrl());
        return false;
    }
}
