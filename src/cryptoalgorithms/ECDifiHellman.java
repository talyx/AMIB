package cryptoalgorithms;

import function.BigEvclid;

import java.math.BigInteger;
import java.security.SecureRandom;

import java.util.Random;

public class ECDifiHellman {

    Random rand = new SecureRandom();
    BigInteger three = new BigInteger("3");
    int bitLength = 6;
    BigInteger Xp = new BigInteger("2");
    BigInteger Yp = new BigInteger("7");
    Point P = new Point(Xp, Yp);
    BigInteger q = new BigInteger("11");
    BigInteger a = new BigInteger("1");
    BigInteger b = new BigInteger("6");
    BigEvclid bigEvclid = new BigEvclid();

    public void ec_diffi_hellman_Allice() {

        System.out.println((Yp).pow(2).mod(q).equals((Xp.pow(3).add(a.multiply(Xp)).add(b)).mod(q)));
        if (((Yp).pow(2).mod(q).equals((Xp.pow(3).add(a.multiply(Xp)).add(b)).mod(q)))) {

            BigInteger aD;
            Point A;
            Point B;
            Point K;
            BigInteger key;

            do {
                aD = new BigInteger(bitLength, rand);
            }
            while (!(q.subtract(BigInteger.ONE).compareTo(aD) > 0));


            A = mult(aD, P);
            B = ec_diffi_hellman_Bob(A);

            K = mult(aD, B);
            key = K.getX();
            System.out.println(key);
        }

    }

    // Складываем точки P и Q
    private Point add_Point(Point P, Point Q) {
        Point M = new Point(); // Начальное значение = "Единичный элемент"
        BigInteger del;
        // Если один из точек это единичный элемент
        if (P.isSingleElement())
            M = Q;
        else if (Q.isSingleElement())
            M = P;

            // если точки  P и Q равны и не единичные элементы
        else if (P.equals(Q)) {

            del = ((three.multiply(P.getX().pow(2)).add(a)).multiply(bigEvclid.return_inverse_element(BigInteger.TWO.multiply(P.getY()), q))).mod(q);

            M.setX((del.pow(2).subtract(P.getX()).subtract(Q.getX())).mod(q));
            M.setY(((del.multiply(P.getX().subtract(M.getX()))).subtract(P.getY())).mod(q));

        }

        // Если точка P не равно точке Q  и ни один из них не единичный элемент и не обратные элементы
        else if (!P.equals(Q)  && !(P.inversElement(Q, q) || Q.inversElement(P, q))) {
            del = ((P.getY().subtract(Q.getY())).multiply(bigEvclid.return_inverse_element(P.getX().subtract(Q.getX()), q))).mod(q);
            M.setX((del.pow(2).subtract(P.getX()).subtract(Q.getX())).mod(q));
            M.setY(((del.multiply(P.getX().subtract(M.getX()))).subtract(P.getY())).mod(q));

        } //

        return M;
    }

    // Умножаем n на point
    private Point mult(BigInteger n, Point point) {
        Point M = new Point();
        for (int i = 0; i < n.bitLength(); i++) {
            if (n.testBit(i))
                M = add_Point(M, point);
            point = add_Point(point, point);
        }
        return M;
    }

    private Point ec_diffi_hellman_Bob(Point A) {
        BigInteger bD;
        BigInteger key;
        Point K;
        Point B;
        do {
            bD = new BigInteger(bitLength, rand);
        }
        while (!(q.subtract(BigInteger.ONE).compareTo(bD) > 0) && !bD.equals(BigInteger.ZERO));


        B = mult(bD, P);
        K = mult(bD, A);
        key = K.getX();
        System.out.println(key);
        return B;
    }
}
