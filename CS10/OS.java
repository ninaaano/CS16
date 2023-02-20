package CS10;

public class OS {
    Memory memory;
    RoundRobinScheduling RR;

    public OS(RoundRobinScheduling RR) {
        this.RR = RR;
    }

    public OS(Memory memory) {
        this.memory = memory;

    }

    public void run() throws InterruptedException{
        while(true){
            Thread.sleep(1000);

            System.out.println(".");

            work();
        }
    }

    private void work() {
        ProcessControlBlock process = null;

        process = RoundRobinScheduling.run();

        process.run();
        RR.wait(process).stream()
                .forEach(ProcessControlBlock::waiting);
    }
}
