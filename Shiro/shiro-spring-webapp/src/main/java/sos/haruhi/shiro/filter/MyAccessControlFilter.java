package sos.haruhi.shiro.filter;

import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @ClassName MyAccessControlFilter
 * @Description 访问控制
 * @Author Suzumiya Haruhi
 * @Date 2018/9/23 12:36
 * @Version 10032
 **/
public class MyAccessControlFilter extends AccessControlFilter {
    private static final Logger logger = LoggerFactory.getLogger(MyAccessControlFilter.class);

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        logger.info("check auth");
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        logger.info("find error");
        return false;
    }


}
