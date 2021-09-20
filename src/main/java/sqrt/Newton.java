
package sqrt;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Newton {
    public static final BigDecimal divider = new BigDecimal(2);

    public static void main(String[] args) {
        BigDecimal precision = new BigDecimal(0.00001);
        System.out.println(recursiveSqrt(new BigDecimal(2), new BigDecimal(1), precision));
        System.out.println(sqrt(new BigDecimal(2), new BigDecimal(1), precision));

    }

    public static BigDecimal recursiveSqrt(BigDecimal value, BigDecimal approximation, BigDecimal precision) {
        BigDecimal division = value.divide(approximation,6, RoundingMode.HALF_UP);
        BigDecimal average  = approximation.add(division).divide(divider,6, RoundingMode.HALF_UP);
        BigDecimal difference = average.multiply(average).subtract(value);

        if (difference.compareTo(precision) < 0) {
            return average;
        }
       return recursiveSqrt(value, average, precision);
    }

    public static BigDecimal sqrt(BigDecimal value, BigDecimal approximation, BigDecimal precision) {
        BigDecimal difference = new BigDecimal(1);
        BigDecimal average = new BigDecimal(BigInteger.ZERO);
        BigDecimal currentApproximation = approximation;

        while (difference.compareTo(precision) != -1) {
            BigDecimal division = value.divide(currentApproximation,6, RoundingMode.HALF_UP);
            average  = currentApproximation.add(division).divide(divider,6, RoundingMode.HALF_UP);
            difference = average.multiply(average).subtract(value);
            currentApproximation = average;
        }
        return average;
    }
}
