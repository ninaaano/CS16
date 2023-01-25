package CS03;

import java.util.HashMap;

/**
 * 주소값을 가지고 있다
 */
public class Memory {
    private int addressValue;
    private static HashMap<Integer,Int16> memory;

    public Memory(int address, HashMap<Integer, Int16> memory) {
        this.addressValue = 10000;
        this.memory = new HashMap<>();
    }

    // 명령어 가져오기
    public static Int16 getCommandBit(int pc){
        return memory.get(pc);
    }

    // 명령어 집어넣기
    private void putCommandBit(int address, Int16 bit){
        memory.put(address,bit);
    }

    // 메모리 주소를 인자로 받으면 주소에 있는 값을 가져온다
    private int getValue(int address){
        Int16 bit = memory.get(addressValue + address);
        return bit.getBintoInt();
    }

    // 메모리 주소와 변경값을 인자로 받아서 메모리 주소 해당 값을 변경한다
    private void changeValue(int address, int value){
        memory.put(addressValue +  address, new Int16(Integer.toBinaryString(value)));
    }

    // 명령어가 있는지 없는지 확인한다
    private boolean isCommandBit(int pc){
        return memory.get(pc) != null;
    }
}
