package sos.nagato.constant;

import sos.nagato.exception.RuntimeCode;

/**
 * @describe 运行时结果代码定义举例
 * @project HIGHWAY CONSTRUCTION ENTERPRISE PROJECT MANAGEMENT SYSTEM
 * @author 文斌斌
 * @version 1.0
 * @date 2016年12月21日 上午11:15:29
 * Copyright(c) XZHI All Rights Reserved.
 */
public class RuntimeCodeConst {

    public static final RuntimeCode EXCEPTION = new RuntimeCode("exception001", "异常代码未定义");

    public static class Parameter {
        public static final RuntimeCode NULLPARAMETER = new RuntimeCode("parameter001", "参数为空");
    }

    public static class Method {
        //方法不存在
        public static final RuntimeCode NOSUCHMETHOD = new RuntimeCode("method001", "方法不存在");
    }


}

