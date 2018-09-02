package sos.haruhi.web;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import sos.haruhi.web.context.BeanFactoryContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitServlet extends HttpServlet {

    private static WebApplicationContext applicationContext;
    private static String realpath;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // 初始化 spring 工厂
        applicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        realpath = config.getServletContext().getRealPath("");
        BeanFactoryContext.setApplicationContext(applicationContext);
    }

    public static String getRealpath() {
        return realpath;
    }

    public static WebApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
