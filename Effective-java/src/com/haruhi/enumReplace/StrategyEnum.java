package com.haruhi.enumReplace;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>com.haruhi.enumReplace</h3>
 * @Description <p>加班薪资计算枚举类</p>
 * @Author SuzumiyaHaruhi
 * @Time 2017/12/17 15:12:34
 * @Version v1.0
 */
public enum StrategyEnum {     // 一周每天加班报酬，计算
    MONDAY(PayType.WEEKDAY), TUESDAY(PayType.WEEKDAY), WEDNESDAY(PayType.WEEKDAY),
    THURSDAY(PayType.WEEKDAY), FRIDAY(PayType.WEEKDAY), SATURDAY(PayType.WEEKEND),
    SUNDAY(PayType.WEEKEND);
    StrategyEnum(PayType payType){
        this.payType = payType;
    }
    final private PayType payType;
    public double pay(double hourWorked, double payRate){
        return this.payType.pay(hourWorked, payRate);
    }

    /**
     * @Project <h2>Venus</h2>
     * @Package <h3>com.haruhi.enumReplace</h3>
     * @Description <p>内部策略枚举类</p>
     * @Author SuzumiyaHaruhi
     * @Time 2017/12/17 15:12:34
     * @Version v1.0
     */
    private enum PayType{
        WEEKDAY{
            @Override
            double overtimePay(double hours, double payRate) {
                return hours <= HOURS_PER_SHIFT ? 0 :
                        (hours - HOURS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND{
            @Override
            double overtimePay(double hours, double payRate) {
                return hours * payRate / 2;
            }
        };
        final private static int HOURS_PER_SHIFT = 8;
        abstract double overtimePay(double hours, double payRate);
        /**
         * <p>pay</p>
         * @Description 加班薪资计算
         * @Param hoursWorked       加班时间
         * @Param payRate           支付费率
         * @Author SuzumiyaHaruhi
         * @Time 2017/12/17 15:43
         * @Return double
         */
        double pay(double hoursWorked, double payRate){
            double basePay = hoursWorked * payRate;
            return basePay + overtimePay(hoursWorked, payRate);
        }
    }

    public static void main(String[] args) {
        System.out.println(StrategyEnum.FRIDAY.pay(33, 3.4));
        System.out.println(StrategyEnum.SATURDAY.pay(33, 3.4));
    }
}
