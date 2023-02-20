package CS10;

import java.util.*;
import java.util.stream.Collectors;

public class RoundRobinScheduling {

    private static List<ProcessControlBlock> processes = new ArrayList<>();
    private static Queue<ProcessControlBlock> readyQueue = new LinkedList<>();

    public RoundRobinScheduling() {

    }

    public static ProcessControlBlock run() {
        readyQueue.stream().filter(p -> !p.isTerminated()).



        return
    }

    /**
     * 랜덤으로 프로세스 3개를 만들어서 대기큐에 추가시키기
     */
    public void init(){

    }


    public List<ProcessControlBlock> wait(ProcessControlBlock process) {
        return processes.stream()
                .filter(p -> !p.isTerminated())
                .filter(p -> !p.isRunning(process.getName()))
                .collect(Collectors.toList());
    }
}
