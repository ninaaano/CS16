package CS15;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {
    private final long id; // key값 not null
    private final String startTime; // pc 시작시간 not null

    public User(long id, LocalDateTime startTime) {
        this.id = id;
        this.startTime = startTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

}
