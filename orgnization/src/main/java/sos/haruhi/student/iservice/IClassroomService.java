package sos.haruhi.student.iservice;

import sos.haruhi.student.model.Classroom;
import sos.nagato.pojo.Pager;

public interface IClassroomService {
	public void add(Classroom classroom, int pid);
	public void update(Classroom classroom);
	public void delete(int id);
	public Classroom load(int id);
	public Pager<Classroom> find(Integer pid);
}
