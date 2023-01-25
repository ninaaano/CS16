package CS03;

import java.util.Arrays;

public class CPU {

    private Register R;
    private ALU ALU;
    private ControlUnit CU;

    public CPU(Register R, ALU ALU, ControlUnit CU) {
        this.R = R;
        this.ALU = ALU;
        this.CU = CU;
    }

    /**
     * 레지스터 값을 모두 지우고 ,PC 값도 0으로 초기화한다
     */
    public void reset() {
        this.R.reset();
    }


    /**
     * 레지스터들 값을 배열에 넣어서 리턴한다
     * 코어 덤프란 특정 시점에서 작업 중이던 메모리 상태를 기록한 것.
     * 프로그램 카운터 등 CPU레지스터나 메모리 관리정보 포함
     */
    public void dump() {
        System.out.println(Arrays.toString(this.R.dump()));
    }

}
