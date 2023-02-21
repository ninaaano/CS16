package CS14;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


/**
 * 리스트에서 이름을 꺼내서
 * 문자+숫자로 재조합한 값 넘기기
 */
public class DataMaker {

    String nickname;

    public DataMaker(String nickname) {
        this.nickname = nickname;
    }

    public String makeNickName(String nickName){
        // 리스트에서 닉네임을 가져와서 문자+숫자 append 해주기
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String resultNum = "";
        for(int i=0; i<4;i++){
            int num = random.nextInt(9);
            String ranNum = Integer.toString(num);
            resultNum += ranNum;
        }
        String randomStr = String.valueOf((char)(int)(random.nextInt(26))+97);
        sb.append(nickName + randomStr + resultNum);

        return sb.toString();
    }
}
