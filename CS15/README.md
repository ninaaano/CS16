# CS15

pk, 컬럼,객체는 메소드의 집합,DB는 뭘까? 필드의 집합이 테이블이 된다. 필요한 속성들을 묶어서 테이블로 만들어라
어려우면 테이블 하나만 만들어라.
드라이버랑 연결하는걸 저번시간에 했다?

### 데이터베이스
데이터의 집합, 저장소라고 부른다  
예를 들어 카카오톡 메세지, 인스타그램 게시글, 카드 사용내역 모두 데이터베이스에 기록된다

### MySQL
MySQL은 데이터 관리 및 쿼리를 위해 SQL(Structured Query Language)을 사용하는 널리 사용되는 오픈 소스 관계형 데이터베이스 관리 시스템(RDBMS)이다  
RDBMS의 데이터베이스는 테이블이라는 최소 단위로 구성되며, 이 테이블은 하나의 열(column)과 행(row)으로 이루어져 있다  
행은 인덱스 번호 1,2,3,4 나 아이디값 등을 가지고 있고 열은 이름, 연락처등 한 줄을 나타낸다  

### DB Connection
프로그램과 DB를 연결해주는 프로그램  
https://steady-coding.tistory.com/564

### mysql connector
mysql db와 자바 프로그램을 연결해준다  
https://bibi6666667.tistory.com/191

### mysql 아답터
어플리케이션이 mysql db와 통신할 수 있도록 하는 소프트웨어 구성요소 또는 라이브러리이다.  
MySQL 어댑터는 MySQL 데이터베이스와 프로그래밍 언어 간의 상호 작용을 용이하게 하는 소프트웨어 구성 요소로, 개발자가 코드에서 MySQL 데이터베이스로 작업하기가 더 쉬워진다
MySQL 어댑터는 일반적으로 프로그래머가 데이터베이스에서 데이터 생성, 읽기, 업데이트 및 삭제와 같은 데이터베이스 작업을 수행할 수 있도록 하는 일련의 API 및 기능을 제공합니다. 이러한 API 및 함수는 Python, PHP 또는 Java와 같은 프로그래밍 언어에서 호출하여 MySQL 데이터베이스와 상호 작용할 수 있다  
널리 사용되는 일부 MySQL 어댑터에는 MySQL Connector/Python, MySQL Connector/J(Java용) 및 MySQLi(PHP용)가 포함됩니다. 이러한 어댑터는 개발자가 MySQL 데이터베이스에 대한 연결을 설정하고 SQL 쿼리를 수행하며 데이터베이스 트랜잭션을 관리할 수 있는 일련의 기능을 제공한다  


### DDL? DCL?
- DDL(Data Definition Language)	
  - 데이터베이스나 테이블 등을 생성, 삭제하거나 그 구조를 변경하기 위한 명령어	
  - CREATE, ALTER, DROP
- DML(Data Manipulation Language)	
  - 데이터베이스에 저장된 데이터를 처리하거나 조회, 검색하기 위한 명령어	
  - INSERT, UPDATE, DELETE, SELECT 등
- DCL(Data Control Language)	
  - 데이터베이스에 저장된 데이터를 관리하기 위하여 데이터의 보안성 및 무결성 등을 제어하기 위한 명령어	
  - GRANT, REVOKE 등
  - 
----

- 데이터베이스: 테이블, 테이블과 관련된 SQL 구성 요소들을 담고 있는 저장소
- 쿼리: 데이터베이스로 정보를 요청하는 것.
- 테이블: 데이터를 열과 행으로 구조화하여 보관하고 있는 데이터베이스의 구성 요소
- 열(필드): 테이블에 저장된 하나의 데이터
- 행(레코드): 한 객체에 대한 속성들을 나타내는 열의 집합

---

과제에 대해 openai에게 물어보니 깔끔하게 정리를 해줬다  

![스크린샷 2023-02-23 오후 4.47.13.png](..%2F..%2F..%2F..%2Fvar%2Ffolders%2F4k%2F50jw2vv566z5wxd0z6rf1sgw0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_KfNnff%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-02-23%20%EC%98%A4%ED%9B%84%204.47.13.png)  

주어진 Table에서 데이터를 조회하는 쿼리를 작성해보겠습니다.
아래는 자바에서 MySQL 데이터베이스에 접속하여 주어진 Table에서 모든 사용자의 정보를 조회하는 쿼리입니다.  

```
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLQueryExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/database_name";
        String username = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM pc_users")) {

            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String startTime = rs.getString("start_time");
                String endTime = rs.getString("end_time");
                int seatNumber = rs.getInt("seat_number");

                System.out.println("User ID: " + userId);
                System.out.println("Start Time: " + startTime);
                System.out.println("End Time: " + endTime);
                System.out.println("Seat Number: " + seatNumber);
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
    }
}

```

위 코드에서는 jdbc:mysql://localhost:3306/database_name와 your_username, your_password를 자신이 사용하는 MySQL 데이터베이스의 정보로 변경해야 합니다.  
그리고 ResultSet 객체의 next() 메소드를 사용하여 조회된 데이터의 각 컬럼 값을 변수에 저장하고 출력합니다.  
이 코드를 실행하면, pc_users Table의 모든 데이터가 콘솔에 출력됩니다.  
해당 쿼리를 조건에 맞게 수정하여 사용하시면 됩니다.
  

ai가 나보다 나은 것 같다..



