package CS08;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Factors {

    // 약수 판별
    public static boolean isFactor(int number, int potentialFactor) {
        return number % potentialFactor == 0;
    }

    // 약수를 구하는 메소드
    public static Set<Integer> factors(int number) {
        return Stream.iterate(1, pod -> pod <= Math.sqrt(number), pod -> pod++)
                .filter(pod -> isFactor(number,pod))
                .map(pod -> List.of(pod,number/pod))
                .flatMap(Collection::stream) // map만 해주면 에러
                .collect(Collectors.toSet());
    }


}
