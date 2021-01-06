package function;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LinearEquation {
    BigEvclid evclid = new BigEvclid();
    List<BigInteger> egcd = new ArrayList<>();

    public BigInteger linear_equation(BigInteger a, BigInteger b, BigInteger n) {
        BigInteger x;
        egcd = evclid.advanced_algorithm(a, n);
        if (b.mod(egcd.get(2)).equals(BigInteger.ZERO)) {
            x = (egcd.get(0).multiply(b.divide(egcd.get(2)))).mod(n);
            return x;
        }
        throw new RuntimeException("Не выполняется необходимое условие!");
    }

}
