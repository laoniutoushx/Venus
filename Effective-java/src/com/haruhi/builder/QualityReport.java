package com.haruhi.builder;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>com.haruhi.builder</h3>
 * @Description <p></p>
 * @Author SuzumiyaHaruhi
 * @Time 2017/12/16 15:33:42
 * @Version v1.0
 */
public class QualityReport {
    final private int level;
    final private int size;
    final private int weight;
    final private int percent;

    public static class Builder implements IBuilder<QualityReport> {
        private int level;
        private int size;
        private int weight;
        private int precent;

        public Builder level(int val){
            level = val;
            return this;
        }
        public Builder size(int val){
            size = val;
            return this;
        }
        public Builder weight(int val){
            weight = val;
            return this;
        }
        public Builder precent(int val){
            precent = val;
            return this;
        }
        /**
         * <p>build</p>
         *
         * @Description 构造器
         * @Author SuzumiyaHaruhi
         * @Time 2017/12/16 15:20
         * @Return T
         */
        @Override
        public QualityReport build() {
            return new QualityReport(this);
        }
    }
    private QualityReport(Builder builder){
        level = builder.level;
        size = builder.size;
        weight = builder.weight;
        percent = builder.precent;
        System.out.println("level:" + this.level + " size:" + this.size
            + " weight:" + this.weight + " percent:" + this.percent);
    }

    public static void main(String[] args) {
        QualityReport report = new Builder().level(3).size(2).weight(7).precent(99).build();
    }
}
