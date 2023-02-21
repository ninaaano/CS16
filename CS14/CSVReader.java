package CS14;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {

    private static List<List<String>> reader;

    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        csvReader.readCSV();

        for (List<String> item : reader) {
            System.out.println(item.get(0));
            System.out.println(item.get(1));
            System.out.println(item.get(2));
        }
    }

    public List<DataMaker> readCSV() {
        File csv = new File("/Users/nino/CS16/CS14/user_logs.csv");
        BufferedReader br = null;
        String line = "";
        List<DataMaker> data = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) { // 파일에서 개행된 한 줄의 데이터를 읽어옴
                String[] arr = line.split(",");
                DataMaker dataMaker = new DataMaker(arr[0]);
                data.add(dataMaker);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null) {
                    br.close(); // 버퍼리더 닫기
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public void writeCSV() {
        File csv = new File("/Users/nino/CS16/CS14/user_logs.csv");
        BufferedWriter bw = null;
        try {
            // 기존 값에 이어쓰려면 true, 기존 갚을 덮어쓰려면 true 삭제
            bw = new BufferedWriter(new FileWriter(csv, true));

            for(int i=1; i<reader.size(); i++){
                List<String> data = reader.get(i);
                String aData = "";
                aData = data.get(0);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
