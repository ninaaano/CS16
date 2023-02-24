package CS15;

import java.sql.*;

public class PcRepository {


    Connection conn;

    public PcRepository() {
        init();
    }

    private void init() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs15", "nino","1234");
            System.out.println("연결완료");
            initTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void initTable() {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("drop table if exists pc");
            stmt.execute("drop table if exists user");
            stmt.execute("CREATE TABLE user (user_Id int PRIMARY KEY , start_time DATETIME NOT NULL , end_time DATETIME, pc_number INT not null)");
            stmt.execute("CREATE TABLE pc (pc_number int PRIMARY KEY, user_Id int , FOREIGN KEY(user_Id) references user (user_Id))");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(PC pc) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO pc (pc_number) values (?)");
            preparedStatement.setLong(1,pc.getPcNumber());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // addUser, stopUser - update
    // 연결을 끊지 않고 사용할 수 없다

}
