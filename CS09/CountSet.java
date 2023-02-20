package CS09;

/**
 * 불변 타입으로 초기화할 때 Object 또는 HashMap으로 값을 넘길 수 있다
 * 새로운 요소를 추가하거나 삭제하면 새로운 CountSet 리턴
 * 요소가 중복해서 있을 수 있고, 요소별 카운트 값을 가지고 있다
 */
public class CountSet {

    /**
     * 새로운 요소를 추가하고 새로운 카운트셋 리턴. 이미 있는 경우 카운트만 증가하고 리턴
     * @return
     */
    public CountSet append(){

        return null;
    }

    /**
     * 기존에 요소가 있으면 카운트를 줄인다. 만약 0이되면 제거한 카운트 셋을 리턴한다
     * @return
     */
    public CountSet remove(){

        return null;
    }

    /**
     * 특정 요소에 대한 카운트 값 리턴
     * @return
     */
    public int countFor(){

        return 0;
    }

    /**
     * 카운트 셋에 다른 카운트 셋 요소들을 더해서 합집합 리턴
     * 이미 같은 값이 있으면 합쳐서 카운트를 올린다
     * @return
     */
    public CountSet sum(){

        return null;
    }

    /**
     * 카운트셋에서 다른 카운트셋 요소를 빼서 차집합 리턴
     * 값이 포함되어 있지 않으면 아무런 변화도 없다
     * 만약 현재 카운트셋보다 빼려는 카운트셋 요소카운트가 더 큰 경우는 제거
     * count는 마이너스가 되지않고 0보다 같거나 작으면 제거한다
     */
    public CountSet complement(){

        return null;
    }

    /**
     * set과 다른 other countset 값과 비교해서 두 집합에 모두 있는 원소
     * 교집합 리턴. 교집합 카운트는 모두 1로 리턴
      */

    public CountSet intersect(){

        return null;
    }

    /**
     * 모든 요소와 카운트를 오브젝트 형태로 리턴
     */
    public void resultAll(){

    }


}
