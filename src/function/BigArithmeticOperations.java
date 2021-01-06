package function;

import java.math.BigInteger;

public class BigArithmeticOperations {
    public BigInteger mpow(BigInteger number, BigInteger power, BigInteger modules) {
        BigInteger result = BigInteger.ONE;

        while (!power.equals(BigInteger.ZERO)) {
            if (power.mod(BigInteger.TWO).equals(BigInteger.ONE)) {
                result = result.multiply(number).mod(modules);
                power = power.subtract(BigInteger.ONE);
            }
            number = number.multiply(number).mod(modules);
            power = power.divide(BigInteger.TWO);

        }
        return result;
    }
    public BigInteger pow(BigInteger number, BigInteger power) {
        BigInteger result = BigInteger.ONE;

        while (!power.equals(BigInteger.ZERO)) {
            if (power.mod(BigInteger.TWO).equals(BigInteger.ONE)) {
                result = result.multiply(number);
                power = power.subtract(BigInteger.ONE);
            }
            number = number.multiply(number);
            power = power.divide(BigInteger.TWO);

        }
        return result;
    }

    private BigInteger modsum(BigInteger number1, BigInteger number2, BigInteger modules) {
        BigInteger result;
        result = (number1.add(number2)).mod(modules);
        return result;
    }

    private BigInteger modsubtraction(BigInteger number1, BigInteger number2, BigInteger modules) {
        BigInteger result;
        result = (number1.subtract(number2)).mod(modules);
        return result;
    }

    private BigInteger moddivision(BigInteger number1, BigInteger number2, BigInteger modules) {
        BigInteger result;
        result = (number1.multiply(number2.modInverse(modules))).mod(modules);
        return result;
    }

    private BigInteger modmul(BigInteger number1, BigInteger number2, BigInteger modules) {
        BigInteger result;
        result = (number1.multiply(number2)).mod(modules);
        return result;
    }

}