package sos.haruhi.shiro.filter;

import org.apache.shiro.web.filter.PathMatchingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sos.haruhi.shiro.realm.UserRealm;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Arrays;

/**
 * @ClassName MyPathMatchingFilter
 * @Description 请求地址匹配
 * @Author Suzumiya Haruhi
 * @Date 2018/9/23 12:27
 * @Version 10032
 **/
public class MyPathMatchingFilter extends PathMatchingFilter {
    private static final Logger logger = LoggerFactory.getLogger(MyPathMatchingFilter.class);

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        logger.info("path matching");
        logger.info(Arrays.toString((String[]) mappedValue));
        return super.onPreHandle(request, response, mappedValue);
    }
}
