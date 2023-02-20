package CS12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.security.cert.X509Certificate;

import javax.net.ssl.*;

public class Main {
    private static URL url;
    private static HttpsURLConnection httpsConn;
    private static long start,end;
    private static double watingTime;
    private static double downloadTime;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("> ");
        String urlString = "https://" + br.readLine();
        String line = null;
        InputStream in = null;
        BufferedReader reader = null;
        httpsConn = null;

        try {
            // Get HTTPS URL connection

            url = new URL(urlString);
            httpsConn = (HttpsURLConnection) url.openConnection();

            // Set Hostname verification
            httpsConn.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    // Ignore host name verification. It always returns true.
                    return true;
                }
            });

            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }};

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Input setting
            httpsConn.setDoInput(true);
            // Output setting
            //httpsConn.setDoOutput(true);
            // Caches setting
            //httpsConn.setUseCaches(false);
            // Read Timeout Setting
            httpsConn.setReadTimeout(1000);
            // Connection Timeout setting
            httpsConn.setConnectTimeout(1000);
            // Method Setting(GET/POST)
            httpsConn.setRequestMethod("GET");
            // Header Setting
            httpsConn.setRequestProperty("HeaderKey", "HeaderValue");

            int responseCode = httpsConn.getResponseCode();
//            System.out.println("응답코드 : " + responseCode);
//            System.out.println("응답메세지 : " + httpsConn.getResponseMessage());

            // SSL setting
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, null, null); // No validation for now
            httpsConn.setSSLSocketFactory(context.getSocketFactory());

            // Connect to host
            httpsConn.connect();
            httpsConn.setInstanceFollowRedirects(true);

            // Print response from host
            if (responseCode == HttpsURLConnection.HTTP_OK) { // 정상 호출 200
                in = httpsConn.getInputStream();
            } else { // 에러 발생
                in = httpsConn.getErrorStream();
            }

            start = System.currentTimeMillis();
            reader = new BufferedReader(new InputStreamReader(in));
            int rank = 0;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                //System.out.printf("%s\n", line);
                sb.append(line);
            }
            end = System.currentTimeMillis();
            downloadTime = end-start;
            setChunkedString(line);
            reader.close();

        } catch (UnknownHostException e) {
            System.out.println("UnknownHostException : " + e);
        } catch (MalformedURLException e) {
            System.out.println(urlString + " is not a URL I understand");
        } catch (IOException e) {
            System.out.println("IOException :" + e);
        } catch (Exception e) {
            System.out.println("error : " + e);
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (httpsConn != null) {
                httpsConn.disconnect();
            }
        }
    }

    private static void setChunkedString(String line) {
        String name = url.toString().substring(url.toString().lastIndexOf("/") + 1);
        String domain = url.getHost();
        String scheme = url.getProtocol();
        String path = url.getPath().contains("") ? "/" : "";
        String type = httpsConn.getContentType();
        double capacity = httpsConn.getContentLength();
        //double watingTime = httpsConn.getReadTimeout();
        boolean cache = httpsConn.getUseCaches();

        System.out.println();
        System.out.println(">> " + name);
        System.out.println("도메인 " + domain);
        System.out.println("스킴 " + scheme);
        System.out.println("경로 " + path);
        System.out.println("종류 " + type);
        System.out.println("용량 " + capacity +"KB");
        System.out.println("대기 시간 " + watingTime+"ms");
        System.out.println("다운로드 시간 " + downloadTime+"ms");
        if(cache){
            System.out.println(">> 캐시됨");
        }
    }
}
