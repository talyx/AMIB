package cryptoalgorithms;

import function.BigArithmeticOperations;
import function.BigEvclid;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ElGamal {
    Random rand = new SecureRandom();
    BigInteger generator;
    int bitLength = 1024;
    List<BigInteger> q = new ArrayList<>();
    BigArithmeticOperations biga = new BigArithmeticOperations();

    public BigInteger PrimitiveRoot(BigInteger p, List<BigInteger> q) {
        do {
            generator = BigInteger.probablePrime(bitLength, rand);
        }
        while (p.subtract(BigInteger.ONE).compareTo(generator) < 0);
        for (int i = 0; i < 2; i++)
            if (biga.mpow(generator, (p.subtract(BigInteger.ONE).divide(q.get(i))), p).equals(BigInteger.ONE))
                return PrimitiveRoot(p, q);
        return generator;
    }

    public void el_gamal(BigInteger M) {

        BigInteger p;
        BigInteger x = new BigInteger(bitLength, rand);
        BigInteger y;
        BigInteger a;
        BigInteger b;
        BigInteger M2;
        BigEvclid bigEvclid = new BigEvclid();
        BigInteger k = new BigInteger(bitLength, rand);

        do {
            p = BigInteger.probablePrime(bitLength, rand);
        }
        while (p.subtract(BigInteger.ONE).divide(BigInteger.TWO).isProbablePrime(50));

        q.add(p.subtract(BigInteger.ONE).divide(BigInteger.TWO));
        q.add(BigInteger.TWO);
        PrimitiveRoot(p, q);
        while (!(p.subtract(BigInteger.ONE).compareTo(x) > 0))
            x = new BigInteger(bitLength, rand);
        while (!(p.subtract(BigInteger.ONE).compareTo(k) > 0))
            k = new BigInteger(bitLength, rand);
        y = biga.mpow(generator, x, p);

        a = biga.mpow(generator, k, p);
        b = biga.mpow(y, k, p).multiply(M).mod(p); // encrypt message(a,b)

        M2 = bigEvclid.return_inverse_element(biga.mpow(a, x, p), p).multiply(b).mod(p); // decrypt message
        System.out.println(M2.equals(M));
    }
}
