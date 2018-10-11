package sos.haruhi.shiro.vo;

/**
 * @ClassName User
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/10/8 20:13
 * @Version 10032
 **/
public class User {
    private String username;
    private String password;
    private boolean rememberMe;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
