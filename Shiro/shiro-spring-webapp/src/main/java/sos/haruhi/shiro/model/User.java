package sos.haruhi.shiro.model;

import javax.persistence.*;

/**
 * @ClassName User
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/18 20:05
 * @Version 10032
 **/
@Entity
@Table(name = "t_user")
public class User {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private int status;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.getUsername() + ": " + this.getNickname();
    }
}
