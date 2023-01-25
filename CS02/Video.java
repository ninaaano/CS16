package CS02;

class Video {
    String id; // 고유 id
    String title; // 제목
    int playtime; // 재생시간
    Video nextVideo;

    public Video(String id, String title) {
        this.id = id;
        this.title = title;
        this.playtime = (int) (Math.random() * 15 + 1);
        this.nextVideo = null;
    }

    public Video getNextVideo() {
        return nextVideo;
    }

    public void setNextVideo(Video nextVideo) {
        this.nextVideo = nextVideo;
    }

    @Override
    public String toString() {
        return String.format("%s(%8s):%d초", title, id, playtime);
    }
}
