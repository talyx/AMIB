package cryptoalgorithms;

import function.BigArithmeticOperations;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DifiHellman {
    int bitLength = 1024;
    Random rand = new SecureRandom();
    BigInteger generator;
    BigArithmeticOperations biga = new BigArithmeticOperations();
    List<BigInteger> q = new ArrayList<>();

    public BigInteger PrimitiveRoot(BigInteger p, List<BigInteger> q) {
        do {
            generator = BigInteger.probablePrime(bitLength, rand);
        }
        while (p.subtract(BigInteger.ONE).compareTo(generator) < 0);
        for (int i = 0; i < 2; i++)
            if (biga.mpow(generator, (p.subtract(BigInteger.ONE).divide(q.get(i))), p).equals(BigInteger.ONE)) return PrimitiveRoot(p, q);
        return generator;
    }
    public void DifiHellmanAlice(){
        BigInteger A;
        BigInteger B;
        BigInteger K;
        BigInteger p;
        BigInteger a = new BigInteger(bitLength,rand);

        do {
            p = BigInteger.probablePrime(bitLength, rand);
        }
        while (p.subtract(BigInteger.ONE).divide(BigInteger.TWO).isProbablePrime(50));
        q.add(p.subtract(BigInteger.ONE).divide(BigInteger.TWO));
        q.add(BigInteger.TWO);
        PrimitiveRoot(p,q);
        A = biga.mpow(generator,a,p);
        B = DifiHellmanBob(generator,p,A);
        K = biga.mpow(B,a,p); //secret key
    }
    public BigInteger DifiHellmanBob(BigInteger g, BigInteger p, BigInteger A){
        BigInteger B ;
        BigInteger K ;
        BigInteger b = new BigInteger(bitLength,rand);
        K = biga.mpow(A,b,p); //secret key
        System.out.println(K);
        B = biga.mpow(g,b,p);
        return B;
    }
}
