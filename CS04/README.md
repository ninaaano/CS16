# CS04

## 📝 학습 키워드

- 패딩

적은 수의 컴파일러는 구조체의 필드를 메모리에 위치시킬 때, 중간 빈 공간 없이 쭉 이어서 할당한다.  
하지만 대부분의 컴파일러는 성능 향상을 위해 CPU가 접근하기 쉬운 위치에 필드를 배치하는데 이를 **구조체 패딩**이라고 한다. 그리고 중간 빈 공간에 들어간 것을 **패딩 비트**라고 한다.
참고로 os 32bit 환경에서는 4byte packing 방식이 빠르고, os 64bit 환경에서는 8byte packing 방식이 빠르다고 한다.  
주로 네크워크를 통한 구조체 전송 시 구조체 패딩이 중요하다고 한다. (구조체를 그대로 직렬화 한 채 전송할 때)  
서로 다른 컴퓨터 시스템에서 메모리를 읽는 방식이 다르기 때문에, packing시 체워진 패딩 비트때문에 각 컴퓨터에서 구조체를 다르게 읽을 수 있기 때문이다.


- 포인터  

포인터(pointer)란 메모리의 주소값을 저장하는 변수이며, 포인터 변수라고도 부른다.  

![http://www.tcpschool.com/lectures/img_c_address.png](http://www.tcpschool.com/lectures/img_c_address.png)


- 가비지 콜랙션  

줄여서 GC라고 부른다.  
가비지 컬렉션은 자바의 메모리 관리 방법 중 하나로 JVM의 Heap 영역에서 동적으로 할당했던 메모리 영역 중 필요없게 된 메모리 영역을 주기적으로 삭제하는 프로세스를 말한다.  
C나 C++에서는 이러한 가비지 컬렉션이 없어서 프로그래머가 수동으로 메모리 할당과 해제를 일일이 해줘야하지만 Java는 JVM에 탑재되어 있는 가비지 컬렉터가 메모리 관리를 대행해주기 때문에  
개발자 입장에서 메모리 관리, 메모리 누수 문제에 대해 완벽하게 관리하지 않아도 된다는 장점이 있다.  
단점으로는 개발자가 메모리가 언제 해제되는지 정확하게 알 수 없고, GC가 동작하는 동안에 다른 동작을 멈추기 때문에 오버헤드가 발생한다.

  ![https://blog.kakaocdn.net/dn/bW5c5r/btrvAb4nrdH/lYHuQZya8ECvEndRkQchjk/img.png](https://blog.kakaocdn.net/dn/bW5c5r/btrvAb4nrdH/lYHuQZya8ECvEndRkQchjk/img.png)

객체들은 실질적으로 Heap 영역에 생성되고 Method Area이나 Stack Area등 Root Area에서는 Heap Area에 생성된 객체의 주소만 참조하는 형식으로 구성된다.  
하지만 이렇게 생성된 Heap Area의 객체들이 메서드가 끝나는 등의 특정 이벤트들로 인하여 Heap Area 객체의 메모리 주소를 가지고 있는 참조 변수가 삭제되는 현상이 발생하면 
위의 그림에서의 빨간색 객체와 같이 Heap영역에서 어디서든 참조하고 있지 않은 객체들이 발생하게 된다. 
이러한 객체들을 Unreachable하다고 하며 주기적으로 가비지 컬렉터가 제거해준다.

  > Reachable : 객체가 참조되고 있는 상태
  
  > Unreachable : 객체가 참조되고 있지 않은 상태 (GC의 대상이 됨)
  
  [[Java] 자바 JVM 내부 구조와 메모리 구조에 대하여](https://coding-factory.tistory.com/828)

- 힙  
  - 데이터를 조회하는 과정이 더 복잡하기 때문에 스택보다 느리지만 스택보다 더 많은 데이터를 저장할 수 있다
    힙은 응용 프로그램의 스레드간 공유된다
  - 힙에 저장되는 데이터는 전역 변수, 개체, 문자열, 맵 및 기타 복잡한 데이터 구조와 같은 참조 유형이다.
  - 힙에 저장할 수 있는 값의 크기에는 제한이 없다  
  
메모리의 힙(heap) 영역은 사용자가 직접 관리할 수 있는 '그리고 해야만 하는' 메모리 영역이다.  
힙 영역은 사용자에 의해 메모리 공간이 동적으로 할당되고 해제된다. 힙 영역은 메모리의 낮은 주소에서 높은 주소의 방향으로 할당된다.
JVM에서 힙 메모리는 자바 프로그램이 실행되면서 동적으로 생성된 객체(new 연산자로 생성된 객체 또는 인스턴스)가 저장되는 공간이다.  
이곳에 생성된 객체들은 다른 객체의 필드 또는 스택에 존재하는 다른 메소드에 의해 참조될 수 있다.  
참조되는 변수가 사라진다면 이 객체는 필요없는 것으로 간주하고 GC에 의해 할당이 해제된다.  


- 호출 스택(call stack)  

call stack이란 메서드 수행에 필요한 메모리가 제공되는 공간. 스택 영역은 함수의 호출과 함께 할당되며, 함수의 호출이 완료되면 소멸한다.  
스택 영역에 저장되는 함수의 호출 정보를 스택 프레임이라고 한다. 현재 실행중인 서브 루틴의 실행이 끝났을 때, 제어를 반환할 지점을 보관하기 위해 사용한다.


- 스택  
  - 다중 스레드 어플리케이션은 스레드당 스택을 가질 수 있다
  - 스택에 저장되는 일반적인 데이터는 지역변수(값, primitive, primitive constants), 포인터, 함수 프레임이다.
  - 스택 크기가 힙에 비해 제한되어 있어서 스택오버플로우가 발생한다
  - 대부분의 언어에서 스택에 저장할 수 있는 값의 크기는 제한적이다  

메모리의 스택 영역은 함수의 호출과 관계되는 지역 변수와 매개변수가 저장되는 영역이다.  스택 영역은 push로 데이터를 저장하고, pop으로 데이터를 인출한다.  
이러한 스택은 후입선출(LIFO : Last-In First-Out) 방식에 따라 동작하므로 가장 늦게 저장된 데이터가 가장 먼저 인출된다.  
스택 영역은 메모리의 높은 주소에서 낮은 주소의 방향으로 할당된다  


![https://res.cloudinary.com/practicaldev/image/fetch/s--lInxMFo1--/c_limit%2Cf_auto%2Cfl_progressive%2Cq_66%2Cw_880/https://i.imgur.com/7KpvEn1.gif](https://res.cloudinary.com/practicaldev/image/fetch/s--lInxMFo1--/c_limit%2Cf_auto%2Cfl_progressive%2Cq_66%2Cw_880/https://i.imgur.com/7KpvEn1.gif)


- malloc  
C언어에서 배열을 동적으로 할당해야할 경우 malloc함수를 사용해야 한다. malloc() 함수는 인수로 할당받고자 하는 메모리의 크기를 바이트 단위로 전달 받는다.  
이 함수는 전달받은 메모리 크기에 맞고, 아직 할당되지 않은 적당한 블록을 찾아 첫번재 바이트를 가리키는 주소값을 반환한다.  
다른 프로그래밍 언어와 달리 C언어는 동적으로 size를 결정해야 할 때는 malloc 함수를 사용해야만 구현이 가능하다.  
malloc 함수를 사용한 뒤 free()를 사용해서 꼭 메모리를 해제시켜줘야한다.  
free() 함수는 힙 영역에 할당받은 메모리 공간을 다시 운영체제로 반환해주는 함수이다.


- JVM  
  ![https://velog.velcdn.com/images%2Fshin_stealer%2Fpost%2F8e500340-258e-4150-85c0-455921663229%2Fimage.png](https://velog.velcdn.com/images%2Fshin_stealer%2Fpost%2F8e500340-258e-4150-85c0-455921663229%2Fimage.png)

  - Source Code (.java) 파일을 Java Compiler를 통해서 Byte Code(.Class)파일로 변환한다. (컴퓨터가 이해할 수 있는 코드로 변환)
  - Byte Code로 변환된 파일을 JVM의 Class Loader 로 보낸다.
  - Class Loader는 말 그대로 Class 파일을 불러와서 메모리에 저장하는 역할을 한다.
  - Execution Engine 은 Class Loader에 저장된 Byte Code를 명령어 단위로 분류하여 하나씩 실행하게 하는 엔진이다.
  - Garbage Collector 는 사용하지 않거나 필요없는 객체들을 메모리에서 소멸시키는 역할을 한다.
  - Runtime Data Area (Memory Area) 는 JVM이 프로그램을 수행하기위해 운영체제로부터 할당받은 메모리 공간이다.

  ![https://velog.velcdn.com/images%2Fshin_stealer%2Fpost%2F024b42b8-85fa-4393-9668-6ef15227a0d0%2Fimage.png](https://velog.velcdn.com/images%2Fshin_stealer%2Fpost%2F024b42b8-85fa-4393-9668-6ef15227a0d0%2Fimage.png)


  1) Method Area
  - JVM이 실행되면서 생기는 공간이다.
  - Class 정보, 전역변수 정보, Static 변수 정보가 저장되는 공간이다.
  - Runtime Constant Pool 에는 말 그대로 '상수' 정보가 저장되는 공간이다.
  - 모든 스레드에서 정보가 공유된다.  
  
  2) Heap
  - new 연산자로 생성된 객체, Array와 같은 동적으로 생성된 데이터가 저장되는 공간
  - Heap에 저장된 데이터는 Garbage Collector 가 처리하지 않는한 소멸되지 않는다.
  - Reference Type 의 데이터가 저장되는 공간
  - 모든 스레드에서 정보가 공유된다.

  3) Stack
  - 지역변수, 메소드의 매개변수와 같이 잠시 사용되고 필요가 없어지는 데이터가 저장되는 공간
  - Last In First Out, 나중에 들어온 데이터가 먼저 나간다
  - 만약, 지역변수 이지만 Reference Type일 경우에는 Heap 에 저장된 데이터의 주소값을 Stack 에 저장해서 사용하게 된다.
  - 스레드마다 하나씩 존재한다.

  4) PC Register
  - 스레드가 생성되면서 생기는 공간
  - 스레드가 어느 명령어를 처리하고 있는지 그 주소를 등록한다.
  - JVM이 실행하고 있는 현재 위치를 저장하는 역할
  
  5) Native Method Stack

  - Java 가 아닌 다른 언어 (C, C++) 로 구성된 메소드를 실행이 필요할 때 사용되는 공간  
[🚀 Visualizing memory management in JVM(Java, Kotlin, Scala, Groovy, Clojure)](https://dev.to/deepu105/visualizing-memory-management-in-jvm-java-kotlin-scala-groovy-clojure-19le)

---
  
### 📖 학습목표

- 프로세스 메모리 관리 모델
- 프로세스 메모리 구조
- 프로세스 동작 방식
- 스택Stack 영역, 힙Heap 영역, 텍스트Text 영역, 글로벌변수GVAR 영역의 역할과 동작 방식

현대 운영체제들은 프로세스를 실행할 때마다 메모리 모델을 생성해서 관리한다.  
메모리 관리 모델에 대한 지식을 학습하고 동작방식을 이해하면 모든 프로그래밍 언어 동작과 처리 흐름을 이해하는데 도움이 된다

---

## 프로세스 메모리 구조

프로세스란 어떤 프로그램이 실행되기 위해 메모리에 올라간 상태이다. 각 프로세스는 독자적인 주소 공간을 가지고 있다.
물리적인 메모리가 아니라 운영체제가 가상 메모리 수준에서 프로세스별로 메모리 관리하는 방식. 운영체제가 프로세스를 생성할 때마다 관리하는 메모리 구조는 역할별로 섹션이 나눠진다

![https://lucas-image.codesquad.kr/16403278811501%2AfwkyPI8Gmzd0Q_XAGM5_eA.png](https://lucas-image.codesquad.kr/16403278811501%2AfwkyPI8Gmzd0Q_XAGM5_eA.png)

1. TEXT 섹션
- 프로그램에 있는 함수 코드, 제어문, 상수 등을 포함한다
- 일반적으로 한번 로딩하면 바뀌지 않는다.
  - JVM에서는 TEXT 영역을 사용하지 않는다.
  - node나 브라우저에서는 TEXT 영역 대신 코드 영역이 별도로 존재한다
2. GVAR/BSS 섹션
- 범위(scope)가 정해지지 않은 전역(Global 또는 Static) 변수를 포함
- GVAR는 초기값이 0이 아닌 특정한 값을 지정한 경우 사용
3. HEAP 섹션
- 동적으로 할당되는 메모리 공간으로 C에선 malloc(), Java에선 new 명령으로 할당
- 힙 영역에 할당한 메모리 공간에 대한 주소를 스택에 있는 포인터 변수로 참조하는 경우가 많음
4. STACK 섹션
- 함수를 호출할 때마다 지역 변수, 매개변수와 리턴값 등이 쌓인다.

![https://lucas-image.codesquad.kr/1625800638853Screen%20Shot%202021-07-09%20at%2012.14.55%20PM.png](https://lucas-image.codesquad.kr/1625800638853Screen%20Shot%202021-07-09%20at%2012.14.55%20PM.png)

Code, Data, BSS 영역은 컴파일 시 크기가 결정되고, Heap, Stack 영역은 런타임시 크기가 결정된다.
Stack의 지역변수는 사용하고 소멸하므로 데이터 용량이 불확실하다. 
그렇기 때문에 밑에서 부터 체워올리고 Heap은 위에서부터 채워나간다. 
이렇게 서로 주소값을 채워나가다가 Heap에서 Stack방향으로 영역을 침범하는 경우 HEAP overflow라고 하며 반대로 Stack에서 Heap 방향으로 영역을 침범한다면 STACK overflow라고 한다. 
(힙 오버플로우는 거의 일어나지 않는다)

### 자바/코틀린 JVM에서 힙 구조

JVM의 객체 값들은 Heap에 생성되고 객체로 접근 가능한 구조이며, 일부 원시 타임 primitive type들은 Stack에 생성되기도 한다

![https://lucas-image.codesquad.kr/1670392838100JVM%20Heap.png](https://lucas-image.codesquad.kr/1670392838100JVM%20Heap.png)

---
위의 내용을 좀 더 자세하게 다루자면,

### 프로세스의 주소 공간

![https://velog.velcdn.com/images%2Fseyoung755%2Fpost%2F0fa7ccca-2546-43af-811d-76c6b1047554%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202022-01-20%20%EC%98%A4%EC%A0%84%2010.00.58.png](https://velog.velcdn.com/images%2Fseyoung755%2Fpost%2F0fa7ccca-2546-43af-811d-76c6b1047554%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202022-01-20%20%EC%98%A4%EC%A0%84%2010.00.58.png)

### Code 영역

코드 영역은 코드 자체를 구성하는 메모리 영역으로 Hex 파일이나 Bin 파일 메모리이다.  실제 소스 코드를 CPU가 실행할 수 있는 형태의 기계어 형태로 변환하여 저장하는 공간. 이 영역은 컴파일 시에 결정되고 수정할 수 없도록 Read-Only의 형태를 띤다. 실제 CPU는 프로그램 카운터가 가리키는 코드 영역의 주소를 찾아가서 명령을 수행한다.

- 시스템 콜이나 인터럽트 처리 루틴 코드

> 인터럽트 : 프로그램 실행 중 예기치 않은 상황이나 필요에 의해 실행중인 프로세스를 중단하고 OS에게 CPU 제어권을 넘겨 처리해야 하는 작업들

> 시스템 콜 : 일반 프로세스가 OS의 도움이 필요한 특권 명령(ex. I/O 요청)을 요청할 때 일으키는 인터럽트

- CPU, 메모리 등의 자원 관리를 위한 코드
- 편리한 인터페이스 제공을 위한 코드

### Data 영역

전역 변수나 Static 변수, 배열, 구조체 등 프로그램이 사용되는 데이터가 저장되는 공간. 코드에 전역변수를 사용하면, 컴파일 시 이 데이터 영역에 있는 주소를 가리키도록 설정된다. 전역 변수 값은 변경되는 경우가 있기 때문에 Read-Write의 형태로 작성된다. 이 때 초기화 된 데이터는 Data 영역에 저장되고 초기화되지 않은 데이터는 BSS(Block Stated Symbol) 영역에 저장된다. 함수 내부에 선언된 Static 변수는 프로그램이 실행될 때 공간만 할당되고 그 함수가 실행될 때 초기화된다.

> **: Data 영역과 BSS 영역을 구분하는 이유? 🤔**
>
> 프로그램을 짠 뒤 컴파일하고 링크하고 이미지로 만들어 시스템의 ROM에 저장했다고 가정했을때 초기화된 데이터는 초기값을 저장해야 하니 Data 영역에 저장되어 ROM에 저장된다. 하지만 초기화하지 않은 데이터까지 ROM에 저장한다면 큰 사이즈의 ROM이 필요한데 비용이 많이 들어 RAM에 저장하기 위해 Data 영역과 BSS 영역으로 나눈 것이다.

![https://velog.velcdn.com/images%2Fseyoung755%2Fpost%2F094a8a5e-586f-4cdb-90c5-7bb1f9800606%2Fimage.png](https://velog.velcdn.com/images%2Fseyoung755%2Fpost%2F094a8a5e-586f-4cdb-90c5-7bb1f9800606%2Fimage.png)

- PCB(Process Control Block) : 프로세스의 관리를 위한 특별한 자료구조로, 현재 프로세스의 동작 상태/ 어디를 실행중인지 알 수 있는 Program counter 등이 포함되어 있다. 각 프로세스마다 운영체제가 독자적인 PCB를 관리한다.
- CPU, 메모리 등 하드웨어 자원의 관리를 위한 자료구조

### Heap 영역

사용자가 생성한 객체들이 저장되는 공간. 프로그래머가 필요할 때 사용하는 공간으로써, 런타임에 결정되는 영역이다. 메모리 주소 값에 의해서만 참조되고 사용하는 영역이다. 자바에서는 객체가 이 Heap에 생성이 되면 가비지 컬렉터가 힙 영역에서 쓸모없는 객체를 반환한다.

### Stack 영역

사용자가 작성한 코드 중 함수 호출이 일어날 때 사용되는 리턴 주소, 다음 명령어의 코드 영역 주소, 매개 변수, 지역 변수 등이 저장되는 공간이다. 함수가 호출됨에 따라 call stack이 쌓여 나가고, return 됨에 따라 정리된다. 스택 영역은 컴파일 시 공간이 할당되기 때문에 무한적으로 콜 스택을 쌓을 수 없고, 재귀 함수를 무한히 호출하거나 하면 스택오버플로우가 발생한다. Stack 사이즈는 각 프로세스마다 할당되지만 프로세스가 메모리에 로드될 때 Stack 사이즈가 고정되어 있어 런타임 시 Stack 사이즈를 바꿀 수 없다. 명령 실행 시 자동으로 증가/감소 하기 때문에 보통 메모리의 마지막 번지를 저장한다

- 각 프로세스의 커널 스택을 저장
  - 커널 모드가 끝나고 원래 프로세스로 돌아가기 위한 정보의 일부를 저장한다.
  - 각 프로세스가 커널 모드에 진입하여 함수를 호출하면 커널 영역의 스택에서 작업을 수행한다

---

### 기능요구사항

- 프로세스 메모리 구조를 시뮬레이션하는 프로그램 작성
    - 프로세스 메모리 구조를 다루는 프로그램이라 메모리 주소를 값으로 다루는 **포인터** 변수를 직접 구현
    - 처리하는 모든 포인터 메모리 사이즈는 4바이트 기준 - 언어에서 4바이트를 기준으로 동작하는 타입 활용(무엇인지 생각하고 추가로 정리할 것)
- 프로그래밍 요구사항에 있는 함수들 구현
- 각 함수 동작을 확인하기 위해 특정한 시나리오 대로 동작하는 프로그램을 별도 파일로 작성 (테스트 코드??)
    - 시나리오 흐름은 스스로 결정
    - 함수 내부에서 출력하지 말고, 함수에서 return 한 값을 호출하는 프로그램에서 출력

### 프로그래밍 요구사항

Memory 객체를 구현한다

- 매개변수, 리턴에 필요한 타입 스스로 판단해서 선언
- 리턴 명세가 있는 경우 반드시 리턴
- 스택 동작을 담당하는 Stack 타입도 별도로 선언, 내부에는 스택포인터 변수를 두고 몇 번째까지 쌓였는지 확인

#### **1. `init(stackSize, heapSize)`**

- 스택영역 크기와 힙영역 크기를 지정하면 프로세스 공간을 위한 기본 주소(base address)를 리턴한다.
    - 이번 미션에서는 일반적인 프로세스 메모리 모델(배경 지식 참조)중에서 스택과 힙 영역을 위주로 구현한다. 다른 영역은 무시한다.
    - 아래 함수들에서 사용하는 포인터 주소들은 이 함수에서 리턴하는 기본 주소에서 얼마나 떨어진지 상대 주소로 표현한다.

#### **2. `setSize(type, length)`**

- type 별로 고유한 사이즈를 가지도록 등록한다.
    - 예시 : **`setSize("int", 8)`** //int 타입을 8바이트 길이로 지정한다.
    - 메모리 시뮬레이션을 위해 스스로 필요한 타입을 지정해야 한다.
    - 이미 등록한 타입은 다시 사이즈를 바꿀 수 없다.
    - 사이즈는 1,2,4,8,16,32 중에 하나만 가능하다.

#### **3. `malloc(type, count)`**

- 이미 등록된 type에 대해 count만큼 반복해서 메모리를 할당하고 시작 위치 고유한 주소를 스택 영역에 추가하고, 스택 주소값을 리턴한다.
    - 만약 해당 타입 크기가 8바이트 보다 작은 경우는 패딩을 붙여서 8바이트로 만든 후, count만큼 반복한다.
    - 예를 들어 boolean 타입을 1로 등록했고 malloc("boolean", 4)를 호출한다면 패딩을 붙여서 8바이트 단위로 4개 = 총 32바이트를 할당한다.

#### **4. `free(pointer)`**

- malloc 할 때 할당했던 스택 주소값을 입력으로 받는다. 스택 주소값에 있는 힙영역 고유 주소를 찾아서 해제하고 반환한다.

#### **5. `call(name, paramCount)`**

- 마지막 스택 위치를 알려주는 **`스택 포인터`**에 포인터 변수를 paramCount만큼 반복해서 생성하고 **`스택 포인터`**를 증가시킨다.
    - paramCount는 0부터 10이하 값이다.
    - name은 최대 8자까지만 가능하다.
    - call 실행할 때마다 name값을 스택에 기록하고 아래 callstack()에서 활용한다.

#### **6. `returnFrom(name)`**

- 증가했던 스택 공간을 비우고 이전 호출 위치로 이동한다.
    - 이 때 name값은 call() 호출로 가장 최근에 호출한 name과 동일해야 한다.
    - 가장 최근보다 이전에 호출한 name이면 에러값을 throw 한다.
    - 만약 call() 호출 이후에 malloc()으로 생성한 stack 영역에 포인터 값이 있다면 같이 비운다.
    - 단, malloc()으로 생성된 힙 영역의 메모리는 free()할 수 없고 스택에 있던 포인터 변수만 삭제한다.
    - call()을 호출한 경우가 없을 경우 아무런 동작을 하지 않는다.

#### **7. `usage()`**

- 스택 영역 전체크기, 사용중인 용량, 남은 용량, 힙 영역 전체크기, 사용중인 용량, 남은 용량을 순서대로 배열로 리턴한다.

#### **8. `callstack()`**

- 현재 스택에 쌓여있는 호출 스택을 문자열로 리턴한다.
- 출력하는 스택 포인터는 **`base address + offset address`** 형태로 표현한다
    - 예를 들어 call("foo", 0), call("bar", 1), call("dap", 2) 순서로 호출한 경우는 **`foo() 0xAF00 -> bar() 0xB100 -> dap() 0xBF00`** 형태로 함수 이름과 스택의 주소를 리턴한다.
    - 그 후에 returnFrom("dap") 호출한 경우는 **`foo() 0xAF00 -> bar() 0xB100`** 형태로 dap을 리턴하고 남은 함수 이름과 스택의 주소를 리턴한다.

#### **9. `heapdump()`**

- 힙영역에서 사용중인 상태를 문자열 배열로 표현해서 리턴한다.
    - 힙 영역에 정보는 타입과 크기, 해당 주소를 참조하는 스택 포인터 변수 정보도 포함한다.
    - 모든 포인터 주소값은 **`base address + offset address`** 형태로 표현한다

#### **10. `garbageCollect()`**

- 힙영역에 할당된 타입들 중에서 스택에 포인터 변수가 없는 경우를 찾아서 해제하는 동작을 한다.

#### **11. `reset()`**

- 모든 stack과 heap 공간을 비우고 init했을 때와 동일하게 초기상태로 만든다.

### 예상결과 및 동작예시

```
base = memory.init(1024, 1024)
memory.setSize("short", 4)
memory.setSize("int", 8)
memory.setSize("string", 16)
arrayPointer = memory.malloc("int", 4)
shortPointer = memory.malloc("short", 5)
print(heapdump())
call("foo", 2)
string1 = memory.malloc("crong", 1)
print(callstack())
call("bar", 1)
string2 = memory.malloc("jk", 2)
returnFrom("bar")
free(string1)
print(heapdump())
free(string2)
print(callstack())
garbageCollect()
print(heapdump())
reset()
print(heapdump())
```