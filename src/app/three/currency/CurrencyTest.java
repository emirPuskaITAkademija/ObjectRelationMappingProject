package app.three.currency;

import java.math.BigDecimal;

/**
 * <li>Currency KM
 *
 * <li>Currency EUR
 *
 * 10 feningi ->  0.1 KM
 * 
 * double amount = 0.2; -> 0.20000000124
 *
 * <p>
 *
 * @author Grupa2
 */
public class CurrencyTest {
    public static void main(String[] args) {
        BigDecimal total = BigDecimal.valueOf(0.2);
        for(int i = 0; i<100; i++){
            total = total.add(BigDecimal.valueOf(0.2));
        }
        System.out.println("Total : " + total.toPlainString());
    }
}
