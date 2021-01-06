package function;

import java.util.ArrayList;
import java.util.List;

public class Evclid {
    public int normal_algorithm(int a, int b) {
        int tmp;
        while (b != 0) {
            tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    public List<Integer> advanced_algorithm(int number_a, int number_b) {
        List<Integer> q = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        int i = 0;
        q.add(0);
        a.add(number_a);
        a.add(number_b);
        x.add(1);
        y.add(0);
        x.add(0);
        y.add(1);

        while (a.get(i + 1) != 0) {
            q.add(a.get(i) / a.get(i + 1));
            a.add(a.get(i) - a.get(i + 1) * q.get(i + 1));
            x.add(x.get(i) - x.get(i + 1) * q.get(i + 1));
            y.add(y.get(i) - y.get(i + 1) * q.get(i + 1));
            i++;
        }
        List<Integer> gcd = new ArrayList<>();
        gcd.add(x.get(i));
        gcd.add(y.get(i));
        gcd.add(a.get(i));
        return gcd;
    }
}
