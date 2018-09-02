package sos.haruhi.web.context;

import org.springframework.web.context.WebApplicationContext;

public class BeanFactoryContext {
    private static WebApplicationContext applicationContext;

    public static WebApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static void setApplicationContext(WebApplicationContext applicationContext){
        BeanFactoryContext.applicationContext = applicationContext;
    }

    public static Object getService(String serviceName){
        return applicationContext.getBean(serviceName);
    }
}
