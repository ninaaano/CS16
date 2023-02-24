package CS15;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 인터넷카페가 많은 역할을 한다
 * 클래스 이름을 볼때 그 역할만 하는지
 */
public class InternetCafe {
    public final Random random = new Random();
    List<PC> pcList = new ArrayList<>();
    int size = 16; // pc의개수
    PcRepository pcRepository = new PcRepository();

    public InternetCafe() {
        for(int i=1; i<=size; i++){
            PC pc = new PC(i);
            pcRepository.add(pc);
        }
    }

    /**
     * - pcList로 연결한거 pc레파지토리로 변경
     */

    // user를 받고 메소드에 더하면 pc 번호를 반환한다
    public int newUser(long userId){
        //        // 자리 확인 // null이면 자리가 있다는 뜻
        List<PC> canUsePc = getCanUsePc();
        if (canUsePc.isEmpty()){
            return 0; // 0을 가지고 에러를 던지던가 할 수 있다
        }
        int randomPcIndex = random.nextInt(canUsePc.size()); // 사용할 수 있는 pc중 랜덤
        // 사용할 수 있는 pc중 랜덤으로 선택
        //PC newPc = canUsePc.get(randomPcIndex);
        int getCanUsePcNumber = canUsePc.get(randomPcIndex).getPcNumber(); // 사용할 수 있는 랜덤 값 중 하나
        //newPc.setUser(new User(userId, LocalDateTime.now())); // 현재시간 기준으로 설정
        pcRepository.insertUser(userId, String.valueOf(LocalDateTime.now()),getCanUsePcNumber); // user table에 insert. 유저 생성
        pcRepository.addUser(getCanUsePcNumber,userId); // 생성한 유저 아이디
        //return newPc.getPcNumber();
        return getCanUsePcNumber; // pc번호 반환
    }


    // 사용할 수 있는 컴퓨터 리스트로 반환
    private List<PC> getCanUsePc() {
        //List<PC> canUsePc = pcList.stream().filter(pc -> pc.getUser() == null).collect(Collectors.toList());
        //return canUsePc;
        return pcRepository.getPcList();
    }

    // 유저 id를 받아서 stop
    public int stopUsePc(long userId){
        // 사용중인 pc 중 유저 아이디가 있는지 확인
        // pc테이블에서 null이 아닌 값중 찾는 userId가 있는지 확인하기
        int targetPcNumber = pcRepository.resetPcList(userId); // 값이 있는지 확인
        if(targetPcNumber == 0){
            return 0;
        }
//        Optional<PC> optionalTargetPc = pcList.stream().filter(pc -> pc.getUser() != null && pc.getUser().getId() == userId).findFirst();
//        if(optionalTargetPc.isEmpty()) {
//            return 0; // 없으면 0 반환
//        }
//        PC targetPc = optionalTargetPc.get();

        //pcRepository.updatePcState(targetPc.getPcNumber());

        pcRepository.updatePcState(targetPcNumber);
        // targetPc.setUser(null); // null 일때 사용중이던 pc를 사용할 수 있다.
       // return targetPc.getPcNumber();
        return targetPcNumber;
    }


    // 사용할 수 있는 컴퓨터 보여줌
    public void printResult() {
        System.out.println(getCanUsePc());
    }

    // 아이디 생성.
    public long createNewUserId() {
        int newUserId = getNewUserId();

        // 값이 있는지 없는지 확인하는 boolean형.
        while(pcRepository.isExistUserId(newUserId)){
            newUserId = getNewUserId(); // 아이디가 있으니까 새로운 아이디 랜덤 생성
        }

        return newUserId; // 새로운 아이디 반환
    }

    private int getNewUserId() {
        int newUserId;
        newUserId = random.nextInt(size + 1) + 1;
        return newUserId;
    }

//    private boolean isExistUserId(int newUserId) {
//        return pcList.stream().anyMatch(pc -> pc.getUser() != null && pc.getUser().getId()==newUserId);
//    }
}
