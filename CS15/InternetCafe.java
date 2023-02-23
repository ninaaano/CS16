package CS15;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class InternetCafe {
    public final Random random = new Random();
    List<PC> pcList = new ArrayList<>();
    int size = 16; // pc의개수

    public InternetCafe() {
        for(int i=1; i<=size; i++){
            PC pc = new PC(i);
            pcList.add(pc);
        }
    }

    // user를 받고 메소드에 더하면 pc 번호를 반환한다
    public int newUser(long userId){
        // 자리 확인 // null이면 자리가 있다는 뜻
        List<PC> canUsePc = pcList.stream().filter(pc -> pc.getUser() == null).collect(Collectors.toList());
        if (canUsePc.isEmpty()){
            return 0; // 0을 가지고 에러를 던지던가 할 수 있다
        }
        int randomPcIndex = random.nextInt(canUsePc.size()); // 사용할 수 있는 pc중 랜덤
        // 사용할 수 있는 pc중 랜덤으로 선택
        PC newPc = canUsePc.get(randomPcIndex);
        newPc.setUser(new User(userId, LocalDateTime.now())); // 현재시간 기준으로 설정
        return newPc.getPcNumber();
    }

    // 유저 id를 받아서 stop
    public int stopUsePc(long userId){
        // 유저 아이디가 있는지 확인
        Optional<PC> optionalTargetPc = pcList.stream().filter(pc -> pc.getUser().getId() == userId).findFirst();
        if(optionalTargetPc.isEmpty()) {
            return 0; // 없으면 0 반환
        }
        PC targetPc = optionalTargetPc.get();
        targetPc.setUser(null); // null 일때 사용중이던 pc를 사용할 수 있다.
        return targetPc.getPcNumber();
    }


}
