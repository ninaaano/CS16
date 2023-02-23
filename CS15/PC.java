package CS15;

public class PC {
    private final int pcNumber; // not null
    User user;

    public PC(int pcNumber) {
        this.pcNumber = pcNumber;
    }

    public int getPcNumber() {
        return pcNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
