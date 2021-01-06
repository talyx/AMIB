package cryptoalgorithms;

import function.BigArithmeticOperations;

import javax.print.DocFlavor;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GoldvasserMikali {
    int bitLength = 1024;
    Random rand = new SecureRandom();
    BigArithmeticOperations bigAO = new BigArithmeticOperations();
    BigInteger minusOne = new BigInteger("-1");
    BigInteger eight = new BigInteger("8");

    public void goldvasser_mikali(BigInteger msg) {
        BigInteger p = BigInteger.probablePrime(bitLength, rand);
        BigInteger q = BigInteger.probablePrime(bitLength, rand);
        BigInteger n = q.multiply(p);
        BigInteger y = getY(p, q);
        BigInteger x;

        List<BigInteger> c = new ArrayList<>();
        // шифрование
        for (int i = 0; i < msg.bitLength(); i++) {
            do {
                x = new BigInteger(bitLength, rand);
            }
            while (!(n.compareTo(x) > 0));
            if (msg.testBit(i)) {
                c.add(x.pow(2).mod(n));
            } else
                c.add(y.multiply(x.pow(2)).mod(n));
        }
        List<Integer> m = new ArrayList<>();
        // расшифрование
        for (int i = 0; i < c.size(); i++) {
            if (get_lejandra_simbol(c.get(i), p).equals(BigInteger.ONE)) {
                m.add(1);
            } else {
                m.add(0);
            }
        }

        BigInteger mes = BigInteger.ZERO;

        for (int i = 0; i < m.size(); i++){
            if (m.get(i) == 1)
                mes = mes.or(BigInteger.ONE);
            if (i + 1 < m.size())
                mes  = mes.shiftLeft(1);
        }
        System.out.println(mes);
        System.out.println(m);


    }

    private BigInteger get_lejandra_simbol(BigInteger a, BigInteger n) {
        BigInteger temp;
        BigInteger counter = BigInteger.ONE;
        BigInteger res = BigInteger.ONE;
        a = a.mod(n);

        do {
            if (a.equals(minusOne)) {
                res = bigAO.pow(minusOne, (n.subtract(BigInteger.ONE).divide(BigInteger.TWO)));
            } else if (a.equals(BigInteger.TWO)) {
                res = bigAO.pow(minusOne, (n.pow(2).subtract(BigInteger.ONE).divide(eight)));
                a = a.divide(BigInteger.TWO);
            } else if (a.mod(BigInteger.TWO).equals(BigInteger.ONE)) {
                counter = counter.multiply(bigAO.pow(minusOne, (a.subtract(BigInteger.ONE).divide(BigInteger.TWO)).multiply(n.subtract(BigInteger.ONE).divide(BigInteger.TWO))));
                temp = a;
                a = n.mod(temp);
                n = temp;
            } else if (a.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                int pow = 0;
                while (a.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                    a = a.divide(BigInteger.TWO);
                    pow++;
                }
                counter = counter.multiply(get_lejandra_simbol(BigInteger.TWO, n).pow(pow));
            }  if (a.equals(BigInteger.ONE)) {
                res = res.multiply(counter);
            }
        }
        while (!(a.equals(BigInteger.ONE)));

        return res;
    }

    private BigInteger getY(BigInteger p, BigInteger q) {
        BigInteger y;
        do {
            y = new BigInteger(bitLength, rand);
        } while (!(get_lejandra_simbol(y, p).equals(minusOne) && get_lejandra_simbol(y, q).equals(minusOne)));
        return y;
    }

    public static void main(String[] args) {
        GoldvasserMikali gm = new GoldvasserMikali();
        BigInteger msg = new BigInteger("555");

        gm.goldvasser_mikali(msg);

    }
}
