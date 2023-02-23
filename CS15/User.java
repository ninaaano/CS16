package CS15;

import java.time.LocalDateTime;

public class User {
    private final long id; // key값 not null
    private final LocalDateTime startTime; // pc 시작시간 not null
    int endTime; // pc 종료시간
    int pcNumber; // not null

    public User(long id, LocalDateTime startTime) {
        this.id = id;
        this.startTime = startTime;
    }

    public long getId() {
        return id;
    }


    public LocalDateTime getStartTime() {
        return startTime;
    }


    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getPcNumber() {
        return pcNumber;
    }

    public void setPcNumber(int pcNumber) {
        this.pcNumber = pcNumber;
    }
}
