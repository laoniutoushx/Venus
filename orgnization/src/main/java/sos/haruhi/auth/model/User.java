package sos.haruhi.auth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName User
 * @Description 用户
 * @Author Suzumiya Haruhi
 * @Date 2018/9/6 20:11
 * @Version 10032
 **/
@Entity
@Table(name = "t_user")
public class User implements Principal {

    public static final String PRINCIPAL_TYPE = "user";

    private int id;
    private String username;
    private String nickname;
    private int status;
    private int password;

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

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
