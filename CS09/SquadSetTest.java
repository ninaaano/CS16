package CS09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

// @ author ninaaano
class SquadSetTest {

    SquadSet element;
    SquadSet other;

    @BeforeEach
    void test(){
        List<Integer> test = List.of(1,2,3);
        element = new SquadSet(test);
    }

    @Test
    void sum() {
        List<Integer> test = List.of(1,2,4);
        other = new SquadSet(test);
        // element.complement(other); command + option + v
        SquadSet sum = element.sum(other);

        Assertions.assertEquals(4, sum.size());
    }

    @Test
    void 차집합_갯수() {
        List<Integer> test = List.of(4,5,6);
        other = new SquadSet(test);
        // element.complement(other); command + option + v
        SquadSet complement = element.complement(other);

        Assertions.assertEquals(3, complement.size());
    }

    @Test
    void 교집합_갯수() {
        List<Integer> test = List.of(1,2,5);
        other = new SquadSet(test);
        SquadSet intersect = element.intersect(other);

        Assertions.assertEquals(2,intersect.size());
    }

    @Test
    void 배열로만들어라() {

        /**
         * List<String> stringList = new ArrayList<String>();
         * stringList.add("A");
         * stringList.add("B");
         * stringList.add("C");
         *
         * String[] stringArray = stringList.toArray(new String[0]);
         *
         * @Test
         * void test() {
         *     int[] ints = {1};
         *     int[] ints2 = {1};
         *     assertArrayEquals(ints, ints2);
         * }
         */



        // given
        SquadSet set =  new SquadSet(List.of(1,2,3));
        int[] extend = {1,2,3};
        // when
        int[] result = set.resultAll();

        // then
        Assertions.assertArrayEquals(extend, result);
    }

    @Test
    void 생성자_test(){
        List<Integer> test = List.of(1,1,2,3);
        SquadSet set = new SquadSet(test);
        Assertions.assertEquals(3,set.size());
    }


}