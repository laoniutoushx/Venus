package com.haruhi.ws;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>com.haruhi.ws</h3>
 * @Description <p></p>
 * @Author SuzumiyaHaruhi
 * @Time 2018/1/1 22:13:38
 * @Version v1.0
 */
public class AppTest {
    public static void main(String[] args) {
        ServiceImplService s = new ServiceImplService();
        IService service = s.getServiceImplPort();
        User user = service.login("haruhi", "6656200");
        System.out.println(user);
    }
}
