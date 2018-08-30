package sos.nagato.exception;

/**
 * @describe 系统运行时异常总接口
 * @project HIGHWAY CONSTRUCTION ENTERPRISE PROJECT MANAGEMENT SYSTEM
 * @author 文斌斌
 * @version 1.0
 * @date 2016年12月21日 上午11:05:28
 * Copyright(c) XZHI All Rights Reserved.
 */
public interface Runtime {

    /**
     * 获取运行时状态的代码
     * @author 文斌斌
     * @time 2016年12月21日 上午11:06:22
     * @return
     */
    public RuntimeCode getRuntimeCode();

    /**
     * 获取运行时状态的信息
     * @author 文斌斌
     * @time 2016年12月21日 上午11:06:32
     * @return
     */
    public String getMessage();
}
