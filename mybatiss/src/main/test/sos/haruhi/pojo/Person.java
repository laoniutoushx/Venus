package sos.haruhi.pojo;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>sos.haruhi.pojo</h3>
 * @Description <p></p>
 * @Author SuzumiyaHaruhi
 * @Time 2018/6/13 11:10:10
 * @Version v1.0
 */
public class Person {
    private long id;
    private String name;
    private int age;
    private int sex;

    public Person(long id, String name, int age, int sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
