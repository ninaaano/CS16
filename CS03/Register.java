package CS03;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * - 레지스터(Register)
 * 명령어를 실행하기 위해 필요한 데이터와 상태, 명령어를 저장
 * 레지스터는 CPU 내부에 있다
 */
public class Register {
    private int programCounter;
    private int[] register;

    public Register() {
        this.programCounter = 0;
        register = new int[7]; // r1~r7
    }

    public void increaseProgramCounter() {
        this.programCounter++;
    }

    public int getProgramCounter(){
        return this.programCounter;
    }

    public void createRegister(int index,int value){
        this.register[index-1] = value;
    }

    public int getRegister(int index) {
        return this.register[index-1];
    }

    /**
     * 레지스터 값을 모두 지우고 ,PC 값도 0으로 초기화한다
     */
    public void reset() {
        this.programCounter = 0;
        Arrays.setAll(this.register, num -> 0); // 배열초기화
    }

    /**
     * 레지스터들 값을 배열에 넣어서 리턴한다
     * 코어 덤프란 특정 시점에서 작업 중이던 메모리 상태를 기록한 것.
     * 프로그램 카운터 등 CPU레지스터나 메모리 관리정보 포함
     */
    public int[] dump() {
        int[] result = new int[8]; // 0~6 r1~r7
        IntStream.range(0, register.length)
                .forEach(n -> result[n] = register[n]);
        result[7] = programCounter;
        return result;
    }

}
