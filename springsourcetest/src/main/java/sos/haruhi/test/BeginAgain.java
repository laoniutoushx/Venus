package sos.haruhi.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sos.haruhi.i.IHaruhi;

import javax.annotation.Resource;

@Resource
public class BeginAgain implements IHaruhi {
    @Autowired
    private HelloWorld helloWorld;

    public HelloWorld getHelloWorld() {
        return helloWorld;
    }
    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public static void main(String[] args) {
//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-context.xml");
//        HelloWorld helloWorld = (HelloWorld) beanFactory.getBean("hello");
        System.out.println(getHelloWorld().getName());
        Thread.currentThread().getContextClassLoader();
    }

    public Object draw() {
        return null;
    }

    public String sayHello() {
        return null;
    }

    public Object walk() {
        return null;
    }

    public Object sleep() {
        return null;
    }

    public Object watch() {
        return null;
    }
}
