package CS05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class View {

    // 입력받기
    public String requestInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    // 입력 시 메세지
    public void requestInputCoordinate() {
        System.out.println("> 좌표를 입력하세요.");
    }

    // 출력 시 메세지
    public void printDistacne(String distance) {
        System.out.println(distance);
    }

    // List 반환
    public static List<Coordinate> getCoordinate(String input) {
        List<Coordinate> coordinate = new ArrayList<>();
        for (String value : input.split("-")) {
            value = removeBracket(value);
            putCoordinate(coordinate, value);
        }
        return coordinate;
    }

    // "," 기준으로 분할
    public static void putCoordinate(List<Coordinate> coordinate, String input) {
        String[] infos = input.split(",");
        coordinate.add(new Coordinate(Integer.parseInt(infos[0]), Integer.parseInt(infos[1])));
    }

    // 양쪽 괄호 자르기
    public static String removeBracket(String input) {
        input = input.replace("(", "");
        input = input.replace(")", "");
        return input;
    }

    public void printBorad(List<Coordinate> coordinates){
        for(int y = 24; y>0; y--){
            if(y%2==0){
                System.out.printf("%2d|",y);
            }else{
                System.out.print("  |");
            }
            System.out.print("  ");
            for(int x = 1; x < 24; x++){
                if(coordinates.contains(new Coordinate(x,y))){
                    System.out.print("         *");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.print("  +");
        for(int i=0; i<24; i++){
            System.out.print("___");
        }
        System.out.println();
        System.out.print(" 0 ");
        for(int i=2; i<=24; i+=2){
            System.out.printf("%6d",i);
        }
        System.out.println();
    }
}
