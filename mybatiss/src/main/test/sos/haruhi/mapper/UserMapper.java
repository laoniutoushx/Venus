package sos.haruhi.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import sos.haruhi.pojo.User;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>sos.haruhi.mapper</h3>
 * @Description <p></p>
 * @Author SuzumiyaHaruhi
 * @Time 2018/6/14 19:32:57
 * @Version v1.0
 */
public interface UserMapper {
    @Insert("insert into user(name, address) values(#{name},#{address})")
    void addUser(User user);

    @Select("select * from user where id = #{id}")
    User loadUser(int id);

//    @SelectKey(statement = "select ")
//    User updateUser(int id);
}
