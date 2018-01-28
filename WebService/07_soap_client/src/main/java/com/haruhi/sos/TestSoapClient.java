package com.haruhi.sos;

import java.util.List;

/**
 * 默认生成的代码，加入头消息之后，格式错了乱
 */
public class TestSoapClient {
    public static void main(String[] args) {
        MyServiceImplService mis = new MyServiceImplService();
        IMyService ms = mis.getMyServiceImplPort();
        List<User> users = ms.lists(null, "aaabbb").getUser();
        for(User user:users){
            System.out.println(user.getNickname());
        }
    }
}
