package CS03;

/**
 * - 제어장치(CU, Control Unit)
 * 명령어 레지스터에 저장된 명령어를 해석
 * 컴퓨터 구성요소는 제어장치의 관리를 받음
 * 메모리에서 명령을 가져오고, 디코딩해서, 실행할 때까지 각 컨트롤 신호를 만드는 역할(각 컴퓨터 구성요소를 제어할 제어신호를 생성)
 */
public class ControlUnit {
    /**
     * 현재 pc값에 해당하는 메모리에서 프로그램 명령어를 가져와서 리턴한다
     * pc카운트를 +1 증가시킨다
     * fetch에서 리턴한 명령을 execute에 넘겨준다
     */
    public Int16 fetch(Register register) {
        Int16 bit = Memory.getCommandBit(register.getProgramCounter());
        register.increaseProgramCounter();
        return bit;
    }

    /**
     * 전달한 명령어를 어떤 명령인지 분석해서 계산하거나 처리한다
     */
    public void execute() {

    }
}
