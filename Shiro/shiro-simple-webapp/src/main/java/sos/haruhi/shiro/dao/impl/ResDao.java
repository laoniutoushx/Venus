package sos.haruhi.shiro.dao.impl;

import org.springframework.stereotype.Repository;
import sos.haruhi.shiro.dao.IResDao;
import sos.haruhi.shiro.model.Res;
import sos.nagato.basedao.BaseDao;

import java.util.List;

/**
 * @ClassName ResDao
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/18 21:04
 * @Version 10032
 **/
@Repository
public class ResDao extends BaseDao<Res> implements IResDao {
    @Override
    public List<Res> list() {
        return super.list("from Res");
    }
}
