package sos.nagato.exception;

/**
 * @describe 异常编码类
 * @project HIGHWAY CONSTRUCTION ENTERPRISE PROJECT MANAGEMENT SYSTEM
 * @author 文斌斌
 * @version 1.0
 * @date 2016年12月21日 上午11:14:48
 * Copyright(c) XZHI All Rights Reserved.
 */
public class RuntimeCode {
    public RuntimeCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;	//运行时代码
    private String message;	//释义

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

