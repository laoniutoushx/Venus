package sos.haruhi.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import sos.haruhi.mapper.PersonMapper;
import sos.haruhi.mapper.UserMapper;
import sos.haruhi.pojo.Person;
import sos.haruhi.pojo.User;
import sos.haruhi.util.MyBatisUtil;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>sos.haruhi.test</h3>
 * @Description <p></p>
 * @Author SuzumiyaHaruhi
 * @Time 2018/6/14 15:53:16
 * @Version v1.0
 */
public class PersonMapperTest {
    private static SqlSessionFactory sqlSessionFactory = null;
    static{
        sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    }

    @Test
    public void testAdd(){
        SqlSession session = sqlSessionFactory.openSession();

        try {
            PersonMapper mapper = session.getMapper(PersonMapper.class);
            Person person = new Person(3, "haruhi", 24, 1);
            mapper.addPerson(person);
            session.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Test
    public void testAddByAnnotation(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = new User("haruhi", "losangeles");
            mapper.addUser(user);
            session.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
    }
}
