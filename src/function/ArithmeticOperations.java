package function;

public class ArithmeticOperations {
    public int modpow(int number, int power, int modules) {
        long b = number;
        int k = power;
        long p = 1;

        while (k > 0) {
            if (k % 2 == 1) {
                p = p * b % modules;
            }
            b = b * b % modules;
            k = k / 2;

        }
        return (int) p;
    }

    private int msum(int number1, int number2, int modules) {
        return (int) (((long)number1 + number2) % modules);
    }

    private int msubtraction(int number1, int number2, int modules) {
        int result = 0;
        result = (number1 - number2) % modules;
        return result;
    }

    private int mdivision(int number1, int number2, int modules) {
        int result = 0;
        result = (number1 * number2) % modules;
        return result;
    }

    private int mmul(int number1, int number2, int modules) {
        int result = 0;
        result = (number1 / number2) % modules;
        return result;
    }

}
