package sos.haruhi.pojo;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>sos.haruhi.pojo</h3>
 * @Description <p></p>
 * @Author SuzumiyaHaruhi
 * @Time 2018/6/14 19:32:09
 * @Version v1.0
 */
public class User {
    private int id;
    private String name;
    private String address;

    public User(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
