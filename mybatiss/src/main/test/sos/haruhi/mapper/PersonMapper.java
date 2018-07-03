package sos.haruhi.mapper;

import sos.haruhi.pojo.Person;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>sos.haruhi.mapper</h3>
 * @Description <p> xml 映射 </p>
 * @Author SuzumiyaHaruhi
 * @Time 2018/6/14 14:08:33
 * @Version v1.0
 */
public interface PersonMapper {
    void addPerson(Person person);
    Person getPersonById(int id);
}
