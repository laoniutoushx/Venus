package sos.haruhi.web;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import sos.haruhi.sys.iservice.IOrgTypeService;
import sos.haruhi.web.context.BeanFactoryContext;
import sos.haruhi.web.kit.RefreshKit;
import sos.nagato.util.PropertiesUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

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

        List<String> orgTypes = initOrg();
        List<Integer> otids = initOrgTypeId(applicationContext, orgTypes);
        System.out.println(otids);
        config.getServletContext().setAttribute("existOrgTypes", otids);
        initLeftNavMenu(config.getServletContext());
    }

    private void initLeftNavMenu(ServletContext servletContext) {
        RefreshKit.refreshLeftMenu(servletContext);
    }


    private List<Integer> initOrgTypeId(WebApplicationContext wc,List<String> orgTypes) {
        IOrgTypeService orgTypeService = (IOrgTypeService)wc.getBean("orgTypeService");
        List<Integer> otids = new ArrayList<Integer>();
        for(String ot:orgTypes) {
            otids.add(orgTypeService.loadBySn(ot).getId());
        }
        return otids;
    }

    @SuppressWarnings("rawtypes")
    private List<String> initOrg() {
        Properties prop = PropertiesUtil.getInstance().load("zzjg");
        Enumeration e =  prop.propertyNames();
        List<String> orgs = new ArrayList<String>();
        while(e.hasMoreElements()) {
            orgs.add(prop.getProperty(e.nextElement().toString()));
        }
        return orgs;
    }

    public static String getRealpath() {
        return realpath;
    }

    public static WebApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
