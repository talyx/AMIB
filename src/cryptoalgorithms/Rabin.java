//package cryptoalgorithms;
//
//import function.BigEvclid;
//
//import java.math.BigInteger;
//import java.util.Random;
//
//public class Rabin {
//    Random rand = new Random();
//    BigEvclid bigEvclid = new BigEvclid();
//    BigInteger four = new BigInteger("4");
//    BigInteger three = new BigInteger("3");
//    int bitLength = 1024;
//
//    public void rabin(BigInteger M) {
//        BigInteger p = BigInteger.probablePrime(bitLength, rand);
//        BigInteger q = BigInteger.probablePrime(bitLength, rand);
//        BigInteger N;
//        BigInteger Yp;
//        BigInteger Yq;
//        // возможные варианты
//        BigInteger r;
//        BigInteger nr;
//        BigInteger s;
//        BigInteger ns;
//        while (!(q.mod(four).equals(three) && p.mod(four).equals(three))) {
//            if (!q.mod(four).equals(three))
//                q = BigInteger.probablePrime(bitLength, rand);
//            if (!p.mod(four).equals(three))
//                p = BigInteger.probablePrime(bitLength, rand);
//        }
//        N = p.multiply(q);
//
//
//
//        //c = m^2
//
//
//        Yp = bigEvclid.return_inverse_element(p,q);
//        Yq = bigEvclid.return_inverse_element(q,p);
//
//        BigInteger t = Yq.multiply(q).multiply(C);
//        BigInteger u = Yp.multiply(p).multiply(C);
//
//        r = (u.add(t)).mod(N);
//        nr = N.subtract(r);
//        s = (u.subtract(t)).mod(N);
//        ns = N.subtract(s);
//    }
//}
