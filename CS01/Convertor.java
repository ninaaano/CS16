import java.util.Arrays;
import java.util.Scanner;

public class Convertor {
    /**
     * 1.dec2bin() 함수
     * 0부터 256 미만의 Int 정수형 10진수를 [Bool] 2진수 배열로 변환하는 dex2bin 함수를 구현한다.
     * 기본 연산만으로 변환하는 방식을 구현한다
     * 기존에 진법변환 함수나 라이브러리를 사용하지 않는다
     * 만들어지는 비트 순서는 낮은 자리가 배열의 앞쪽에 오도록 표현한다. 배열의 순서대로 보면 이진수가 뒤집혀 있는 것처럼 보인다고 가정한다.
     * 이진수 1100 = [ false, false, true, true ] 이진수 0101 = [ true, false, true, false ]
     */
    public static boolean[] dec2bin(int decimal) {
        boolean[] answer = {};
        String ans = "";
        while (decimal > 0) {
            ans = ans + (decimal % 2);
            decimal /= 2;
        }
        // 변환한 길이만큼 배열의 길이 재지정
        answer = new boolean[ans.length()];
        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) == '1') {
                answer[i] = true;
            }
        }
        return answer;
    }

    /**
     * 2.bin2dec() 함수
     * [Bool] 2진수 배열을 Int 정수형 10진수로 변환하는 bin2dec 함수를 구현한다.
     * 기본 연산만으로 변환하는 방식을 구현한다.
     * 입력하는 비트 순서는 낮은 자리가 배열의 앞쪽에 오도록 표현한다. 배열의 순서대로 보면 이진수가 뒤집혀 있는 것처럼 보인다고 가정한다.
     * 이진수 1100 = [ false, false, true, true ] 이진수 0101 = [ true, false, true, false ]
     */
    public static int bin2dec(boolean[] bin) {
        int answer = 0;
        int temp = 1;
        for(int i=0; i<bin.length; i++){
            answer += bin[i] ? temp : 0;
            temp *= 2;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("10진법 -> 2진법 " + Arrays.toString(dec2bin(n)));
        System.out.println("2진법 -> 10진법" + bin2dec(dec2bin(n)));

    }
}
