package sos.nagato.ibase;

import sos.nagato.exception.BaseException;
import sos.nagato.pojo.Page;

import java.util.List;
import java.util.Map;

/**
 * @describe BaseDAO 定义DAO的通用操作
 * @project HIGHWAY CONSTRUCTION ENTERPRISE PROJECT MANAGEMENT SYSTEM
 * @author 尚皓玺
 * @version 1.0
 * @date 2016年11月28日 上午9:21:27
 * Copyright(c) XZHI All Rights Reserved.
 */
public interface IBaseDao<T> {

    /**
     * 保存
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @param entity 实体
     * @return
     * @throws BaseException
     */

    public Object save(Object entity) throws BaseException;

    /**
     * 修改
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @param entity 实体
     * @return
     * @throws BaseException
     */

    public Object update(Object entity) throws BaseException;

    /**
     * 保存或修改
     * @author 尚皓玺
     * @time 2017年1月6日 上午10:19:54
     * @param entity	实体
     * @return
     * @throws BaseException
     */
    public Object saveOrUpdate(Object entity) throws BaseException;

    /**
     * 删除
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @param className 类名
     * @param id        ID
     * @return
     */
    @SuppressWarnings("rawtypes")
    public Object delete(Class className, Long id) throws BaseException;

    /**
     * 实时加载实体对象
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @param id        ID
     * @return
     */
    @SuppressWarnings("rawtypes")
    public Object getEntity(Class className, Long id);

    /**
     * 延时加载实体对象
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @param id        ID
     * @return
     */
    @SuppressWarnings("rawtypes")
    public Object loadEntity(Class className, Long id);

    /**
     * 更新操作 BY HQL语句
     * HQL语句:update User u set u.status = -1 where u.id in(:idS) and u.name=:name and u.code = ?
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @param hql   HQL语句
     * @param arg   ?占位符 查询参数  按照HQL语句 ？ 查询条件唯一
     * @param args  ?占位符 查询参数  按照HQL语句 ？ 多个查询条件顺序依次插入
     * @param alias :别名 查询参数 基于 alias 查询
     * @return  int 影响行数
     */
    public int getUpdateByHQL(String hql, Object[] args, Map<String, Object> alias);
    public int getUpdateByHQL(String hql, Map<String, Object> alias);
    public int getUpdateByHQL(String hql, Object arg, Map<String, Object> alias);
    public int getUpdateByHQL(String hql, Object[] args);
    public int getUpdateByHQL(String hql, Object arg);
    public int getUpdateByHQL(String hql);

    /**
     * 获取对象 BY HQL语句
     * HQL语句:select * from User u where u.id in(:idS) and u.name=:name and u.code = ?
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @param hql   HQL语句
     * @param arg   ?占位符 查询参数  按照HQL语句 ？ 查询条件唯一
     * @param args  ?占位符 查询参数  按照HQL语句 ？ 多个查询条件顺序依次插入
     * @param alias :别名 查询参数 基于 alias 查询
     * @return  Object 返回对象
     */
    public Object getObjectByHQL(String hql, Object[] args, Map<String, Object> alias);
    public Object getObjectByHQL(String hql, Map<String, Object> alias);
    public Object getObjectByHQL(String hql, Object arg, Map<String, Object> alias);
    public Object getObjectByHQL(String hql, Object[] args);
    public Object getObjectByHQL(String hql, Object arg);
    public Object getObjectByHQL(String hql);

    /**
     * 获取数据集合 BY HQL语句
     * HQL语句:select * from User u where u.id in(:idS) and u.name=:name and u.code = ?
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @param hql   查询HQL语句
     * @param arg   ?占位符 查询参数  按照HQL语句 ？ 查询条件唯一
     * @param args  ?占位符 查询参数  按照HQL语句 ？ 多个查询条件顺序依次插入
     * @param alias :别名 查询参数 基于 alias查询
     * @return List<E> 实体集合
     */
    public <E extends Object>List<E> getListByHQL(String hql, Object[] args, Map<String, Object> alias);
    public <E extends Object>List<E> getListByHQL(String hql, Object arg, Map<String, Object> alias);
    public <E extends Object>List<E> getListByHQL(String hql, Map<String, Object> alias);
    public <E extends Object>List<E> getListByHQL(String hql, Object[] args);
    public <E extends Object>List<E> getListByHQL(String hql, Object arg);
    public <E extends Object>List<E> getListByHQL(String hql);

