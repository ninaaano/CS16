package CS13;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
       // if (args.length < 1) return;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String domain = "http://" + br.readLine();

        URL url;

        try {
            url = new URL(domain);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            return;
        }

        /**
         * http -> 80
         * https -> 443
         */

        String hostName = url.getHost();
        int port = 80;
        String ip = InetAddress.getByName(hostName).getHostAddress();


        try (Socket socket = new Socket(hostName, port)) {

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            // url.getPath()삭제. 아무것도 없으면 출력이 안되서 "/"로 변경
            writer.println("HEAD " + "/" + " HTTP/1.1");
            writer.println("Host: " + hostName);
//            writer.println("User-Agent: Simple Http Client");
//            writer.println("Accept: text/html");
//            writer.println("Accept-Language: en-US");
//            writer.println("Connection: close");
            writer.println();


            // 응답 읽기
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            System.out.println("ip : " + ip);

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (UnknownHostException ex) {

            System.out.println("Server not found: " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}

