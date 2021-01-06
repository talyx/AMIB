package cryptoalgorithms;

import javax.print.DocFlavor;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gold {
    int bitLength = 1024;
    Random rand = new SecureRandom();

    public void goldvasser_mikali(BigInteger msg) {
        BigInteger p = BigInteger.probablePrime(bitLength, rand);
        BigInteger q = BigInteger.probablePrime(bitLength, rand);
        BigInteger n = q.multiply(p);
        BigInteger y = getY(p, q);
        BigInteger x;

        System.out.println("y :: " + get_lejandra_simbol(y, p));
        System.out.println("y :: " + get_lejandra_simbol(y, q));
// System.exit(0);


        List<BigInteger> c = new ArrayList<>();
// шифрование
        for (int i = msg.bitLength() -1; i >=0; i--) {
            do {
                x = new BigInteger(bitLength, rand);
            }
            while (!(n.compareTo(x) > 0));
            if (msg.testBit(i)) {
                c.add(x.pow(2).mod(n));

            } else
                c.add((y.multiply(x.pow(2))).mod(n));
        }

        List<Integer> m = new ArrayList<>();
// расшифрование
        for (int i = 0; i < c.size(); i++) {
            if (get_lejandra_simbol(c.get(i), p) == 1) {
                m.add(1);
            } else {
                m.add(0);
            }
        }
        System.out.println(m);//1010011001

        BigInteger mes = BigInteger.ZERO;

        for (int i = 0; i < m.size(); i++) {
            if (m.get(i) == 1)
                mes = mes.or(BigInteger.ONE);
            if (i + 1 < m.size())
                mes = mes.shiftLeft(1);
        }
        System.out.println(mes);
// System.out.println(m);


    }

    private int get_lejandra_simbol(BigInteger a, BigInteger n) {
        a = a.mod(n);
// System.out.println("a = " + a + ", n = " + n);
        int res = 1;
        if (a.equals(BigInteger.ONE) || a.equals(BigInteger.ZERO))
            return res;
        else {
            int cnt = a.getLowestSetBit();
// cnt = (cnt / 2) * 2;
            cnt >>= 1;
            cnt <<= 1;
            a = a.shiftRight(cnt);
            if (!a.testBit(0)) {
                a = a.shiftRight(1);
                int tmp = n.intValue() % 8;
                if (tmp != 1 && tmp != 7)
                    res = -res;
            }

            if (a.equals(BigInteger.ONE))
                return res;

            int tmp1 = a.intValue() % 4,
                    tmp2 = n.intValue() % 4;
            if (tmp1 == 3 && tmp2 == 3)
                res = -res;
            return res * get_lejandra_simbol(n.mod(a), a);
        }
    }

    private BigInteger getY(BigInteger p, BigInteger q) {
        BigInteger y;
        do {
            y = new BigInteger(bitLength, rand);
        } while (!(get_lejandra_simbol(y, p) == (-1) && get_lejandra_simbol(y, q) == -1));
        return y;
    }

    public static void main(String[] args) {
        Gold gm = new Gold();

/*int m = 65537;
for (int i = 1; i < m; i++) {
int j = gm.get_lejandra_simbol(BigInteger.valueOf(i), BigInteger.valueOf(m));
int root = -1;
for (int k = 1; k < m; k++)
if (k*k % m == i)
root = k;
if (root == -1 && j != -1 || root != -1 && j == -1)
System.out.println(i + "\t" + j + "\t" + root);
}*/

        BigInteger msg = new BigInteger("555");
        System.out.println(msg);
        gm.goldvasser_mikali(msg);

    }
}