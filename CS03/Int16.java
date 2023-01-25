package CS03;

public class Int16 {
    private String binary;

    public Int16(String binary) {
        this.binary = binary;
    }

    private String getBinary(){
        return binary;
    }

    public int getBintoInt() {
        return Integer.parseInt(binary,2); // 정수
    }
}
