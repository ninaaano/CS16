package CS10;

public class ProcessControlBlock {

    private int id;
    private String name; // 이름
    private ProcessStatus state; // (상태)
    private int runTime; // , 실행시간
    private int time; // / 주어진 시간 %d"sec"
    private int waitTime; // 대기시간 waiting %d "sec"

    public ProcessControlBlock(String name, int runTime) {
        this.name = name;
        this.runTime = runTime;
        this.state = ProcessStatus.READY;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProcessStatus getState() {
        return state;
    }

    public void setState(ProcessStatus state) {
        this.state = state;
    }

    public int getRunTime() {
        return runTime;
    }

    // 실행시간은 증가한다
    public void addRunTime(){
        runTime++;
    }

    public int getTime() {
        return time;
    }

    // 대기시간은 증가한다
    public void addWaitTime(){
        waitTime++;
    }

    public void printState() {
        System.out.println(name + "(" + state + "), " + runTime + " / " + time + "sec, waiting " + waitTime + " sec");
    }

    public void run() {
    }

    public boolean isTerminated() {
        return this.state == ProcessStatus.TERMINATED;
    }

    public boolean isRunning(String name) {
    }

    public void waiting() {
        this.state = ProcessStatus.WAITING;
        addWaitTime();
    }
}
