package sos.haruhi.sys.service.impl;


import sos.haruhi.sys.dto.PersonDto;
import sos.haruhi.sys.dto.TreeDto;
import sos.haruhi.sys.idao.IOrgDao;
import sos.haruhi.sys.idao.IPersonDao;
import sos.haruhi.sys.iservice.IPersonService;
import sos.haruhi.sys.kit.BasicSysKit;
import sos.haruhi.sys.model.Org;
import sos.haruhi.sys.model.Person;
import sos.haruhi.sys.model.PersonOrgPos;
import org.springframework.stereotype.Service;
import sos.nagato.pojo.Pager;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("personService")
public class PersonService extends AbstractBaseService implements
		IPersonService {
	
	@Resource
	private IPersonDao personDao;
	@Resource
	private IOrgDao orgDao;

	@Override
	public void add(Person person) {
		personDao.add(person);
	}

	@Override
	public void update(Person person) {
		personDao.update(person);
	}

	@Override
	public void delete(int id) {
		personDao.delete(id);
	}

	@Override
	public Person load(int id) {
		return personDao.load(id);
	}

	@Override
	public Pager<Person> findByOrg(int oid, Integer posId) {
		return personDao.findByOrg(oid, posId);
	}

	@Override
	public void addPersonOrgPos(PersonOrgPos pop) {
		personDao.addPersonOrgPos(pop);
	}

	@Override
	public Pager<PersonDto> findPersonAndPosByOrg(int oid, Integer posId) {
		return personDao.findPersonAndPosByOrg(oid, posId);
	}

	@Override
	public List<Integer> listAllOrgIdByPerson(int pid) {
		List<Org> orgs = orgDao.listPersonOrg(pid);
		List<Integer> ids = new ArrayList<Integer>();
		for(Org org:orgs) {
			List<Integer> tids = orgDao.listAllChildIdsByOrg(org.getId());
			BasicSysKit.mergeList(ids, tids);
		}
		return ids;
	}

	@Override
	public List<TreeDto> listOrgTree(int pid) {
		List<Org> orgs = orgDao.listPersonOrg(pid);
		List<TreeDto> tds = new ArrayList<TreeDto>();
		for(Org org:orgs) {
			List<TreeDto> ttds = orgDao.listAllChildTreeByOrg(org.getId());
			BasicSysKit.mergeList(tds, ttds);
		}
		return tds;
	}
	
	@Override
	public List<Org> listAllOrgByPerson(int pid) {
		List<Org> orgs = orgDao.listPersonOrg(pid);
		List<Org> ors = new ArrayList<Org>();
		for(Org org:orgs) {
			List<Org> tors = orgDao.listAllChildByOrg(org.getId());
			BasicSysKit.mergeList(ors, tors);
		}
		return ors;
	}

	@Override
	public List<TreeDto> listOrgTreeByTypeParent(int pid, String type) {
		return null;
	}

	@Override
	public List<PersonDto> listPersonAndPosByOrg(int oid, Integer posId) {
		return personDao.listPersonAndPosByOrg(oid, posId);
	}

}
