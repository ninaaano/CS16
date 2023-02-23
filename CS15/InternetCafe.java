package CS15;

import java.util.ArrayList;
import java.util.List;

public class InternetCafe {
    List<PC> pcList = new ArrayList<>();
    int size = 16; // pc의개수

    public InternetCafe() {
        for(int i=1; i<=size; i++){
            PC pc = new PC(i);
            pcList.add(pc);
        }
    }


}
