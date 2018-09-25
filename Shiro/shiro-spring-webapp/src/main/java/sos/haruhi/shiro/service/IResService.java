package sos.haruhi.shiro.service;

import sos.haruhi.shiro.model.Res;

import java.util.List;

public interface IResService {
    public void add(Res res);

    public void update(Res res);

    public void delete(int id);

    public Res load(int id);

    public List<Res> list();
}
