package com.haruhi.builder;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>com.haruhi.builder</h3>
 * @Description <p>视频成分营养标签</p>
 *  错误实例
 * @Author SuzumiyaHaruhi
 * @Time 2017/12/16 14:57:59
 * @Version v1.0
 */
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;     // 碳水化合物

    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0, 0, 0, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0, 0, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}
