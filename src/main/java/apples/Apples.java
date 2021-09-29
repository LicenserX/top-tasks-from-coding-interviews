package apples;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Только что сорванное яблоко содержит 80% влаги, вто время как сушеное – 15%. Сколько получится
 * сушеных яблок из 19 кг свежих? Сколько надо взять свежих яблок, чтобы
 * получить 4,4 кг сушеных?
 */
public class Apples {
    public static void main(String[] args) {
        System.out.println("DRY APPLES: " +
                getKgApples(new BigDecimal(19), new BigDecimal(15), new BigDecimal(80))
        );

        System.out.println(
                "FRESH APPLES: " + getKgApples(new BigDecimal("4.4"), new BigDecimal(80), new BigDecimal(15))
        );

    }

    public static final BigDecimal getKgApples(BigDecimal applesKg,
                                               BigDecimal percentOfWater1,
                                               BigDecimal percentOfWater2) {
        return applesKg.multiply(percentOfWater1)
                .divide(percentOfWater2,2, RoundingMode.HALF_UP);
    }

}
