package sos.haruhi.auth.model;

import javax.persistence.*;

/**
 * @ClassName UserRole
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/6 20:20
 * @Version 10032
 **/
@Entity
@Table(name = "t_user_role")
public class UserRole {
    private int id;
    private User user;
    private Role role;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "uid")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "rid")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
