package sos.nagato.exception;

/**
 * @describe DAO 层异常类
 * @project HIGHWAY CONSTRUCTION ENTERPRISE PROJECT MANAGEMENT SYSTEM
 * @author 文斌斌
 * @version 1.0
 * @date 2016年12月21日 上午11:19:07
 * Copyright(c) XZHI All Rights Reserved.
 */
public class DaoException extends BaseException {

    private static final long serialVersionUID = -1507022301103713120L;

    private static final RuntimeCode DAOEXCEPTION = new RuntimeCode("dao001", "数据处理层异常");

    public DaoException() {
        super();
        this.setCode(DAOEXCEPTION);
    }

    public DaoException(Exception e) {
        super(e, DAOEXCEPTION);
    }

    public DaoException(String message) {
        super(DAOEXCEPTION, message);
    }
}

