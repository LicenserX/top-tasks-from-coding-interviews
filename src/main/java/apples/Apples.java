package apples;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 1)твердое + жидкое = целое
 * 2)
 *     1)*80%влаги + 20%твердого = 100%
 *     2)Значит твердого = 19 * 0.2 = 3.8
 *     3)В результате сушки твердое не исчезает, при этом после сушки процент твердого = (100%-15%) = 85%
 *     4)Чтобы определить массу итоговых высушенных яблок (твердое)/0.85 = 3.8/0.85
 *     5)Ответ ~ 4.47
 *
 * http://reshyzadachy.blogspot.com/2016/03/blog-post_26.html
 * Только что сорванное яблоко содержит 80% влаги, вто время как сушеное – 15% = (100%-15%=85%). Сколько получится
 * сушеных яблок из 19 кг свежих? Сколько надо взять свежих яблок, чтобы
 * получить 4,4 кг сушеных?
 */
public class Apples {
    public static void main(String[] args) {
        System.out.println("DRY APPLES: " +
                getKgApples(new BigDecimal(19), new BigDecimal(15), new BigDecimal(80))
        );

        System.out.println("FRESH APPLES: " +
                getKgApples(new BigDecimal("4.4"), new BigDecimal(80), new BigDecimal(15))
        );

    }

    public static final BigDecimal getKgApples(BigDecimal applesKg,
                                               BigDecimal percentOfWater1,
                                               BigDecimal percentOfWater2) {
        return applesKg.multiply(percentOfWater1)
                .divide(percentOfWater2,2, RoundingMode.HALF_UP);
    }

}
