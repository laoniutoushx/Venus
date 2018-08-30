package sos.nagato.exception;


import org.apache.commons.lang3.StringUtils;

import sos.nagato.constant.RuntimeCodeConst;
import sos.nagato.util.StackTraceUtil;

/**
 * @describe 系统异常基类
 * @project HIGHWAY CONSTRUCTION ENTERPRISE PROJECT MANAGEMENT SYSTEM
 * @author 文斌斌
 * @version 1.0
 * @date 2016年12月21日 上午11:08:29
 * Copyright(c) XZHI All Rights Reserved.
 */
public class BaseException extends Exception implements Runtime {

    private static final long serialVersionUID = 3153856436938827302L;

    private RuntimeCode code; //异常编码
    public BaseException() {}

    public BaseException(Exception exception, RuntimeCode defaultCode) {
        super(exception);
        boolean _isBase = false;
        Class<?> _class = exception.getClass();
        while (!_isBase) {
            if (_class.equals(Exception.class) || _class.equals(Object.class)) {
                break;
            }
            if (_class.getName().equals(BaseException.class.getName())) {
                _isBase = true;
            } else {
                _class = _class.getSuperclass();
            }
        }
        if (_isBase) {
            BaseException _ex = (BaseException) exception;
            this.setCode(_ex.getRuntimeCode());
        } else
            this.setCode(defaultCode == null ? RuntimeCodeConst.EXCEPTION : defaultCode);
    }

    public BaseException(RuntimeCode runtimeCode) {
        super();
        this.setCode(runtimeCode);
    }

    public BaseException(RuntimeCode runtimeCode, String message) {
        super(message);
        this.setCode(runtimeCode);
    }

    public BaseException(RuntimeCode runtimeCode, Exception exception) {
        super(exception);
        this.setCode(runtimeCode);
    }

    @Override
    public RuntimeCode getRuntimeCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        if(StringUtils.isNotBlank(super.getMessage())){
            return super.getMessage();
        }
        if(this.getRuntimeCode() != null){
            return this.getRuntimeCode().getMessage();
        }
        return "";
    }

    public void setCode(RuntimeCode code) {
        this.code = code;
    }

    public String getStackTraceString() {
        StackTraceElement[] stack = super.getStackTrace();
        if(stack != null && stack.length > 0){
            return StackTraceUtil.getStackTrace(stack);
        }else{
            return "";
        }
    }
}
