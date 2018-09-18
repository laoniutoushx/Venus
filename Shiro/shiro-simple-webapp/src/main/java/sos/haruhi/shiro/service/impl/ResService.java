package sos.haruhi.shiro.service.impl;

import org.springframework.stereotype.Service;
import sos.haruhi.shiro.dao.IResDao;
import sos.haruhi.shiro.model.Res;
import sos.haruhi.shiro.service.IResService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ResService
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/18 21:57
 * @Version 10032
 **/
@Service
public class ResService implements IResService {

    @Resource
    private IResDao resDao;

    @Override
    public void add(Res res) {
        resDao.add(res);
    }

    @Override
    public void update(Res res) {
        resDao.update(res);
    }

    @Override
    public void delete(int id) {
        resDao.delete(id);
    }

    @Override
    public Res load(int id) {
        return resDao.load(id);
    }

    @Override
    public List<Res> list() {
        return resDao.list();
    }
}
