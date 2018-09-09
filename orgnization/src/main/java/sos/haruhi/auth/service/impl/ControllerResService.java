package sos.haruhi.auth.service.impl;

import org.springframework.stereotype.Service;
import sos.haruhi.auth.annotation.AuthOper;
import sos.haruhi.auth.annotation.Res;
import sos.haruhi.auth.idao.IControllerResDao;
import sos.haruhi.auth.iservice.IControllerResService;
import sos.haruhi.auth.model.ControllerOper;
import sos.haruhi.auth.model.ControllerResources;
import sos.haruhi.sys.dto.TreeDto;
import sos.haruhi.sys.kit.BasicSysKit;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Service("controllerResService")
public class ControllerResService implements IControllerResService {
	@Resource
	private IControllerResDao controllerResDao;
	
	@Override
	public void addResources(ControllerResources cr, String psn) {
		controllerResDao.addResources(cr, psn);
	}

	@Override
	public void addOper(ControllerOper oper, String rsn) {
		controllerResDao.addOper(oper, rsn);
	}

	@Override
	public void updateOper(ControllerOper oper) {
		controllerResDao.updateOper(oper);
	}

	@Override
	public void deleteOper(int operId) {
		controllerResDao.deleteOper(operId);
	}

	@Override
	public List<ControllerResources> listResByParent(Integer pid) {
		controllerResDao.listResByParent(pid);
		return null;
	}

	@Override
	public List<ControllerOper> listOperByRes(Integer rid) {
		return controllerResDao.listOperByRes(rid);
	}

	@Override
	public ControllerOper loadOperById(int operId) {
		return controllerResDao.loadOperById(operId);
	}

	@Override
	public ControllerOper loadOperBySn(String rsn, String sn) {
		return controllerResDao.loadOperBySn(rsn, sn);
	}

	@Override
	public List<TreeDto> tree() {
		return controllerResDao.tree();
	}

	@Override
	public void add(ControllerResources cr) {
		controllerResDao.addResources(cr, cr.getPsn());
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void initControllerRes(String[] packages) {
		List<Class> clzs = new ArrayList<Class>();
		List<Class> tmpClzs = null;
		for(String p:packages) {
			tmpClzs = BasicSysKit.listByClassAnnotation(p, Res.class);
			BasicSysKit.mergeList(clzs, tmpClzs);
		}
		for(Class c:clzs) {
			ControllerResources cr = addResources(c);
			addAuthOper(c,cr);
		}
	}

	@SuppressWarnings({"rawtypes" })
	private void addAuthOper(Class c, ControllerResources cr) {
		Method[] ms = c.getDeclaredMethods();
		for(Method m:ms) {
			if(m.isAnnotationPresent(AuthOper.class)) {
				addControllerOper(m,cr);
			}
		}
	}

	private void addControllerOper(Method m, ControllerResources cr) {
		String mname = m.getName();
		AuthOper ao = m.getAnnotation(AuthOper.class);
		String sn = getOperSn(mname,ao);
		ControllerOper co = this.loadOperBySn(cr.getSn(), sn);
		if(co==null) co = new ControllerOper();
		co.setMethodName(mname);
		co.setSn(sn);
		co.setName(getOperName(mname,ao));
		co.setIndexPos(getOperIndex(mname,ao));
		this.addOper(co, cr.getSn());
	}

	private int getOperIndex(String mname, AuthOper ao) {
		if(ao.index()>=0) return ao.index();
		if(mname.startsWith("add")) return 0;
		else if(mname.startsWith("update")) return 2;
		else if(mname.startsWith("delete")) return 3;
		else return 1;
	}

	private String getOperName(String mname, AuthOper ao) {
		if(!BasicSysKit.isEmpty(ao.name())) return ao.name();
		if(mname.startsWith("add")) return "添加";
		else if(mname.startsWith("update")) return "更新";
		else if(mname.startsWith("delete")) return "删除";
		else return "读取";
	}

	private String getOperSn(String mname, AuthOper ao) {
		if(!BasicSysKit.isEmpty(ao.sn())) return ao.sn();
		if(mname.startsWith("add")) return "ADD";
		else if(mname.startsWith("update")) return "UPDATE";
		else if(mname.startsWith("delete")) return "DELETE";
		else return "READ";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private ControllerResources addResources(Class c) {
		Res res = (Res)c.getAnnotation(Res.class);
		String sn = res.sn();
		ControllerResources cr = controllerResDao.loadBySn(sn);
		if(cr==null) cr = new ControllerResources();
		cr.setClassName(c.getName());
		cr.setName(res.name());
		cr.setOrderNum(res.orderNum());
		cr.setSn(sn);
		this.addResources(cr, res.psn());
		return cr;
	}

}
