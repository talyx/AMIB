package function;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class test {
    public BigInteger normal_algorithm(BigInteger a, BigInteger b) {
        BigInteger tmp;
        while (!b.equals(new BigInteger("0")) ) {
            tmp = a;
            a = b;
            b = tmp.mod(b) ;
        }
        return a;
    }

    public static void main(String[] args) {
//        Random r = new Random();
//        BigInteger p = new BigInteger("174335366662137804634975970296771059146657889634117199387700484175413017086660003309042212777185377989606374096880427167285694176071328898029448103761843542338463459613360634027600451895372932529063419955774799409387184773093282700780868543017689480284199396645914206800034801130655494754569215256896061601949");//BigInteger.probablePrime(1024,r);
//        BigInteger one = new BigInteger("1");
//        BigInteger two = new BigInteger("2");
//        System.out.println(p.subtract(one).divide(two).isProbablePrime(1));
            BigInteger x = new BigInteger("-3");
            BigInteger t = new BigInteger("2338855939812928320724018997246799002770051855741125618853922113290468896207796472898308880440531832658276617412735305430839649489223910348135519903972502134801372257415734124397540109330405151747135921876787610906100609089366535572502067153729978785437562687703825617513825649293579183280980534033748185106147796560");
            BigInteger y = new BigInteger("2");
            System.out.println(y);
            BigInteger q = new BigInteger("151");
            BigInteger a = new BigInteger("-7");
            BigInteger b = new BigInteger("10");
        System.out.print((y).pow(2).mod(q).equals((x.pow(3).add(a.multiply(x)).add(b)).mod(q)));
    }
}
