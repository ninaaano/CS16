package CS14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Random;
public class InsertRandomData {

    DataMaker dataMaker = new DataMaker();
    public static void main(String[] args) {
        // MySQL 연결 정보 설정
        String url = "jdbc:mysql://localhost:3306/cs14";
        String user = "nino";
        String password = "1234";
        // 데이터 삽입을 위한 SQL 쿼리
        String sql = "INSERT INTO user_log (nickname, money, last_visit) VALUES (?, ?, ?)";
        // 랜덤 데이터 생성을 위한 객체 생성
        Random random = new Random();
        Calendar calendar = Calendar.getInstance();
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < 100; i++) {
                // 이름 생성
                String name = "name" + (i + 1);
                // 돈 생성
                int money = random.nextInt(1000);
                // 날짜 생성
                calendar.add(Calendar.DAY_OF_YEAR, -random.nextInt(365));
                Timestamp date = new Timestamp(calendar.getTimeInMillis());
                // 데이터 삽입
                pstmt.setString(1, name);
                pstmt.setInt(2, money);
                pstmt.setTimestamp(3, date);
                pstmt.executeUpdate();
            }
            System.out.println("데이터 삽입 완료");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