    /**
     * 获取分页数据 BY HQL语句
     * HQL语句:select * from User u where u.id in(:idS) and u.name=:name and u.code = ?
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @param hql	HQL语句
     * @param arg	?占位符 查询参数  按照HQL语句 ？ 查询条件唯一
     * @param args	?占位符 查询参数  按照HQL语句 ？ 多个查询条件顺序依次插入
     * @param alias	:别名 查询参数  匹配HQL语句中的别名标识
     * @param page  分页类
     * @return	page分页实体，返回分页结果集 List<?>
     */
    public Page getPageListByHQL(String hql, Object[] args, Map<String, Object> alias, Page page);
    public Page getPageListByHQL(String hql, Object arg, Map<String, Object> alias, Page page);
    public Page getPageListByHQL(String hql, Map<String, Object> alias, Page page);
    public Page getPageListByHQL(String hql, Object[] args, Page page);
    public Page getPageListByHQL(String hql, Object arg, Page page);
    public Page getPageListByHQL(String hql, Page page);

    /**
     * 更新对象 BY SQL语句
     * UPDATE T SET T.NAME = ? AND T.AGE = 12 AND T.STATUS = -1 WHERE T.ID IN(:idS) AND T.NAME = :name AND T.AGE = ?
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @param sql   SQL 语句
     * @param arg   ?占位符 查询参数  按照SQL语句 ？ 查询条件唯一
     * @param args  ?占位符 查询参数  按照SQL语句 ？ 多个查询条件顺序依次插入
     * @param alias	:别名 查询参数  匹配SQL语句中的别名标识
     * @return  int 影响行数
     */
    public int getUpdateBySQL(String sql, Object[] args, Map<String, Object> alias);
    public int getUpdateBySQL(String sql, Object arg, Map<String, Object> alias);
    public int getUpdateBySQL(String sql, Map<String, Object> alias);
    public int getUpdateBySQL(String sql, Object[] args);
    public int getUpdateBySQL(String sql, Object arg);
    public int getUpdateBySQL(String sql);

    /**
     * 获取对象 BY SQL语句
     * SELECT T.ID, T.NAME, T.AGE FROM TABLE_NAME T WHERE T.ID IN(:idS) AND T.NAME = :name AND T.AGE = ? ORDER BY T.DATE DESC
     * SELECT * TABLE_NAME T WHERE T.ID IN(:idS) AND T.NAME = :name AND T.AGE = ?
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     * @param sql   SQL 语句
     * @param arg   ?占位符 查询参数  按照SQL语句 ？ 查询条件唯一
     * @param args  ?占位符 查询参数  按照SQL语句 ？ 多个查询条件顺序依次插入
     * @param clazz 返回 Object 对象类型
     * @return  Object 返回对象
     */
    public Object getObjectBySQL(String sql, Object[] args, Map<String, Object> alias, Class<?> clazz);
    public Object getObjectBySQL(String sql, Object arg, Map<String, Object> alias, Class<?> clazz);
    public Object getObjectBySQL(String sql, Map<String, Object> alias, Class<?> clazz);
    public Object getObjectBySQL(String sql, Object[] args, Class<?> clazz);
    public Object getObjectBySQL(String sql, Object arg, Class<?> clazz);
    public Object getObjectBySQL(String sql, Class<?> clazz);

