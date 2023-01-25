package CS02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class VideoEditing {
    public String makeTitle() throws IOException {
        System.out.println("영상 제목을 입력해주세요");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String titleName = br.readLine();
        try{
            return isCheckSize(titleName);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return titleName;
    }

    private String isCheckSize(String title){
        if(title.length() > 8) {
            throw new IllegalArgumentException("제목의 길이는 8자 이내로 입력해주세요");
        }
        return title;
    }

    public String makeId() {
        int start = 97; // 'a'
        int end = 122; // 'z'
        int idLen = 8;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(idLen);
        for (int i = 0; i < idLen; i++) {
            int randomLimitedInt = start + (int)
                    (random.nextFloat() * (end - start + 1));
            buffer.append((char) randomLimitedInt);
        }
        String id = buffer.toString();
        return id;
    }
}
