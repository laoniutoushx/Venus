package sos.haruhi.sys.idao;


import sos.haruhi.sys.dto.PersonDto;
import sos.haruhi.sys.model.Person;
import sos.haruhi.sys.model.PersonOrgPos;
import sos.nagato.ibasedao.IBaseDao;
import sos.nagato.pojo.Pager;

import java.util.List;

public interface IPersonDao extends IBaseDao<Person> {
	/**
	 * 根据组织和岗位来获取所有的人员,组织id必须存在，岗位id如果不存在获取这个组织中的所有人员
	 * @param oid
	 * @return
	 */
	public Pager<Person> findByOrg(int oid, Integer posId);
	
	public Pager<PersonDto> findPersonAndPosByOrg(int oid, Integer posId);
	
	public List<PersonDto> listPersonAndPosByOrg(int oid, Integer posId);
	
	public void addPersonOrgPos(PersonOrgPos pop);
}
