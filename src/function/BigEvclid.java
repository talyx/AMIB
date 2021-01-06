package function;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class BigEvclid {
    public BigInteger normal_algorithm(BigInteger a, BigInteger b) {
        BigInteger tmp;
        while (!b.equals(BigInteger.ZERO)) {
            tmp = a;
            a = b;
            b = tmp.mod(b);
        }
        return a;
    }

    public List<BigInteger> advanced_algorithm(BigInteger number_a, BigInteger number_b) {
        List<BigInteger> q = new ArrayList<>();
        List<BigInteger> a = new ArrayList<>();
        List<BigInteger> x = new ArrayList<>();
        List<BigInteger> y = new ArrayList<>();
        int i = 0;
        q.add(BigInteger.ZERO);
        a.add(number_a);
        a.add(number_b);
        x.add(BigInteger.ONE);
        y.add(BigInteger.ZERO);
        x.add(BigInteger.ZERO);
        y.add(BigInteger.ONE);

        while (!a.get(i + 1).equals(BigInteger.ZERO)) {
            q.add(a.get(i).divide(a.get(i + 1)));
            a.add(a.get(i).subtract(a.get(i + 1).multiply(q.get(i + 1))));
            x.add(x.get(i).subtract(x.get(i + 1).multiply(q.get(i + 1))));
            y.add(y.get(i).subtract(y.get(i + 1).multiply(q.get(i + 1))));
            i++;
        }
        List<BigInteger> gcd = new ArrayList<>();
        if (x.get(i).compareTo(BigInteger.ZERO) < 0)
            gcd.add(x.get(i).mod(number_b));
        else
            gcd.add(x.get(i));
        if (y.get(i).compareTo(BigInteger.ZERO) < 0)
            gcd.add(y.get(i).mod(number_b));
        else
            gcd.add(y.get(i));
        gcd.add(a.get(i));
        return gcd;
    }

    public BigInteger return_inverse_element(BigInteger number_a, BigInteger number_b) {
        List<BigInteger> list = advanced_algorithm(number_a, number_b);
        return list.get(0);
    }

}
