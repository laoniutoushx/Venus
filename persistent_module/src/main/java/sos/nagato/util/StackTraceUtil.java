package sos.nagato.util;

/**
 * @author wuzhiwen
 *
 * @version v1.0
 *
 *          Created on 2014年5月28日 上午10:23:52
 *
 *          Revision History: Date Reviser Description
 *
 *          ----------------------------------------------------
 *
 *          Description:SystemUtil
 */
public class StackTraceUtil {

    /**
     *
     * Description:获取异常堆栈追踪
     *
     * 作者 wuzhiwen
     *
     * 2014年5月28日 上午10:26:27
     *
     * @return
     */
    public static String getStackTrace() {

        StackTraceElement stack[] = Thread.currentThread().getStackTrace();

        return getStackTrace(stack);
    }

    /**
     *
     * Description:获取非java系统的异常堆栈
     *
     * 作者 wuzhiwen
     *
     * 2014年6月12日 下午2:09:20
     *
     * @param pArrayStackTraceElement
     * @return
     */
    public static String getStackTrace(
            StackTraceElement[] pArrayStackTraceElement) {
        String _stackTrace = "";
        for (StackTraceElement ste : pArrayStackTraceElement) {
            if (ste.getClassName().indexOf(StackTraceUtil.class.getName()) != -1
                    || ste.getClassName().startsWith("sun")
                    || ste.getClassName().startsWith("java")
                    || ste.getClassName().startsWith("org")) {
                continue;
            }
            _stackTrace += "*** " + ste.getClassName() + "."
                    + ste.getMethodName() + "   line:" + ste.getLineNumber()
                    + "-_-newLine-_-";
        }
        return _stackTrace;
    }
}