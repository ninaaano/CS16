package CS11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Input {
    static final String command = "> ";
    private final BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    public static void printMenu(){
        System.out.println(command + "메뉴 = 1. 아메리카노(3s)    2. 카페라떼(5s)    3. 프라프치노(10s)");
        System.out.println(command + "주문할 음료를 입력하세요. 예) 아메리카노 2개 => 1:2 ");
    }

    public void command(){
        System.out.print(command);
    }


    public String userInput() throws IOException {
        return read.readLine();
    }

//    public List<Menu> inputParser() throws IOException {
//        String[] userInput = userInput().split(":");
//        int drink = Integer.parseInt(userInput[0]);
//        int count = Integer.parseInt(userInput[1]);
//        List<Menu> menus = new ArrayList<>();
//        menus.add(new Menu(drink,count));
//        return menus;
//    }

}

