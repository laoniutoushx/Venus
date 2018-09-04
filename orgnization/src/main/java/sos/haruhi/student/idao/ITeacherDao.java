package sos.haruhi.student.idao;

import sos.haruhi.student.dto.TeacherDto;
import sos.haruhi.student.model.Teacher;
import sos.nagato.ibasedao.IBaseDao;
import sos.nagato.pojo.Pager;

public interface ITeacherDao extends IBaseDao<Teacher> {
	
	public Pager<TeacherDto> find(Integer pid);
}
