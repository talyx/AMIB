package cryptoalgorithms;

import function.*;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class RSA {
    BigEvclid bigEvclid = new BigEvclid();
    BigArithmeticOperations ba = new BigArithmeticOperations();
    Random r = new SecureRandom();
    int bitLength = 512;

    public void rsa(BigInteger m) {
        BigInteger e = new BigInteger("65537");
        BigInteger p = BigInteger.probablePrime(bitLength, r);
        BigInteger q = BigInteger.probablePrime(bitLength, r);
        BigInteger n = p.multiply(q);
        BigInteger d;
        BigInteger c;
        BigInteger m2;

        BigInteger fi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        d = bigEvclid.return_inverse_element(e, fi);
        c = ba.mpow(m, e, n); //encrypt
        System.out.println("encript is : " + c);
        System.out.println("n is : " + n);
        m2 = ba.mpow(c, d, n); //decrypt
        System.out.println(m2);
    }

    public static void main(String[] args) {
        RSA r = new RSA();
        int ord = ' ';
        String s = "bebe0b93b184fd375c3462488c9fde01";
        System.out.println(ord);
        r.rsa(new BigInteger(String.valueOf(ord)));

    }
}
