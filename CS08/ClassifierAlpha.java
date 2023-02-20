package CS08;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ClassifierAlpha extends Factors {
    public ClassifierAlpha() {
    }

    public static int sum(Set<Integer> factors){
        return factors.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public boolean isPerfect(int number) {
        return sum(factors(number)) - number == number;
    }

    public boolean isAbundant(int number) {
        return sum(factors(number)) - number > number;
    }

    public boolean isDeficient(int number) {
        return sum(factors(number)) - number < number;
    }

    public static void main(String[] args) {
        ClassifierAlpha alpha1 = new ClassifierAlpha();
        ClassifierAlpha alpha2 = new ClassifierAlpha();

        Set<Integer> number = alpha1.factors(1);
        System.out.println(alpha1.sum(number));
        System.out.println(alpha2.sum(number));

        System.out.println(alpha1.isPerfect(100));
        System.out.println(alpha2.isPerfect(100));

        System.out.println(alpha1.isAbundant(100));
        System.out.println(alpha1.isAbundant(100));

        System.out.println(alpha1.isDeficient(100));
        System.out.println(alpha1.isDeficient(100));
    }
}
