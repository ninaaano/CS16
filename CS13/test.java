package CS13;

import java.io.*;
import java.net.Socket;
import java.net.URL;

public class test {
    public static void main(String[] args) throws IOException {
        // naver에 포트 8000번으로 연결하려는 클라이언트 소켓 생성
        Socket socket = new Socket("naver.com",80);
        // 서버에 데이터를 보내기 위해 소켓에서 outputStream 객체 가져오기
        OutputStream output = socket.getOutputStream();

        String message = "message ninaaano";
        // 문자열 -> byte
        byte[] data = message.getBytes();
        // 배열 보내기
        output.write(data);

        // true 인수는 메소드 호출 후에 데이터 자동 비우기 설정
        PrintWriter writer = new PrintWriter(output,true);
        // 데이터를 텍스트 형식으로 보내기
        writer.println("writer ninaaano");

        // 서버에서 데이터 읽기
        InputStream input = socket.getInputStream(); // 객체 가져오기

        // read() 메소드 사용해서 데이터 읽기
        input.read(data);


//        //InputStreamReader
//        InputStreamReader reader = new InputStreamReader(input);
//        int character = reader.read();
//
//
//        //BufferedReader
//        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
//        String line = reader.readLine();

        // 연결 종료
        socket.close();

    }
}
