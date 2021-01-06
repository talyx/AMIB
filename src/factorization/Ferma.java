package factorization;

import java.math.BigInteger;

public class Ferma {
    public void ferma(BigInteger n) {
        BigInteger s;
        BigInteger t;
        BigInteger t1;
        BigInteger p;
        BigInteger q;
        s = n.sqrt();
        do {
            s = s.add(BigInteger.ONE);
            t = (s.pow(2)).subtract(n);
            t1 = t.sqrt();

        }
        while (!t1.pow(2).equals(t));
        p = s.add(t1);
        q = s.subtract(t1);
        System.out.println("q  :" + q);
        System.out.println("p  :" + p);


    }

    public static void main(String[] args) {
        Ferma f = new Ferma();
        f.ferma(new BigInteger("2318553827267041599931064141028026591078453523755133761420994537426231546233197332557815088229590256567177621743082082713100922775483908922217521567861530205737139513575691852244362271068595653732088709994411183164926098663772268120044065766077197167667585331637038825079142327613226776540743407081106744519"));
    }
}
