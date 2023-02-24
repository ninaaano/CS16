package CS15;

public class PC {
    private final int pcNumber; // not null
    User user; // 순환하면서 비교할 수 있다

    public PC(int pcNumber) {
        this.pcNumber = pcNumber;
    }

    public int getPcNumber() {
        return pcNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(pcNumber);
    }
}
