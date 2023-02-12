package CS11;

import java.util.ArrayList;
import java.util.List;

/**
 * 일해라 노예
 * 동시에 2개까지 음료제조 가능
 * 스레드 직접 생성아님
 * 시작과 끝에 이벤트 발생
 * 발생할때마다 로그 출력
 */
public class Barista {
    // 2개 짜리 리스트를 만들어서 관리
    List<Coffee> brewingList = new ArrayList<>();

    public boolean isMakeCoffee(){
        return brewingList.size() < 2;
    }

    public void startMakeCoffee(Coffee coffee){ // 커피 내리기 시작
        brewingList.add(coffee);
        System.out.println(coffee.getName() + " 시작");
    }

    public void endMakeCoffee(){
        for(int i=brewingList.size()-1; i>=0; i--){ // 왜 감소하나요 알려주세요 현
            if(brewingList.get(i).brewing()){
                Coffee finished = brewingList.remove(i);
                System.out.println(finished.getName()+" 완성");
            }
        }
    }

    // 이게 필요한가?
    public boolean isBrewingListEmpty(){
        return brewingList.isEmpty();
    }

}
