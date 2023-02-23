package CS15;

/**
 * pc방 관리자
 */
public class Manager {
    public final Input input = new Input();
    InternetCafe internetCafe;

    public Manager() {
        this.internetCafe = new InternetCafe();
    }

    // 손님한테 자리를 줄것인지 없으면 없다할 것인지?
    public void newUser(){
        long userId = createUserId();
        int pcNumber = internetCafe.newUser(userId);
        if(pcNumber == 0)   {
            System.out.println("자리가 없다");
        }else{
            System.out.println(pcNumber + "번 자리에 앉으세요 : #" + userId);
        }
        printResult();
        requestInput();
    }

    private long createUserId() {
        return internetCafe.createNewUserId();
    }

    public void stopUser(long userId){
        int pcUseNumber = internetCafe.stopUsePc(userId);
        if(pcUseNumber == 0){
            System.out.println("잘못된 유저 아이디");
        }else{
            System.out.printf("이제 %d번 자리가 비었습니다.%n" , pcUseNumber);
        }
        printResult();
        requestInput();
    }

    private void printResult() {
        internetCafe.printResult();
    }

    public void openCafe(){
        System.out.println("> 빈 자리는 다음과 같습니다.");
        printResult();
        requestInput();
    }

    private void requestInput() {
        // 입력은 인풋에서
        Command command = input.requestInput();
        switch (command.getCommandType()) {
            case NEW: newUser(); break;
            case STOP: stopUser(command.getUserId()); break;
        }
    }
}
