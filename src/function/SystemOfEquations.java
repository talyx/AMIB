package function;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SystemOfEquations {
    public BigInteger system_of_eqations(List<BigInteger> c, List<BigInteger> m) {
        BigInteger x = BigInteger.ZERO;
        BigEvclid evclid = new BigEvclid();
        if (c.size() == m.size()) {
            int i = 0;
            BigInteger M = BigInteger.ONE;
            List<BigInteger> M_i = new ArrayList<>();
            while (i < c.size()) {
                M = M.multiply(m.get(i));
                i++;
            }
            i = 0;
            while (i < c.size()) {
                M_i.add(M.divide(m.get(i)));
                i++;
            }
            i = 0;
            while (i < c.size()) {
                x = x.add((c.get(i).multiply(M_i.get(i))).multiply(evclid.return_inverse_element(M_i.get(i), m.get(i))));
                i++;
            }
            x = x.mod(M);
            return x;
        }
        else
            throw new RuntimeException("Размеры С и М не совпадают");
    }

}
