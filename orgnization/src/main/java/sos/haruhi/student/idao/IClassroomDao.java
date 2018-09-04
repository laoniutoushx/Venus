package sos.haruhi.student.idao;

import sos.haruhi.student.model.Classroom;
import sos.nagato.ibasedao.IBaseDao;
import sos.nagato.pojo.Pager;

public interface IClassroomDao extends IBaseDao<Classroom> {
	
	public Pager<Classroom> find(Integer pid);
	
	public int getMaxOrder(Integer pid);
	
}
