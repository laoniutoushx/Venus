package haruhi.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.konghao.basic.model.Pager;
import org.konghao.sys.dto.TreeDto;
import org.konghao.sys.kit.BasicSysKit;
import org.konghao.sys.org.dto.PersonDto;
import org.konghao.sys.org.idao.IOrgDao;
import org.konghao.sys.org.idao.IPersonDao;
import org.konghao.sys.org.iservice.IPersonService;
import org.konghao.sys.org.model.Org;
import org.konghao.sys.org.model.Person;
import org.konghao.sys.org.model.PersonOrgPos;
import org.springframework.stereotype.Service;

@Service("personService")
public class PersonService extends AbstractBaseService implements
		IPersonService {
	
	@Inject
	private IPersonDao personDao;
	@Inject
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
