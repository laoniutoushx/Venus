package sos.nagato.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sos.nagato.exception.BaseException;
import sos.nagato.exception.DaoException;
import sos.nagato.ibase.IBaseDao;
import sos.nagato.pojo.Page;

/**
 * 定义DAO的通用操作的实现
 * @describe
 * @project HIGHWAY CONSTRUCTION ENTERPRISE PROJECT MANAGEMENT SYSTEM
 * @author 系统管理员
 * @version 1.0
 * @date 2016年12月20日 上午10:31:23
 * Copyright(c) XZHI All Rights Reserved.
 */
@Repository("baseDao")
public class BaseDaoImpl<T> implements IBaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;    //当前sessionFactory
    private Class<T> clazz;                   //当前泛型类型

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * 获取当前Session
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @return
     */
    public Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    /**
     * 创建SQL查询
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @return
     */
    public SQLQuery executeSQL(String sql) {
        return this.getCurrentSession().createSQLQuery(sql);
    }

    /**
     * 创建HQL查询
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @return
     */
    public Query executeHQL(String hql) {
        return this.getCurrentSession().createQuery(hql);
    }

    /**
     * 获取当前泛型Class
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @return
     */
    @SuppressWarnings("unchecked")
    protected Class<T> getClazz() {
        if(clazz == null){//获取泛型 class
            clazz = (Class<T>) ((java.lang.reflect.ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
        }
        return clazz;
    }

    //保存
    @Override
    public Object save(Object entity) throws BaseException {
        try {
            this.getCurrentSession().save(entity);
        } catch (Exception e) {
            throw new DaoException(getClazz().getName() + " 保存异常,异常信息： " + e.getMessage());
        }
        return entity;
    }

    //修改
    @Override
    public Object update(Object entity) throws BaseException {
        try {
            this.getCurrentSession().update(entity);
        } catch (Exception e) {
            throw new DaoException(getClazz().getName() + " 更新异常,异常信息： " + e.getMessage());
        }
        return entity;
    }

    //保存或修改
    @Override
    public Object saveOrUpdate(Object entity) throws BaseException {
        try {
            this.getCurrentSession().saveOrUpdate(entity);
        } catch (Exception e) {
            throw new DaoException(getClazz().getName() + " 保存或更新异常,异常信息： " + e.getMessage());
        }
        return entity;
    }

    //删除
    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Object delete(Class className ,Long id) throws BaseException {
        Object entity = getEntity(className, id);
        try {
            this.getCurrentSession().delete(entity);
        } catch (Exception e) {
            throw new DaoException(getClazz().getName() + " 删除异常,异常信息： " + e.getMessage());
        }
        return entity;
    }

    //实时加载实体对象
    @Override
    @SuppressWarnings({"rawtypes" })
    public Object getEntity(Class className, Long id) {
        return this.getCurrentSession().get(className, id);
    }

    //延时加载实体对象
    @Override
    @SuppressWarnings({"rawtypes" })
    public Object loadEntity(Class className, Long id) {
        return this.getCurrentSession().load(className, id);
    }

    /**************************HQL查询********************************/
    //更新操作 BY HQL语句
    @Override
    public int getUpdateByHQL(String hql, Object[] args, Map<String, Object> alias) {
        return setHqlParameter(hql, args, alias).executeUpdate();
    }
    @Override
    public int getUpdateByHQL(String hql, Object arg) {
        return this.getUpdateByHQL(hql, new Object[] { arg }, null);
    }
    @Override
    public int getUpdateByHQL(String hql, Map<String, Object> alias) {
        return this.getUpdateByHQL(hql, null, alias);
    }
    @Override
    public int getUpdateByHQL(String hql, Object arg, Map<String, Object> alias) {
        return this.getUpdateByHQL(hql, new Object[] { arg }, alias);
    }
    @Override
    public int getUpdateByHQL(String hql, Object[] args) {
        return this.getUpdateByHQL(hql, args, null);
    }
    @Override
    public int getUpdateByHQL(String hql) {
        return this.getUpdateByHQL(hql, null, null);
    }

    //获取对象 BY HQL语句
    @Override
    public Object getObjectByHQL(String hql, Object[] args, Map<String, Object> alias) {
        return setHqlParameter(hql, args, alias).uniqueResult();
    }
    @Override
    public Object getObjectByHQL(String hql, Object arg) {
        return this.getObjectByHQL(hql, new Object[] { arg }, null);
    }
    @Override
    public Object getObjectByHQL(String hql, Map<String, Object> alias) {
        return getObjectByHQL(hql, null, alias);
    }
    @Override
    public Object getObjectByHQL(String hql, Object arg, Map<String, Object> alias) {
        return getObjectByHQL(hql, new Object[] { arg }, alias);
    }
    @Override
    public Object getObjectByHQL(String hql, Object[] args) {
        return this.getObjectByHQL(hql, args, null);
    }
    @Override
    public Object getObjectByHQL(String hql) {
        return this.getObjectByHQL(hql, null, null);
    }

    //获取数据集合 BY HQL语句
    @Override
    @SuppressWarnings("unchecked")
    public <E extends Object> List<E> getListByHQL(String hql, Object[] args, Map<String, Object> alias) {
        return setHqlParameter(hql, args, alias).list();
    }
    @Override
    public <E extends Object> List<E> getListByHQL(String hql, Object arg, Map<String, Object> alias) {
        return this.getListByHQL(hql, new Object[] { arg }, alias);
    }
    @Override
    public <E extends Object> List<E> getListByHQL(String hql, Map<String, Object> alias) {
        return this.getListByHQL(hql, null, alias);
    }
    @Override
    public <E extends Object> List<E> getListByHQL(String hql, Object[] args) {
        return this.getListByHQL(hql, args, null);
    }
    @Override
    public <E extends Object> List<E> getListByHQL(String hql, Object arg) {
        return this.getListByHQL(hql, arg, null);
    }
    @Override
    public <E extends Object> List<E> getListByHQL(String hql) {
        return this.getListByHQL(hql, null, null);
    }

    //获取分页数据 BY HQL语句
    @Override
    public Page getPageListByHQL(String hql, Object[] args, Map<String, Object> alias, Page page) {
        Query query = setHqlParameter(hql, args, alias);						//设置查询参数
        String countHql = getCount(hql, true);									//获取数量查询语句
        Query countQuery = setHqlParameter(countHql, args, alias);				//设置查询参数
        return setPageHqlParameter(query, countQuery, page);					//返回 Page
    }
    @Override
    public Page getPageListByHQL(String hql, Object arg, Map<String, Object> alias, Page page) {
        return this.getPageListByHQL(hql, new Object[] { arg }, alias, page);
    }
    @Override
    public Page getPageListByHQL(String hql, Map<String, Object> alias, Page page) {
        return this.getPageListByHQL(hql, null, alias, page);
    }
    @Override
    public Page getPageListByHQL(String hql, Object arg, Page page) {
        return this.getPageListByHQL(hql, new Object[] { arg }, null, page);
    }
    @Override
    public Page getPageListByHQL(String hql, Object[] args, Page page) {
        return this.getPageListByHQL(hql, args, null, page);
    }
    @Override
    public Page getPageListByHQL(String hql, Page page) {
        return this.getPageListByHQL(hql, null, null, page);
    }

    /**************************SQL查询********************************/

    //更新对象 BY SQL语句
    @Override
    public int getUpdateBySQL(String sql, Object[] args, Map<String, Object> alias) {
        SQLQuery query = setSqlParameter(sql, args, alias);//添加查询参数
        return query.executeUpdate();//查询结果对象返回Object类型
    }
    @Override
    public int getUpdateBySQL(String sql, Object arg, Map<String, Object> alias) {
        return getUpdateBySQL(sql, new Object[] { arg }, alias);
    }
    @Override
    public int getUpdateBySQL(String sql, Map<String, Object> alias) {
        return getUpdateBySQL(sql, null, alias);
    }
    @Override
    public int getUpdateBySQL(String sql, Object arg) {
        return getUpdateBySQL(sql, new Object[] { arg }, null);
    }
    @Override
    public int getUpdateBySQL(String sql, Object[] args) {
        return getUpdateBySQL(sql, args, null);
    }
    @Override
    public int getUpdateBySQL(String sql) {
        return getUpdateBySQL(sql, null, null);
    }

    //获取对象 BY SQL语句
    @Override
    public Object getObjectBySQL(String sql, Object[] args, Map<String, Object> alias, Class<?> clazz) {
        SQLQuery query = setSqlParameter(sql, args, alias);//添加查询参数
        if(clazz == null){
            return query.uniqueResult();//查询结果对象返回Object类型
        }else{
            return query.addEntity(clazz).uniqueResult();//查询结果对象有Class类型
        }
    }
    @Override
    public Object getObjectBySQL(String sql, Object arg, Map<String, Object> alias, Class<?> clazz){
        return getObjectBySQL(sql, new Object[]{arg}, alias, clazz);
    }
    @Override
    public Object getObjectBySQL(String sql, Map<String, Object> alias, Class<?> clazz){
        return getObjectBySQL(sql, null, alias, clazz);
    }
    @Override
    public Object getObjectBySQL(String sql, Object[] args, Class<?> clazz){
        return getObjectBySQL(sql, args, null, clazz);
    }
    @Override
    public Object getObjectBySQL(String sql, Object arg, Class<?> clazz){
        return getObjectBySQL(sql, new Object[]{arg}, null, clazz);
    }
    @Override
    public Object getObjectBySQL(String sql, Class<?> clazz){
        return getObjectBySQL(sql, null, null, clazz);
    }

    //获取数据集合 BY SQL语句
    @Override
    @SuppressWarnings("unchecked")
    public <E extends Object> List<E> getListBySQL(String sql, Object[] args, Map<String, Object> alias, Class<?> clazz, boolean hasEntity) {
        SQLQuery query = setSqlParameter(sql, args, alias); // 添加查询参数
        //查询结果是否为完整实体
        if(clazz != null){
            if(hasEntity){
                query.addEntity(clazz);
            }else{//实体类型
                query.setResultTransformer(Transformers.aliasToBean(clazz)); // 查询结果实体只包含部分字段
            }
        }
        return query.list();
    }
    @Override
    public <E extends Object> List<E> getListBySQL(String sql, Map<String, Object> alias, Class<?> clazz, boolean hasEntity) {
        return this.getListBySQL(sql, null, alias, clazz, hasEntity);
    }
    @Override
    public <E extends Object> List<E> getListBySQL(String sql, Object arg, Map<String, Object> alias, Class<?> clazz, boolean hasEntity) {
        return this.getListBySQL(sql, new Object[] { arg }, alias, clazz, hasEntity);
    }
    @Override
    public <E extends Object> List<E> getListBySQL(String sql, Object[] args, Class<?> clazz, boolean hasEntity) {
        return this.getListBySQL(sql, args, null, clazz, hasEntity);
    }
    @Override
    public <E extends Object> List<E> getListBySQL(String sql, Object arg, Class<?> clazz, boolean hasEntity) {
        return this.getListBySQL(sql, new Object[] { arg }, null, clazz, hasEntity);
    }
    @Override
    public <E extends Object> List<E> getListBySQL(String sql, Class<?> clazz, boolean hasEntity) {
        return this.getListBySQL(sql, null, null, clazz, hasEntity);
    }

    //获取分页数据 BY SQL语句
    @Override
    public Page getPageListBySQL(String sql, Object[] args, Map<String, Object> alias, Class<?> clazz, boolean hasEntity, Page page) {
        SQLQuery query = setSqlParameter(sql, args, alias);						//设置查询参数
        String countSql = getCount(sql, false);									//获取数量查询语句
        SQLQuery countQuery = setSqlParameter(countSql, args, alias);			//设置查询参数
        return setPageSqlParameter(query, countQuery, clazz, hasEntity, page);	//返回 Page
    }
    @Override
    public Page getPageListBySQL(String sql, Map<String, Object> alias, Class<?> clazz, boolean hasEntity, Page page) {
        return this.getPageListBySQL(sql, null, alias, clazz, hasEntity, page);
    }
    @Override
    public Page getPageListBySQL(String sql, Object arg, Map<String, Object> alias, Class<?> clazz, boolean hasEntity, Page page) {
        return this.getPageListBySQL(sql, new Object[] { arg }, alias, clazz, hasEntity, page);
    }
    @Override
    public Page getPageListBySQL(String sql, Object[] args, Class<?> clazz, boolean hasEntity, Page page) {
        return this.getPageListBySQL(sql, args, null, clazz, hasEntity, page);
    }
    @Override
    public Page getPageListBySQL(String sql, Object arg, Class<?> clazz, boolean hasEntity, Page page) {
        return this.getPageListBySQL(sql, new Object[] { arg }, null, clazz, hasEntity, page);
    }
    @Override
    public Page getPageListBySQL(String sql, Class<?> clazz, boolean hasEntity, Page page) {
        return this.getPageListBySQL(sql, null, null, clazz, hasEntity, page);
    }

    /**
     * HQL查询语句执行分页结果
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @param query			分页集合查询对象
     * @param countQuery	数量查询对象
     * @param page			分页对象
     * @return
     */
    private Page setPageHqlParameter(Query query, Query countQuery, Page page) {
        Integer size = page.getSize();
        Integer from = page.getFrom();
        if(size == null || size < 0){
            size = 10;
        }
        if(from == null || from < 0){
            from = 0;
        }
        page.setSize(size);
        page.setFrom(from);
        page.setDatas(query.setFirstResult(from).setMaxResults(size).list());
        page.setAllCount((long) countQuery.uniqueResult());
        return page;
    }

    /**
     * SQL查询语句执行分页结果
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @param query			分页集合查询对象
     * @param countQuery	数量查询对象
     * @param clazz			对象类型
     * @param hasEntity		结构集对象是否有对应实体类型
     * @param page			分页对象
     * @return
     */
    private Page setPageSqlParameter(SQLQuery query, SQLQuery countQuery, Class<?> clazz, boolean hasEntity, Page page) {
        Integer size = page.getSize();
        Integer from = page.getFrom();
        if(size == null || size < 0){
            size = 10;
        }
        if(from == null || from < 0){
            from = 0;
        }
        page.setSize(size);
        page.setFrom(from);
        if(clazz != null){
            if(hasEntity){
                query.addEntity(clazz);
            }else{
                query.setResultTransformer(Transformers.aliasToBean(clazz));
            }
        }
        page.setDatas(query.setFirstResult(from).setMaxResults(size).list());
        page.setAllCount((int)countQuery.uniqueResult());
        return page;
    }

    /**
     * 为HQL查询语句匹配查询参数
     * HQL语句:select * from User u where u.id in(:idS) and u.name=:name and u.code = ?
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @param hql		查询对象
     * @param args		HQL查询参数 对应 ？ 占位符
     * @param alias		HQL查询参数 对应 : 占位符
     * @return
     */
    private Query setHqlParameter(String hql, Object[] args, Map<String, Object> alias) {
        Query query = executeHQL(hql);
        setQueryAlias(query, alias);
        setQueryArgs(query, args);
        return query;
    }

    /**
     * 为SQL查询语句匹配查询参数
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @param sql		查询对象
     * @param args		SQL查询参数 对应 ？ 占位符
     * @return
     */
    private SQLQuery setSqlParameter(String sql, Object[] args, Map<String, Object> alias) {
        SQLQuery query = executeSQL(sql);
        setQueryAlias(query, alias);
        setQueryArgs(query, args);
        return query;
    }

    /**
     * 解析shql语句中的 like 关键字
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @param shql 		SQL or HQL 语句
     * @param alias 	别名参数
     * @return
     */
    private List<Boolean> getHasLikeList(String shql, String alias){
        Matcher matcher = null;
        String temp = null;
        int index = 0;
        List<Boolean> hasLike = new ArrayList<>(8);
        if(StringUtils.isNotBlank(alias)){
            matcher = Pattern.compile("([^\\s]+[\\s]+[^\\s]*[:]"+alias+")", Pattern.CASE_INSENSITIVE).matcher(shql);
            if(matcher.find()){
                temp = matcher.group(1);
                if(StringUtils.containsIgnoreCase(temp, "like")){
                    hasLike.add(index, true);
                }else{
                    hasLike.add(index, false);
                }
            }
        }else{
            matcher = Pattern.compile("([^\\?]{1,13})\\?", Pattern.CASE_INSENSITIVE).matcher(shql);	//([^\\s]+[\\s]+[^\\s]*[\\?][^\\s]*)
            while(matcher.find()){
                temp = matcher.group(1);
                if(StringUtils.containsIgnoreCase(temp, "like")){
                    hasLike.add(index++, true);
                }else{
                    hasLike.add(index++, false);
                }
            }
        }
        return hasLike;
    }

    /**
     * 为查询语句添加查询参数
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @param query		查询对象
     * @param alias		查询参数 对应 ： 占位符
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void setQueryAlias(Query query, Map<String, Object> alias) {
        if(alias != null && alias.size() > 0){
            String key = null;
            Object value = null;
            String shql = query.getQueryString();
            Iterator iter = alias.entrySet().iterator();
            while (iter.hasNext()) {
                Entry<String, Object> entry = (Entry<String, Object>) iter.next();
                key = entry.getKey();
                value = entry.getValue();
                if(value != null && value instanceof Collection){
                    query.setParameterList(key, (Collection) value);
                }else{
                    List<Boolean> hasLike = getHasLikeList(shql, key);
                    if(hasLike.size() > 0 && hasLike.get(0)){
                        query.setParameter(key, "%" + value + "%");
                    }else{
                        query.setParameter(key, value);
                    }
                }
            }
        }
    }

    /**
     * 为查询语句添加查询参数
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @param query		查询对象
     * @param args		查询参数 对应 ? 占位符
     * @return
     */
    private void setQueryArgs(Query query, Object[] args) {
        if(args != null && args.length > 0){
            String shql = query.getQueryString();
            List<Boolean> hasLike = getHasLikeList(shql, null);
            for(int i = 0, l =  args.length; i < l; i++){
                if(hasLike.get(i)){
                    query.setParameter(i, "%" + args[i] + "%");
                }else{
                    query.setParameter(i, args[i]);
                }
            }
        }
    }

    /**
     * 添加数量查询语句
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @param shql 		去掉fetch，替换开头为  select count(*) SQL or HQL 语句
     * @param isHql 	是否为HQL语句
     * @return
     */
    private String getCount(String shql, boolean isHql) {
        //掐头去尾
        if(!isHql){//SQL语句转为小写
            shql = shql.toLowerCase();
        }
        int start = StringUtils.indexOf(shql, "from");//截取 SQL or HQL 语句体中间部分
        int end = StringUtils.lastIndexOf(shql, "order by");
        start = start == -1 ? 0 : start;
        end = end == -1 ? shql.length() : end;
        shql = "select count(*) " + shql.substring(start, end);
        if(isHql){
            shql = shql.replaceAll("fetch", "");
        }
        return shql;
    }
}