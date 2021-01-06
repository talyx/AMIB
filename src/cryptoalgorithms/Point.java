package cryptoalgorithms;

import function.BigEvclid;

import java.math.BigInteger;

public class Point {
    private BigInteger x;
    private BigInteger y;
    BigEvclid bigEvclid = new BigEvclid();


    public Point(BigInteger x, BigInteger y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        x = new BigInteger("0");
        y = new BigInteger("0");
    }

    public BigInteger getX() {
        return x;
    }

    public BigInteger getY() {
        return y;
    }

    public void setX(BigInteger x) {
        this.x = x;
    }

    public void setY(BigInteger y) {
        this.y = y;
    }
    public boolean isSingleElement(){
        return x.equals(BigInteger.ZERO) && y.equals(BigInteger.ZERO);
    }
    public boolean equals(Point point){
        return x.equals(point.getX()) && y.equals(point.getY());
    }

    public boolean inversElement(Point q, BigInteger mod) {
        return x.equals(q.getX()) && y.equals(bigEvclid.return_inverse_element(q.getY(),mod));
    }
}
