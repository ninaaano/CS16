package CS08;

import java.util.HashSet;
import java.util.Set;

public class PrimeAlpha extends Factors {

    public boolean isPrime(int number) {
        Set<Integer> primeSet = new HashSet<>(){
            {add(1); add(number);}
        };
        return number > 1 && factors(number).equals(primeSet);
    }

    public static void main(String[] args) {
        PrimeAlpha prime1 = new PrimeAlpha();
        PrimeAlpha prime2 = new PrimeAlpha();

        System.out.println(prime1.isPrime(10));
        System.out.println(prime2.isPrime(10));
        System.out.println(factors(100));
        System.out.println(factors(100));
    }
}