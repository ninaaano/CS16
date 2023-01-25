package CS02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * 전체 메소드 실행하기
 * 사용자의 입력을 받는 클래스 구현
 * 출력하는 클래스 구현
 */
public class Application {

    private VideoList list = new VideoList();

    public static void main(String[] args) throws IOException {
        //VideoData data = new VideoData();
        VideoEditing editor = new VideoEditing();
        Video[] video = new Video[13];

        for (int i = 0; i < 13; i++) {
            video[i] = new Video(editor.makeId(), editor.makeTitle());
        }

        for(int i=0; i<13; i++){
            System.out.println(video[i]);
        }

        Application app = new Application();
        app.inputCommand();
    }

    // 사용자 입력받기
    public void inputCommand() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\n> ");
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String command = st.nextToken(); // 명령어
        String id = st.nextToken(); // 입력받은 id

        // 사용자의 입력 종료를 알리는 exit
        // exit 뒤에 공백 + 문자 안넣으면 에러난다. 처리하기
        while (!command.contains("exit")) {
            if (command.equals("add")) {
                list.addVideo(command);
            } else if (command.equals("insert")) {
                list.insertVideo(id, Integer.parseInt(st.nextToken()));
            } else if (command.equals("delete")) {
                list.deleteVideo(id);
            } else if (command.equals("render"))
                list.render();
        }
    }

    // 입력 예외사항 처리하기
    public void inputValidator(String input){

    }
}



