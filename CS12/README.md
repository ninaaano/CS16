대기시간 System.currentTimeMillis 사용
InputStream 으로 읽어서
OutputStream 으로 복사?

# CS12

### 캐시정책

### HTTPS

### HTTP

- HyperText Transfer Protocol
    - hypertext 통신 규약
- 거의 모든 형태의 데이터 전송 가능
- 클라이언트 - 서버 구조
- 무상태 프로토콜, 비연결성
- HTTP 메시지
- 단순함, 확장 가능

### WWW

### URI

• Uniform Resource Identifier : 리소스 식별자

### DOM

### html

### 학습 목표

- 웹 브라우저 개발자 도구. 네트워크 탭의 동작 따라서 구현. HTTP 요청과 응답 흐름 살펴보기
- 로컬 메모리 캐싱 방식

### 기능요구사항

- 개발자 도구 > 네트워크 탭 참고. HTTP 요청을 보내고 받는 과정 분석

### 프로그래밍 요구사항

### [요청]

- 웹 브라우저처럼 URL을 입력하면 해당 주소로 요청을 보낸다
- HTTP 또는 HTTPS 처리를 위한 모듈 또는 라이브러리 이용 → 자바 HttpURLConnection 또는 HttpRequest 클래스를 활용
- 요청, 응답이 중점. 서버와 연결을 하나만 사용?
- HTTP 또는 DOM Parser 모듈 활용. 응답에 포함된 HTML 분석

---

### HTTP 와 InputStream

입력은 그동안 BufferedReader로 받곤했는데

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
```

로 읽어들였다. InputStream 과 BufferedReader는 차이가 있는데

InputStream은 바이트 단위 입출력을 위한 최 상위 입출력 스트림 클래스이고

BufferedReader는 문자 단위 입출력을 위한 하위 스트림 클래스라는 것이다.

문자 단위 입출력을 위한 최상위 입출력 스트림 클래스는 Reader이다.

바이트 단위 입출력 스트림 : 그림, 멀티미디어, 문자 등 모든 종류의 데이터를 주고 받을 수 있다

문자 단위 입출력 스트림 : 오로지 문자만 주고받을 수 있게 특화되었다.

InputStream 클래스에는 기본적으로 가져야 할 메소드들이 정의되어 있다.

| 메서드 | 설명 |
| --- | --- |
| read() | 입력 스트림으로부터 1바이트를 읽고 읽은 바이트를 리턴합니다. |
| read(byte[ ] b) | 입력 스트림으로부터 읽은 바이트들을 매개값으로 주어진 바이트 배열b에 저장하고 실제로 읽은 바이트 수를 리턴합니다. |
| read(byte[] b, int off, int len) | 입력 스트림으로부터 len개의 바이트만큼 읽고 매개값으로 주어진 바이트 배열 b[off]부터 len개까지 저장합니다. 그리고 실제로 읽은 바이트 수인 len개를 리턴합니다. 만약 len개를 모두 읽지 못하면 실제로 읽은 바이트 수를 리턴합니다. |
| close() | 사용한 시스템 자원을 반납하고 입력스트림을 닫습니다. |