package CS15;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {

    public static final Scanner sc = new Scanner(System.in);
    public static final String stopCommandPattern = "stop [1-9][0-9]*";

    public Command requestInput(){
        System.out.print("> ");
        String input = sc.nextLine();
        if(input.equals("new")) {
            return new Command(CommandType.NEW);
        }
        if(validInput(input)) {
            String[] inputArr = input.split(" ");
            return new Command(CommandType.STOP,inputArr[1]);
        }
        System.out.println("잘못 입력");
        return requestInput();
    }

    private boolean validInput(String input) {
        return Pattern.matches(stopCommandPattern,input);
    }


}

