package CS09;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 불변 타입
 * 초기화할 때만 배열로 값을 넘길 수 있다
 * 추가, 삭제 안됨
 * 수학에서 집합 개념 지원. 요소가 중복되서는 안된다
 *
 * 집합을 구현할 때 array또는 list배열만 사용
 * 입력이나 출력용으로 object,map 구조로 값을 전달하는 것은 가능
 */
public class SquadSet {

    final List<Integer> element;

    // 생성자에서 중복제거
    public SquadSet(List<Integer> element) {
        this.element = element.stream()
                .distinct()
                .collect(Collectors.toList());
    }


    /**
     * SquadSet에 다른 other SquadSet 요소들을 더해서 합집합 리턴.
     * 이미 같은 값이 있으면 추가하지 않는다
     * @return
     */
    public SquadSet sum(SquadSet other){
        List<Integer> temp = other.element;
        List<Integer> result = Stream.concat(element.stream(), temp.stream())
                .collect(Collectors.toList());
        return new SquadSet(result);
    }

    /**
     * SquadSet에서 다른 other SquadSet 요소를 빼서 차집합 리턴
     * 값이 포함되어 있지 않으면 아무런 변화도 없다
     */
    public SquadSet complement(SquadSet other){
        List<Integer> result = element.stream().filter(key -> !other.contains(key))
                .collect(Collectors.toList());
        return new SquadSet(result);
    }

    /**
     * SquadSet과 다른 other SquadSet값과 비교해서 두 집합에 모두 있는 원소 교집합을 리턴
     */
    public SquadSet intersect(SquadSet other){
        List<Integer> result = element.stream().filter(other::contains).collect(Collectors.toList());
        return new SquadSet(result);
    }

    private boolean contains(int other) {
        return element.contains(other);
    }

    /**
     * 모든 요소를 1차원 배열로 리턴
     */
    public int[] resultAll(){
        return element.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void print(SquadSet result){
         result.element.stream().forEach(System.out::println);

//        IntStream stream = IntStream.of(result.resultAll());
//
//        System.out.println(result.element.stream()
//                        .map(i -> int)
//                .collect(Collectors.joining(", ")));



    }

    public int size(){
        return this.element.size();
    }

    public static void main(String[] args) {
        SquadSet A = new SquadSet(List.of(1,2,3));
        SquadSet B = new SquadSet(List.of(3,4,5,6));

        SquadSet sum = A.sum(B);
        SquadSet complement = A.complement(B);
        SquadSet intersect = A.intersect(B);

        int[] arrA = A.resultAll();
        int[] arrB = B.resultAll();

        print(sum);
        System.out.println("----------------");
        print(complement);
        System.out.println("----------------");
        print(intersect);
        System.out.println("----------------");

        for(int i : arrA){
            System.out.println("A 배열" + i);
        }

        System.out.println("----------------");

        for(int i : arrB){
            System.out.println("B 배열" + i);
        }

    }
}
