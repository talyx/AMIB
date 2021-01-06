package cryptoalgorithms;

import function.BigArithmeticOperations;
import function.BigEvclid;

import javax.print.DocFlavor;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class test {
    BigArithmeticOperations bigAO = new BigArithmeticOperations();
    BigInteger minusOne = new BigInteger("-1");
    BigEvclid bigEvclid = new BigEvclid();
    BigInteger eight = new BigInteger("8");

    Random rand = new SecureRandom();
    BigInteger one = new BigInteger("1");
    BigInteger three = new BigInteger("3");
    int bitLength = 6;
    BigInteger Xp = new BigInteger("2");
    BigInteger Yp = new BigInteger("7");
    Point P = new Point(Xp, Yp);
    Point Q = P;//new Point(new BigInteger("10"), new BigInteger("12"));
    BigInteger q = new BigInteger("11");
    BigInteger a = new BigInteger("1");
    BigInteger b = new BigInteger("6");
    BigInteger del;


    public static void main(String[] args) {

        BigInteger msg = new BigInteger("555");
        BigInteger x;
        int bitLength = 1024;
        Random rand = new SecureRandom();
        List<BigInteger> c = new ArrayList<>();
        BigInteger p;
        BigInteger q;
        BigInteger n;
        for (int i = msg.bitLength() - 1; i >= 0; i--) {

            if (msg.testBit(i)) {
                c.add(BigInteger.ONE);
                //c.add(x.pow(2).mod(n));
            } else
                c.add(BigInteger.ZERO);
            //c.add(y.multiply(x.pow(2)).mod(n));
        }
        System.out.println(c);
//        System.out.println(c.size() );
//        System.out.println(msg.bitLength());
        List<Integer> m = new ArrayList<>();
    }
}
// расшифрование
//        for (int i = 0; i < c.size(); i++) {
//            if () {
//                m.add(1);
//            } else {
//                m.add(0);
//            }
//        }
//    }

//    private BigInteger get_lejandra_simbol(BigInteger a, BigInteger n) {
//        BigInteger temp;
//        BigInteger counter = BigInteger.ONE;
//        BigInteger res = BigInteger.ONE;//‭101 1110 1101 1111 0111 1110‬
//        a = a.mod(n);
//
//        do {
//            if (a.equals(minusOne)) {
//                res = bigAO.pow(minusOne, (n.subtract(BigInteger.ONE).divide(BigInteger.TWO)));
//            } else if (a.equals(BigInteger.TWO)) {
//                res = bigAO.pow(minusOne, (n.pow(2).subtract(BigInteger.ONE).divide(eight)));
//                a = a.divide(BigInteger.TWO);
//            } else if (a.mod(BigInteger.TWO).equals(BigInteger.ONE)) {
//                counter = counter.multiply(bigAO.pow(minusOne, (a.subtract(BigInteger.ONE).divide(BigInteger.TWO)).multiply(n.subtract(BigInteger.ONE).divide(BigInteger.TWO))));
//                temp = a;
//                a = n.mod(temp);
//                n = temp;
//            } else if (a.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
//                int pow = 0;
//                while (a.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
//                    a = a.divide(BigInteger.TWO);
//                    pow++;
//                }
//                counter = counter.multiply(get_lejandra_simbol(BigInteger.TWO, n).pow(pow));
//            }  if (a.equals(BigInteger.ONE)) {
//                res = res.multiply(counter);
//            }
//        }
//        while (!(a.equals(BigInteger.ONE)));
//
//        return res;
//    }

