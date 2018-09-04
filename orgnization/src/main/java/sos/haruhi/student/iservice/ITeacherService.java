package sos.haruhi.student.iservice;

import sos.haruhi.student.dto.TeacherDto;
import sos.haruhi.student.model.Teacher;
import sos.nagato.pojo.Pager;

public interface ITeacherService {
	public void add(Teacher teacher);
	public void update(Teacher teacher);
	public Teacher load(int id);
	public Pager<TeacherDto> find(Integer pid);
}
