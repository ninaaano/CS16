package CS13;

public class HttpRequest {
    private final String hostName;
    private final int port;
    private final String ip;
    private final String path;

    public HttpRequest(String hostName, int port, String ip, String path) {
        this.hostName = hostName;
        this.port = port;
        this.ip = ip;
        this.path = path;
    }

    public String getHostName() {
        return hostName;
    }

    public int getPort() {
        return port;
    }

    public String getIp() {
        return ip;
    }

    public String getPath() {
        return path;
    }

    /**
     * naver.com/home 이면 path가 "/home"
     * naver.com 이면 path가 "/"
     */
    private static String findPath(String url){
        String path = "/";
        if(url.contains("/")){
            path = url.substring(url.indexOf("/"));
        }
        return path;
    }
}
