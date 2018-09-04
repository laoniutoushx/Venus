package sos.haruhi.student.service.impl;


import org.springframework.stereotype.Service;
import sos.haruhi.student.dto.TeacherDto;
import sos.haruhi.student.idao.ITeacherDao;
import sos.haruhi.student.iservice.ITeacherService;
import sos.haruhi.student.model.Teacher;
import sos.haruhi.sys.idao.IPersonDao;
import sos.haruhi.sys.model.Person;
import sos.nagato.pojo.Pager;

import javax.annotation.Resource;

@Service("teacherService")
public class TeacherService implements ITeacherService {
	@Resource
	private ITeacherDao teacherDao;
	@Resource
	private IPersonDao personDao;
	
	@Override
	public void add(Teacher teacher) {
		Person p = new Person();
		p.setName(teacher.getName());
		p.setPhone(teacher.getPhone());
		p.setSex(teacher.getSex());
		p.setSfzh(teacher.getSfzh());
		personDao.add(p);
		teacher.setPersonId(p.getId());
		teacherDao.add(teacher);
	}

	@Override
	public void update(Teacher teacher) {
		Person p = personDao.load(teacher.getPersonId());
		p.setName(teacher.getName());
		p.setPhone(teacher.getPhone());
		p.setSex(teacher.getSex());
		p.setSfzh(teacher.getSfzh());
		personDao.update(p);
		teacherDao.update(teacher);
	}

	@Override
	public Teacher load(int id) {
		return teacherDao.load(id);
	}

	@Override
	public Pager<TeacherDto> find(Integer pid) {
		return teacherDao.find(pid);
	}

}
