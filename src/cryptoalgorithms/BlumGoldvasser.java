//package cryptoalgorithms;
//
//import function.BigArithmeticOperations;
//
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class BlumGoldvasser {
//    BigInteger four = new BigInteger("4");
//    BigInteger three = new BigInteger("3");
//    Random rand = new Random();
//    int bitLength = 1024;
//    BigArithmeticOperations bao = new BigArithmeticOperations();
//
//    public void blum_goldvasser(BigInteger msg) {
//        BigInteger q = BigInteger.probablePrime(bitLength, rand);
//        BigInteger p = BigInteger.probablePrime(bitLength, rand);
//        List<BigInteger> x = new ArrayList<>();
//        List<BigInteger> g = new ArrayList<>();
//        List<BigInteger> c = new ArrayList<>();
//        BigInteger sigmaP;
//        BigInteger sigmaQ;
//        int k = msg.bitLength();
//        BigInteger n;
//        int h = 1;
//        int t;
//
//        BigInteger r;
//
//
//        // нахожу такеие p и q  чтобы p mod 4 = q mod 4 = 3;
//        while (!(q.mod(four).equals(three) && p.mod(four).equals(three))) {
//            if (!q.mod(four).equals(three))
//                q = BigInteger.probablePrime(bitLength, rand);
//            else
//                p = BigInteger.probablePrime(bitLength, rand);
//        }
//        // n = p x q;
//        n = p.multiply(q);
//
//        // h = log2(log2(n)); ????
//
//
//        // t = k/h;
//        t = k / h;
//
//        // r < n
//
//        do {
//            r = new BigInteger(bitLength, rand);
//        }
//        while (!(n.compareTo(r) > 0));
//
//        BigInteger z = new BigInteger(bitLength, rand);
//        z = z.modPow(BigInteger.TWO, n);
//        byte gHigh = z.byteValueExact();
//        z = z.modPow(BigInteger.TWO, n);
//        byte gLow = z.byteValueExact();
//        byte g = (gHigh << 4) | (gLow & 0x0F);
//
//        // находим х0 х1 х2 ... хt
//        x.add(r.pow(2));
//        for (int i = 1; i <= t; i++) {
//            x.add(x.get(i - 1).pow(2));
//        }
//
//        // находим g1 g2 g3 ... gt
//        for (int i = 0; i <= t; i++) {
//            g.add(x.get(i).mod(BigInteger.TWO.pow(h)));
//        }
//        // шифрование ????
//        BigInteger m = msg;
//        for (int i = 0; i < k; i++) {
//            c.add(g.get(i).xor(BigInteger.valueOf(m.getLowestSetBit())));
//            m = m.shiftRight(1);
//        }
//
//        // расшифрование
//
//        sigmaP = ((p.add(BigInteger.ONE)).divide(four)).pow(t+1).mod(p.subtract(BigInteger.ONE));
//        sigmaQ = ((q.add(BigInteger.ONE)).divide(four)).pow(t+1).mod(q.subtract(BigInteger.ONE));
//
//    }
//
//}
