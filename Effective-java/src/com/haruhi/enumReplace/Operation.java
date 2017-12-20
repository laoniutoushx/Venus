package com.haruhi.enumReplace;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>com.haruhi.enumReplace</h3>
 * @Description <p></p>
 * @Author SuzumiyaHaruhi
 * @Time 2017/12/17 14:59:38
 * @Version v1.0
 */
public enum Operation {
    PLUS("+"){
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-"){
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    },
    DIVIDE("*"){
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    },
    TIMES("/"){
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    };
    final private String symbol;
    Operation(String symbol){
        this.symbol = symbol;
    }


    abstract double apply(double x, double y);

    /**
     * Returns the name of this enum constant, as contained in the
     * declaration.  This method may be overridden, though it typically
     * isn't necessary or desirable.  An enum type should override this
     * method when a more "programmer-friendly" string form exists.
     *
     * @return the name of this enum constant
     */
    @Override
    public String toString() {
        return this.symbol;
    }

    public static void main(String[] args) {
        double x = 3, y = 5;
        for(Operation op:Operation.values()){
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
