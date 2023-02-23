package CS15;

public class Command {
    private final CommandType commandType; // 필수니까 private final
    int userId;


    public Command(CommandType commandType) {
        this.commandType = commandType;
    }

    public Command(CommandType commandType, String userId) {
        this.commandType = commandType;
        this.userId = Integer.parseInt(userId);
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
