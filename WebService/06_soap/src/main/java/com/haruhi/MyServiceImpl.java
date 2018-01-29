package com.haruhi;

import javax.jws.HandlerChain;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "com.haruhi.IMyService")
@HandlerChain(file = "handler-chain.xml")
public class MyServiceImpl implements IMyService {
    private static List<User> users = new ArrayList<>();

    public MyServiceImpl() {
        users.add(new User(1, "admin", "管理员", "123"));
        users.add(new User(2, "zhangsan", "张三", "444"));
    }

    @Override
    public int add(int a, int b) {
        System.out.println("a + b = " + a + b);
        return a + b;
    }

    @Override
    public User addUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User login(String username, String password) throws UserException {
        for(User user:users){
            if(user.getUsername().equals(username)
                    && user.getPassword().equals(password)){
                return user;
            }
        }
        throw new UserException("用户不存在");   // 此处不会抛异常，异常信息通过 SOAP 传递到客户端
    }

    @Override
    public List<User> list() {
        return users;
    }

    @Override
    public List<User> lists(String authInfo) {
        System.out.println(authInfo);
        return users;
    }
}
