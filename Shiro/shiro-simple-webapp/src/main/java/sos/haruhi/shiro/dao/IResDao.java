package sos.haruhi.shiro.dao;

import sos.haruhi.shiro.model.Res;
import sos.nagato.ibasedao.IBaseDao;

import java.util.List;

public interface IResDao extends IBaseDao<Res> {
    public List<Res> list();
}