//    private BigInteger get_lejandra_simbol(BigInteger a, BigInteger n) {
//        BigInteger temp;
//        BigInteger counter = BigInteger.ONE;
//        BigInteger res = BigInteger.ONE;
//        a = a.mod(n);
//
//        do {
//            if (a.equals(BigInteger.ONE)) {
//                res = BigInteger.ONE.multiply(counter);
//            } else if (a.equals(minusOne)) {
//                res = bigAO.pow(minusOne ,(n.subtract(BigInteger.ONE).divide(BigInteger.TWO)));
//            } else if (a.equals(BigInteger.TWO)) {
//                res = bigAO.pow(minusOne,(n.pow(2).subtract(BigInteger.ONE).divide(eight)));
//                a = a.divide(BigInteger.TWO);
//            } else if (a.mod(BigInteger.TWO).equals(BigInteger.ONE)) {
//                counter = counter.multiply(bigAO.pow(minusOne, (a.subtract(BigInteger.ONE).divide(BigInteger.TWO)).multiply(n.subtract(BigInteger.ONE).divide(BigInteger.TWO))));
//                temp = a;
//                a = n.mod(temp);
//                n = temp;
//            } else if (a.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
//                int pow = 0;
//                while (a.mod(BigInteger.TWO).equals(BigInteger.ZERO)){
//                    a = a.divide(BigInteger.TWO);
//                    pow++;
//                }
//                counter = counter.multiply(get_lejandra_simbol(BigInteger.TWO, n).pow(pow));
//            }
//        }
//        while (!(a.equals(BigInteger.ONE)));
//
//        return res;
//    }
//    private Point mult(BigInteger n, Point point) {
//        Point M = new Point();
//        for (int i = 0; i <= bitLength; i++) {
//            if (n.testBit(i))
//                M = add_Point(M, point);
//            point = add_Point(point, point);
//        }
//
//        return M;
//    }
//
//    private Point add_Point(Point P, Point Q) {
//        Point M = new Point(); // Начальное значение = "Единичный элемент"
//        BigInteger del;
//        // Если один из точек это единичный элемент
//        if ((P.isSingleElement() || Q.isSingleElement()) && !(P.equals(Q))) {
//            if (P.isSingleElement())
//                M = Q;
//            else
//                M = P;
//        }
//
//        // если точки  P и Q равны и не единичные элементы
//        else if (P.equals(Q) && !P.isSingleElement()) {
//
//            del = ((three.multiply(P.getX().pow(2)).add(a)).multiply(bigEvclid.return_inverse_element(BigInteger.TWO.multiply(P.getY()), q))).mod(q);
//
////                System.out.println(del);
//            M.setX((del.pow(2).subtract(P.getX()).subtract(Q.getX())).mod(q));
//            M.setY(((del.multiply(P.getX().subtract(M.getX()))).subtract(P.getY())).mod(q));
//
////            System.out.println(M.getX());
////            System.out.println(M.getY());
//        }
//
//        // Если точка P не равно точке Q  и ни один из них не единичный элемент и не обратные элементы
//        else if (!P.equals(Q) && !(P.isSingleElement() || Q.isSingleElement()) && !(P.inversElement(Q, q) || Q.inversElement(P, q))) {
//            del = ((P.getY().subtract(Q.getY())).multiply(bigEvclid.return_inverse_element(P.getX().subtract(Q.getX()), q))).mod(q);
//
////                System.out.println(del);
//            M.setX((del.pow(2).subtract(P.getX()).subtract(Q.getX())).mod(q));
//            M.setY(((del.multiply(P.getX().subtract(M.getX()))).subtract(P.getY())).mod(q));
//
////            System.out.println(M.getX());
////            System.out.println(M.getY());
//        }
////        System.out.println("1 условие:" + ((P.isSingleElement() || Q.isSingleElement()) && !(P.equals(Q))));
////        System.out.println("2 условие:" + (P.equals(Q) && !P.isSingleElement()));
////        System.out.println("3 условие:" + (!P.equals(Q) && !(P.isSingleElement() || Q.isSingleElement()) && !(P.inversElement(Q, q) || Q.inversElement(P, q))));
//        return M;
//
//    }
//}
//        del =((three.multiply(P.getX().pow(2)).add(a)).multiply(bigEvclid.return_inverse_element(BigInteger.TWO.multiply(P.getY()),q))).mod(q);
////        del = ((P.getY().subtract(Q.getY())).multiply(bigEvclid.return_inverse_element(P.getX().subtract(Q.getX()), q))).mod(q);
//                M.setX((del.pow(2).subtract(P.getX()).subtract(Q.getX())).mod(q));
//                M.setY(((del.multiply(P.getX().subtract(M.getX()))).subtract(P.getY())).mod(q))