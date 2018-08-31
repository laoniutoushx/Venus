package haruhi.sys.dao;

import java.util.List;

import org.konghao.basic.dao.BaseDao;
import org.konghao.basic.model.Pager;
import org.konghao.sys.org.dto.PersonDto;
import org.konghao.sys.org.idao.IPersonDao;
import org.konghao.sys.org.model.Person;
import org.konghao.sys.org.model.PersonOrgPos;
import org.springframework.stereotype.Repository;

@Repository("personDao")
public class PersonDao extends BaseDao<Person> implements IPersonDao {

	@Override
	public Pager<Person> findByOrg(int oid, Integer posId) {
		String hql = "select p from Person p,PersonOrgPos pop where p.id=pop.personId and pop.orgId=? ";
		if(posId!=null) {
			hql+=" and pop.posId="+posId;
		}
		return super.find(hql, oid);
	}


	@Override
	public void addPersonOrgPos(PersonOrgPos pop) {
		super.addEntity(pop);
	}

	@Override
	public Pager<PersonDto> findPersonAndPosByOrg(int oid, Integer posId) {
		String hql = "select new org.konghao.sys.org.dto.PersonDto(p.id,p.name,p.sfzh,p.sex,p.phone,pos.name,pos.id) " +
				"from Person p,PersonOrgPos pop,Position pos where p.id=pop.personId and pos.id=pop.posId and pop.orgId=? ";
		if(posId!=null) {
			hql+=" and pop.posId="+posId;
		}
		return super.findObj(hql, oid);
	}


	@Override
	public List<PersonDto> listPersonAndPosByOrg(int oid, Integer posId) {
		String hql = "select new org.konghao.sys.org.dto.PersonDto(p.id,p.name,p.sfzh,p.sex,p.phone,pos.name,pos.id) " +
				"from Person p,PersonOrgPos pop,Position pos where p.id=pop.personId and pos.id=pop.posId and pop.orgId=? ";
		if(posId!=null) {
			hql+=" and pop.posId="+posId;
		}
		return super.listObj(hql, oid);
	}

}