    /**
     * 获取数据集合 BY SQL语句
     * SELECT T.ID, T.NAME, T.AGE FROM TABLE_NAME T WHERE T.ID IN(:idS) AND T.NAME = :name AND T.AGE = ? ORDER BY T.DATE DESC
     * SELECT * TABLE_NAME T WHERE T.ID IN(:idS) AND T.NAME = :name AND T.AGE = ?
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     *  @param sql			SQL语句
     *  @param arg			?占位符 查询参数  按照SQL语句 ？ 查询条件唯一
     *  @param args			?占位符 查询参数  按照SQL语句 ？ 多个查询条件顺序依次插入
     *  @param alias		:别名 查询参数  匹配SQL语句中的别名标识
     *  @param clazz			查询结果集实体Class类型
     *  @param hasEntity	查询结果字段是否对应Entity的每个属性，若为true，则返回CLAZZ类型结果集，为false则返回临时包装类
     *  					SELECT 	 *		FROM TABLE  →   hasEntity 为true,  每个字段全部返回
     *  					SELECT ID, NAME FROM TABLE  →   hasEntity 为false, 有的字段没有返回
     *  @param page			分页类
     *  @return List<E>  返回集合
     */
    public <E extends Object>List<E> getListBySQL(String sql, Object[] args, Map<String, Object> alias, Class<?> clazz, boolean hasEntity);
    public <E extends Object>List<E> getListBySQL(String sql,  Object arg, Map<String, Object> alies, Class<?> clazz, boolean hasEntity);
    public <E extends Object> List<E> getListBySQL(String sql, Map<String, Object> alies, Class<?> clazz, boolean hasEntity);
    public <E extends Object>List<E> getListBySQL(String sql, Object[] args, Class<?> clazz, boolean hasEntity);
    public <E extends Object>List<E> getListBySQL(String sql, Object arg, Class<?> clazz, boolean hasEntity);
    public <E extends Object>List<E> getListBySQL(String sql, Class<?> clazz, boolean hasEntity);

    /**
     * 获取分页数据 BY SQL语句
     * SELECT T.ID, T.NAME, T.AGE FROM TABLE_NAME T WHERE T.ID IN(:idS) AND T.NAME = :name AND T.AGE = ? ORDER BY T.DATE DESC
     * SELECT * TABLE_NAME T WHERE T.ID IN(:idS) AND T.NAME = :name AND T.AGE = ?
     * @author 尚皓玺
     * @time 2016年11月29日  下午3:16:05
     *  @param sql			SQL语句
     *  @param arg			?占位符 查询参数  按照SQL语句 ？ 查询条件唯一
     *  @param args			?占位符 查询参数  按照SQL语句 ？ 多个查询条件顺序依次插入
     *  @param alias		:别名 查询参数  匹配SQL语句中的别名标识
     *  @param clazz			查询结果集实体Class类型，为 NULL 则返回 Object[] 结果集
     *  @param hasEntity	查询结果字段是否对应Entity的每个属性，若为true，则返回CLAZZ类型结果集，为false则返回临时包装类
     *  	                SELECT 	 *		FROM TABLE  →   hasEntity 为true,  每个字段全部返回
     *  	                SELECT ID, NAME FROM TABLE  →   hasEntity 为false, 有的字段没有返回
     *  @param page			分页类
     *  @return	 page 分页实体，返回分页结果集 List<?>
     */
    public Page getPageListBySQL(String sql, Object[] args, Map<String, Object> alias, Class<?> clazz, boolean hasEntity, Page page);
    public Page getPageListBySQL(String sql, Object arg, Map<String, Object> alias, Class<?> clazz, boolean hasEntity, Page page);
    public Page getPageListBySQL(String sql, Map<String, Object> alias, Class<?> clazz, boolean hasEntity, Page page);
    public Page getPageListBySQL(String sql, Object[] args, Class<?> clazz, boolean hasEntity, Page page);
    public Page getPageListBySQL(String sql, Object arg, Class<?> clazz, boolean hasEntity, Page page);
    public Page getPageListBySQL(String sql, Class<?> clazz, boolean hasEntity, Page page);
}
