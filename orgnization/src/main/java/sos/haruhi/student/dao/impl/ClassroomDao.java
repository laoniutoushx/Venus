package sos.haruhi.student.dao.impl;


import org.springframework.stereotype.Repository;
import sos.haruhi.student.idao.IClassroomDao;
import sos.haruhi.student.model.Classroom;
import sos.nagato.basedao.BaseDao;
import sos.nagato.pojo.Pager;

@Repository("classroomDao")
public class ClassroomDao extends BaseDao<Classroom> implements IClassroomDao {

	@Override
	public Pager<Classroom> find(Integer pid) {
		if(pid==null) {
			return super.find("from Classroom order by orderNum");
		} else {
			return super.find("from Classroom cla where pid=? order by orderNum",pid);
		}
	}

	@Override
	public int getMaxOrder(Integer pid) {
		String hql = "select max(o.orderNum) from Classroom o where o.pid="+pid;
		if(pid==null||pid==0) hql = "select max(o.orderNum) from Classroom o where o.pid is null";
		Object obj = this.queryObject(hql);
		if(obj==null) return 0;
		return (Integer)obj;
	}

}
