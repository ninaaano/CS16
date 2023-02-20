package CS10;

import java.util.ArrayList;
import java.util.List;

public class Mission1 {
    public static void main(String[] args) {

        List<ProcessControlBlock> process = List.of(
                new ProcessControlBlock("A", 3),
                new ProcessControlBlock("B", 5),
                new ProcessControlBlock("C", 7),
                new ProcessControlBlock("D", 10),
                new ProcessControlBlock("E", 15),
                new ProcessControlBlock("F", 21)
        );

        RoundRobinScheduling RR = new RoundRobinScheduling();
        //RR.run(process);

    }
}
