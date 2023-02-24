package CS15;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PcRepository {
    Connection conn;
    PreparedStatement preparedStatement;

    public PcRepository() {
        init();
    }

    private void init() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs15", "nino", "1234");
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
            preparedStatement = conn.prepareStatement("INSERT INTO pc (pc_number) values (?)");
            preparedStatement.setLong(1, pc.getPcNumber());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // addUser, stopUser - update
    // 연결을 끊지 않고 사용할 수 없다


    // pc정보 가져오기
    public List<PC> getPcList() {
        try {
            List<PC> pcList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery("select pc_number from pc where user_Id IS NULL");
            while (resultSet.next()) {
                int pcNumber = resultSet.getInt(1);
                pcList.add(new PC(pcNumber));
            }
            return pcList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addUser(int getCanUsePcNumber, long userId) {
        try {
            preparedStatement = conn.prepareStatement("update pc set user_id =? where pc_number =?");
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, getCanUsePcNumber);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertUser(long userId, String startTime, int pcNumber) {
        try {
            preparedStatement = conn.prepareStatement("insert into user (user_id, start_time, pc_number) values (?,?,?)");
            preparedStatement.setLong(1, userId);
            preparedStatement.setString(2, startTime);
            preparedStatement.setLong(3, pcNumber);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // db에 아이디가 있는지 없는지 확인
    public boolean isExistUserId(long userId) {
        try {
            preparedStatement = conn.prepareStatement("select user_id from user"); // 유저 아이디 반환
            ResultSet resultSet = preparedStatement.executeQuery();// 값 받기
            while (resultSet.next()) { // 값이 있냐 없냐 확인하는 것
                int result = resultSet.getInt(1);
                if (userId == result) { // 찾으려는 아이디와 검색한 아이디가 있으면 true 반환.
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    // stop 했을때 pcNumber에 해당한 userId null로 반환
    public void updatePcState(int pcNumber) {
        try {
            preparedStatement = conn.prepareStatement("update pc set user_id = NULL where pc_number = ? ");
            //preparedStatement.setLong(1, userId);
            preparedStatement.setLong(1, pcNumber);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // pc테이블에서 사용중인 pc number의 userId가 null이 아닌 값중 찾는 userId가 있는지 확인하기
    public int resetPcList(long userId){
        try {
            preparedStatement = conn.prepareStatement("select pc_number from pc where user_Id = ?");
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();// 값 받기
            if(resultSet.next()){
                int result = resultSet.getInt(1); // pcnumber
                return result;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}

