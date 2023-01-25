package CS04;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Memory {
    private int stackPointer;
    private Map<String,Integer> storeType = new HashMap<>();

    /**
     * 프로세스 공간을 위한 기본 주소 리턴
     * @param stackSize
     * @param heapSize
     * @return
     */
    public int init(int stackSize,int heapSize){
        return 0;
    }

    /**
     * type 별로 고유한 사이즈를 가지도록 등록한다
     * 이미 등록한 타입은 다시 사이즈를 바꿀 수 없다
     * 사이즈는 1,2,4,8,16,32 중 하나만 가능
     * @param type
     * @param length
     */
    public void setSize(String type, int length){
        storeType.put(type,length);
    }

    /**
     * 이미 등록된 type에 대해 count만큼 반복해서 메모리를 할당하고 시작 위치 고유 주소를 스택영역에 추가하고 스택 주소값 리턴
     * 만약 해당 타입 크기가 8바이트보다 작은 경우 패딩을 붙려서 8바이트로 만든 후 count 만큼 반복
     * 예를 들어 boolean타입을 1로 등록하고 malloc("boolean",4)를 호출한다면
     * 패딩을 붙여 8바이트 단위로 4개 = 총 32바이트를 할당한다
     * 힙 영역에 동적으로 메모리를 할당하는 함수
     * 단순히 메모리만 할당하는 거라서 void로 만들어야한다?
     * @param type
     * @param count
     * @return
     */

    public int malloc(String type, int count){

        return count;
    }

    /**
     * malloc할 때 할당 했던 스택 주소값을 입력 받는다.
     * 스택 주소 값에 있는 힙영역 고유주소를 찾아서 해제하고 반환
     * @param pointer
     */
    public void free(int pointer){

    }

    /**
     * 마지막 스택 위치를 알려주는 스택 포인터에 포인터 변수 paramCount 만큼 반복해서 생성하고
     * 스택 포인터를 증가시킨다
     * 0 <= paramCount <= 10
     * name.length max = 8
     * call 실행할 때마다 name 값을 스택에 기록하고 아래 callstack()에서 활용
     * @param name
     * @param paramCount
     */
    public void call(String name, int paramCount){

    }

    /**
     * 증가했던 스택 공간을 비우고 이전 호출 위치로 이동한다.
     * 이 때 name값은 call() 호출로 가장 최근에 호출한 name과 동일해야한다
     * 만약 call() 호출 이후 malloc()으로 생성한 stack 영역에 포인터 값이 있다면 같이 비운다
     * 단, malloc()을 생성된 힙 영역의 메모리는 free()할 수 없고
     * 스택에 있던 포인터 변수만 삭제한다
     * call()을 호출한 경우가 없을 경우 아무런 동작 x
     * @param name
     */
    public void returnFrom(String name){

    }

    /**
     * 스택 영역 전체 크기, 사용중인 용량, 남은 용량, 힙 영역 전체 크기, 사용중인 용량, 남은 용량 순서대로 배열에 리턴
     * @return
     */
    public Memory[] usage() {

        return new Memory[0];
    }

    /**
     * 현재 스택에 쌓여있는 호출 스택을 문자열로 리턴
     * 출력하는 스택 포인터는 base address + offset address 형태로 표현
     * @return
     */
    public String[] callstack(){

        return new String[0];
    }

    /**
     * 힙 영역에서 사용중인 상태를 문자열 배열로 표현해서 리턴
     * 힙 영역에 정보는 타입과 크기, 해당 주소를 참조하는 스택 포인터 변수 정보도 포함
     * 모든 포인터 주소 값은 base address + offset address 형태로 표현
     * 예를 들어 call("foo", 0), call("bar", 1), call("dap", 2) 순서로 호출한 경우는 foo() 0xAF00 -> bar() 0xB100 -> dap() 0xBF00 형태로 함수 이름과 스택의 주소를 리턴한다.
     * 그 후에 returnFrom("dap") 호출한 경우는 foo() 0xAF00 -> bar() 0xB100 형태로 dap을 리턴하고 남은 함수 이름과 스택의 주소를 리턴한다.
     * @return
     */
    public String[] heapdump(){

        return new String[0];
    }

    /**
     * 힙 영역에 할당된 타입들 중에서 스택에 포인터 변수가 없는 경우를 찾아서 해제하는 동작
     */
    public void garbageCollect(){

    }

    /**
     * 모든 stack과 heap 공간을 비우고 init했을 때와 동일하게 초기상태로 만든다
     */
    public void reset(){

    }


}
