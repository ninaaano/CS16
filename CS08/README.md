# 정수 분류기

### 학습 키워드

- 순수함수
    - 동일한 입력에 대해 항상 같은 값을 반환
    - 부작용(다른 요인에 따른 결과변경)이 없는 결과를 생성 → 함수에서 인자를 변경하거나 프로그램의 상태를 변경하지 않음

  위 조건을 만족하는 함수를 말한다. 멀티 쓰레드에서도 안전하고 병렬처리 및 계산도 가능하다. 순수함수 내부에서 전역 변수의 값을 사용하거나 변경하면서 발생하는 부작용이 없다. 순수 함수는 외부의 영향을 받거나 주지도 않으면서 항상 동일한 input을 넣었을 때 항상 같은 값을 반환하는데 이를 참조 투명성이라고도 부른다. 즉, 함수의 리턴 값은 오로지 입력 값에만 의존한다는 것이다.
  

- 불변성

  불변성은 값이나 상태를 변경할 수 없는 것을 의미한다. 프로그래밍에서 불변성은 데이터 원본의 훼손을 막는 것을 의미한다. 간단히 말해, 어떤 값을 직접적으로 변경하지 않고 새로운 값을 만들어 내는 것이다. 자바스크립트에서는 원시타입은 불변성을 지니지만, 객체타입은 값이 변할 수 있다. 자바에서 불변 객체(Immutable Object)는 자바에서 클래스의 인스턴스가 생성된 이후에 내부 상태를 변경할 수 없는 객체이다. 불변 객체는 멀티 스레드 환경에서도 안전하게 사용할 수 있다는 신뢰성을 보장하며, 대표적인 불변 객체로 String 등이 존재한다. 이외에도 프로그래머가 커스텀 객체를 생성하여 내부 상태가 변경되지 않게 만들면, 그것도 불변 객체가 된다.

  ### 불변 객체의 장점

  불변 객체는 read-only 메소드만 제공하며, 객체의 내부 상태를 알려주는 메소드를 제공하지 않거나 제공할 경우 방어적 복사 혹은 Unmodified 라이브러리를 통해 제공한다. 또한 객체의 필드는 모두 final을 사용하여 처음 할당된 이후 상태가 바뀌지 않도록 설정해야 한다. 다만 무조건 final만 필드에 붙인다고 해당 객체를 불변 객체라고 부를 수 있는 것은 아니다.

    - 필드가 모두 primitive type인 경우

    ```java
    public class Car {
    
        private final String name;
    
        private final int position;
    
        public Car(String name, int position) {
            this.name = name;
            this.position = position;
        }
    
        // 필요하다면 getter만 사용. setter는 금지
    }
    ```

  원시 타입은 참조값이 존재하지 않기 때문에 값을 그대로 외부에 내보내는 경우에도 내부 객체는 불변이므로 setter가 없고, 원시 타입 필드에 대해 final을 설정했다면 해당 객체인 Car는 불변 객체가 된다

    - 필드에 reference type이 있는 경우

    ```java
    public class Car {
    
        private final String name;
    
        private final Position position;
    
        public Car(String name, Position position) {
            this.name = name;
            this.position = position;
        }
    
        // 필요하다면 getter만 사용. setter는 금지
    }
    ```

  Car의 객체의 position 필드를 포장하여 참조 객체로 수정했다. 이때 Position 필드에 단순히 final만 붙이면 Car 객체는 불변 객체가 되는 것 처럼 보인다

```
    public class Position {
    
        private int value;
    
        public Position(int value) {
            this.value = value;
        }
    
        public void setValue(int value) {
            this.value = value;
        }
    }
    
```

  하지만 Position이 불변 객체가 아니라면, Car 객체의 getPosition() 메소드를 통해 Position을 가져오고 포지션 객체의 setValue() 메소드를 사용하면 포지션의 상태를 바꿀 수 있다. 그리고 포지션의 상태를 바꿀 수 있다는 말은 즉 Car 객체의 상태를 바꿀 수 있는 의미가 된다. 따라서 필드에 참조 타입이 있는 경우, 해당 참조 타입 객체도 불변 객체로 만들어야 한다.
- Thread-safe하여 병렬 프로그래밍에 유용하며, 동기화를 고려하지 않아도 된다.  
멀티 스레드 환경에서 동기화 문제가 발생하는 이유는 공유 자원에 동시 쓰기 연산 때문이다. 하지만 공유 자원 불변 객체라면, 항상 동일한 값만 반환하므로 동기화를 고려할 필요가 없다. 이는 안정성을 보장할 뿐만 아니라 동기화를 하지 않음으로써 성능 상의 이점도 가져다 준다

- 실패 원자적인(Failure Atomic) 메소드를 만들 수 있다.

  가변객체를 통해 어떠한 작업을 하는 도중 예외가 발생하면 해당 객체가 불안정한 상태에 빠질 수 있다. 그리고 불안정한 상태를 갖는 객체는 변경된 상태로 인해 새로운 에러를 유발할 수 있다. 하지만 불변 객체라면 어떠한 예외가 발생하여도 메소드 호출 전의 상태를 유지할 수 있으므로 예외가 발생하여도 변경된 상태로인한 추가 에러를 막을 수 있다

- Cache, Map, Set 등의 요소로 활용하기에 적합하다

  만약 캐시나 Map 또는 Set 등으로 사용되는 객체가 변경되었다면 이를 갱신하는 등의 작업이 필요하다. 하지만 객체가 불변이라면 한 번 데이터가 저장된 이후에 다른 부가 작업을 고려하지 않아도 될 것이고, 이는 캐시나 다른 자료 구조를 사용하는데 용이하게 작용한다.

- 부수 효과를 피해 오류 가능성을 최소화할 수 있다

  부수 효과란 값이 변경되거나, 필드 값이 설정되는 등의 변화가 발생하는 효과를 의미한다. 만약 객체의 수정자(Setter)가 구현되어 있고, 여러 메소드에서 객체의 값이 변경된다면 객체를 예측하기 어려워진다. 그래서 이러한 부수 효과가 없는 순수 함수를 만드는 것이 중요한데, 객체가 불변이라면 불변 객체는 기본적으로 값의 수정이 불가능하므로 변경 가능성이 적으며 객체의 생성과 사용이 제한된다. 그러므로 메소드들은 자연스럽게 순수 함수로 구성될 것이고 다른 메소드가 호출되어도 객체의 상태가 유지되기 때문에 객체를 안전하게 재사용할 수 있다. 이러한 불변 객체는 오류를 줄여 유지 보수성이 높은 코드를 작성하게 도와준다

- 다른 사람이 작성한 함수를 예측 가능하며 안전하게 사용할 수 있다

  불변 객체는 값이 변하지 않음을 보장하므로 우리가 다른 사람의 코드를 변경에 대한 불안 없이 이용할 수 있다

- 가비지 컬렉션의 성능을 높일 수 있다

  [[Java] 가변 객체 vs 불변 객체](https://steady-coding.tistory.com/559)
  

- 참조투명성

  모든 프로그램에 대해 어떤 표현식(expression) e를 모두 그 표현식의 결과로 치환해도 프로그램에 아무 영향이 없다면 그 표현식 e는 참조에 투명하다. 만약 어떤 함수 f(x)가 모든 입력값 x에 대해 참조에 투명하면 그 함수 f는 순수하다

---

- 고차함수

  일급 함수의 서브셋으로 다음 조건을 만족하는 함수

    - 함수의 인자로 함수를 전달할 수 있다
    - 함수의 리턴값으로 함수를 사용할 수 있다
    - 일급 객체(First object, First class citizen)

      일급 함수라고도 하며 보통 자바스크립트를 배울 때 많이 나오는 개념이며 함수형 프로그래밍의 전제 조건이기도 합니다. 일반적으로 다음과 같은 조건을 만족하는 객체를 말한다

        - 변수나 데이터 구조 안에 넣을 수 있다
        - 함수는 다른 함수의 인자(매개변수,파라미터)로 전달할 수 있다(callback 함수)
        - 동적으로 프로퍼티 할당이 가능
        - 리턴값으로 사용할 수 있다 (합성함수 표현)
        - 함수는 변수에 할당될 수 있다 (Binding)
  

- 클로저

  클로저는 함수 본문이 인수로 전달될 때, 혹은 함수가 자기 내부에서 정의된 것이 아니라 바깥에서 정의 된 변수(자유변수, free variables)를 사용할 때 만들어 진다. 코드를 실행하는 런 타임 때, 자유변수를 “어떤 박스에 넣고 잠가두고” 나중에 함수가 실제로 실행할 때 꺼내서 사용할 수 있도록 만든다. 함수는 변수를 선언한 바깥 부분의 코드가 이미 실행되고 사라진 한참 후에 실행 될지도 모른다. 자바는 내부 클래스를 통해서 클로저의 기능을 제한적으로 지원한다. 이러한 내부 클래스는 바깥 영역에 있는 변수가 final로 선언되었을 때 한해서 사용할 수 있다

```
    public static void main(String[] args){
    	Function<String, UnaryOperator<String>> greeting = (text) -> {
    		return (name) -> {
    			return text + " " + name;
    		};
    	};
    	
    	Function<String, String> hi = greeting.apply("Hi");
    	Function<String, String> hello = greeting.apply("Hello");
    
    	System.out.println(hi.apply("good"));
    	System,out.println(hello.apply("fine"));
    
    ==== 실행 결과 ====
    Hi good
    Hello fine
 ```

  main 함수 안에 선언된 내용을 보면, text 라는 변수는 outer 함수의 값이다. 이를 inner 함수에서 text+” “+name에서 사용하고 있다. 즉 text는 자유변수이다. inner 함수에서 text라는 변수는 inner 함수에서 선언한 적이 없다. outer 함수에서 선언했었기 때문이다. 문제는 greeting 변수로 반환 받을 때인데

```
    Function<String, UnaryOperator<String>> greeting = (text) -> {
    return "뭔가 반환될 것"};
   ```

  뭔가 반환될 것의 부분은 Inner함수가 해당된다. 따라서 greeting 변수에는 inner 함수가 담기게 된다

    ```
    greeting = (name) -> {return text+" "+name;};
    ```

  이렇게 되고 나면 outer함수는 종료된 상황이다. 그럼 outer 함수의 scope 안에서 선언된 text라는 자유 변수는 outer 함수가 끝났으니 메모리에서 사라질까? 이때 클로저를 사용한다. 이미 외부 함수는 끝났음에도 inner 함수에서 자유변수인 text를 아직도 사용이 가능하다. 이를 클로저라 부른다. outer 함수의 변수이지만 이를 기억해두고 있다 나중에 필요한 시점에 사용이 가능하다.
  

- 이름없는 함수(익명함수)

  익명 함수는 함수 이름이 없는 함수로 람다식으로 표현되는 함수 구현을 말한다. 익명함수들은 모두 일급 객체이다. 일급 객체인 함수는 변수처럼 사용가능하며 매개 변수로 전달이 가능하다는 특징을 가지고 있다.


---

## 함수형 프로그래밍

### **핵심**

> 함수가 1등 시민 first-class citizen함수를 타입으로 지정하거나,인자값으로 넘기거나,리턴값으로 받을 수 있다
>

**`마치 함수도 객체처럼 변수나 함수의 인자, 리터럴하게 다룰 수 있다는 것이다.`**

### **람다 계산 Lambda Calculus**

![https://lucas-image.codesquad.kr/1671438958770programming-paradigm.png](https://lucas-image.codesquad.kr/1671438958770programming-paradigm.png)

알론조 처치 Alonze Church가 고안한 람다 계산법을 기반으로 한다.

### **람다 계산식 3가지 문법**

### **1. Variable : 변수**

**`x`** : 논리값, 숫자값 또는 반복적으로 사용되는 매개변수 문자열

### **2. Abstraction : 요약(선언)**

**`(λx.M)`** : **M** 부분에 람다 함수의 선언.예를 들어 **`𝑓(x) = x²+2`** 함수 선언은 람다 요약으로 **`λx.x²+2`** 로 표현한다. **`𝑓(x) = x+y`**는 **`λx.x+y`**라고 표현한다.

### **3. Application : 전개(호출)**

**`(M N)`** : 함수식에 **N** 인자값을 적용해서 전개

**`square_sum(x, y) = x² + y²`**함수에 x=2, y=2 인자값을 넘겨서 전개하면 다음과 같다

```
(x, y) ↦ x² + y²

((x, y) ↦ x² + y²)(5,2)
= 5² + 2²
= 29
```

람다 계산식으로 전개하는 과정은 다음과 같다

```
x ↦ ( y ↦ x² + y² )

( (x ↦ ( y ↦ x² + y² ))(5) )(2)
= (( y ↦ 5² + y² )(2)
= 5² + 2²
= 29
```

### **함수형 프로그래밍 특징**

최근에 만들어진 현대 언어들은 함수형 패러다임과 객체지향 패러다임을 모두 포함하는 하이브리드 언어로 발전하고 있다.

![https://lucas-image.codesquad.kr/1671438966737paradigm-language.png](https://lucas-image.codesquad.kr/1671438966737paradigm-language.png)

### **불변성 Immutable**

람다 계산법의 근간이 되는 개념은 **`심볼의 값이 변경되지 않는다`** 는 것이다.가변 변수를 사용하는 대신에 심볼에 값을 할당하면 그 값은 변경되지 않는다.

### **순수함수 pure function**

프로그래밍 언어는 수학에서 사용하는 순수하고 선언적인 함수와 달리 계산 절차를 표현할 뿐이다.그래서 초창기에는 function 이라고 부르지 않고 routine 혹은 procedure 라고 부르는 언어가 많았다.

입력 값이 동일하면 결과가 동일하게 리턴되는 수학 함수와 마찬가지로 함수형 프로그래밍 언어에서는 함수를 **`순수 함수`**라고 부른다. 계산 절차를 포함하더라도 순수 함수로 만들면 **`부작용`**이 없다.

### **참조투명성과 부작용**

순수 함수로 만들면 함수 외부에 값이나 객체를 참조하거나 의존적으로 동작하지 않기 때문에 참조투명성을 가지고, 부작용이 없다.반대로 말하면 부작용이 있는 함수는 입력 값이 동일해도 함수 외부에 값에 따라서 다른 값이 리턴한다.

### **람다 또는 클로저closure**

```
var worldcup = 2002

func next() {
  worldcup = worldcup + 4
}

let isQatar = { (year) -> return (year == worldcup+20) }

isQatar(2022) //true
next()
isQatar(2022) //false
```

- 클로저는 람다계산식(lambda Calculus) 구현체
- 이름 없는 함수(anonymous function)로 리터럴하게 작성가능
- 선언된 범위(scope)에서 접근 가능한 변수를 캡처해서 저장하고 닫힘
- Java(8이후), Kotlin, JS, Swift 언어에서 클로저는 캡처한 변수를 참조(reference)한다

### **자바에서 람다**

특이하게도 자바는 인터페이스를 선언해야만 한다

```
public class  La {
	public interface Calculator {
		public int square(int number);
	}
	public static void main(String[] args) {
		Calculator closure1 = (int n) -> {return n * n; };
		Calculator closure2 = (n) -> {return n * n; };
		Calculator closure3 = n -> n * n;
		System.out.println(closure1.square(2));
	}
}
```

---

## 람다(Lamda)

람다식이란 함수를 하나의 식으로 표현한 것이다. 함수를 람다식으로 표현하면 메소드의 이름이 필요 없기 때문에, 람다식은 익명함수의 한 종류라고 볼 수 있다. (자바에서는 클래스의 선어놔 동시에 객체를 생성하므로, 단 하나의 객체만을 생성할 수 있는 클래스를 익명 클래스라고 한다) 람다 표현식을 사용하면 기존의 불필요한 코드를 줄여주고 작성된 코드의 가독성을 높여준다. Java SE 8부터는 람다 표현식을 사용하여 자바에서도 함수형 프로그래밍을 할 수 있게 되었다.

### 람다의 특징

- 익명 : 메서드 이름이 없다
- 함수 : 메서드처럼 파라미터 리스트, 바디, 반환 형식, 가능한 예외 리스트를 포함하지만 클래스에 종속되지 않으므로 함수라고 부른다
- 전달 : 메서드 인수로 전달하거나 변수로 저장할 수 있다
- 간결성 : 익명 클래스처럼 클래스 이름, 메서드 이름, 파라미터 타입, 반환 타입등이 없기 때문에 코드가 간결하다

[[Modern Java] 람다 표현식(Lambda Expression)](https://dev-kani.tistory.com/38)

```java
int min(int x, int y) {
    return x < y ? x : y;
}
```

위 메소드를 람다 표현식으로 변경하면

```java
(x, y) -> x < y ? x : y;
```

이런 식으로 작성할 수 있다. 자바에서는 화살표(→) 기호를 사용하여 람다 표현식을 작성할 수 있다.

(매개변수목록) → {함수 몸체}

- 매개변수의 타입을 추론할 수 있는 경우에는 타입 생략 가능
- 매개변수가 하나인 경우 괄호 (()) 생략 가능
- 함수의 몸체가 하나의 명령문만으로 이루어진 경우 중괄호 ({}) 생략가능. 이때 세미콜론(;)은 붙이지 않음
- 함수의 몸체가 하나의 return문으로만 이루어진 경우 중괄호 생략 불가
- return문 대신 표현식을 사용가능. 이 때 반환값은 표현식의 결괏값이 된다. 이때 세미콜론은 붙이지 않음

## 함수형 인터페이스(functional interface)

람다 표현식을 사용할 때는 람다 표현식을 저장하기 위한 참조 변수의 타입을 결정해야 한다.

```
참조변수의타입 참조변수의이름 = 람다 표현식
```

람다 표현식을 하나의 변수에 대입할 때 사용하는 참조 변수의 타입을 함수형 인터페이스라고 부른다.

함수형 인터페이스는 추상 클래스와는 달리 단 하나의 추상 메소드만을 가져야 한다. 또한 @**FunctionalInterface** 과 같은 어노테이션을 사용하여 함수형 인터페이스임을 명시할 수 있다. 이같은 어노테이션을 인터페이스의 선언 앞에 붙이면, 컴파일러는 해당 인터페이스를 함수형 인터페이스로 인식한다. 자바 컴파일러는 이렇게 명시된 함수형 인터페이스에 두 개 이상의 메소드가 선언되면 오류를 발생시킨다.

### 메소드 참조(method reference)

메소드 참조는 람다표현식이 단 하나의 메소드만을 호출하는 경우 해당 람다 표현식에서 불필요한 매개변수를 제거하고 사용할 수 있다.

```
클래스이름::메소드이름
또는
참조변수이름::메소드이름
```

또한 특정 인스턴스의 메소드를 참조할 때에도 참조 변수의 이름을 통해 메소드 참조를 사용할 수 있다

```java
MyClass obj = new MyClass;
Function<String, Boolean> func = (a) -> obj.equals(a); // 람다 표현식
Function<String, Boolean> func = obj::equals(a);       // 메소드 참조
```

### 생성자 참조

생성자를 호출하는 람다 표현식도 메소드 참조를 이용할 수 있다. 즉, 단순히 객체를 생성하고 반환하는 람다 표현식은 생성자 참조로 변환할 수 있다.

```
(a) -> {return new Object(a);}

위 예제는 단순히 Object 클래스의 인스턴스를 생성하고 반환하기만 하므로,
생성자 참조를 사용하여 간단하게 표현할 수 있다

Object::new;

이때 해당 생성자가 존재하지 않으면 컴파일 시 오류가 발생한다.
또한, 배열을 생성할 때에도 다음과 같이 생성자 참조를 사용할 수 있다

Function<Integer, double[]> func1 = a -> new double[a]; // 람다 표현식

Function<Integer, double[]> func2 = double[]::new;      // 생성자 참조
```

---

## 스트림 API

자바에서 많은 양의 데이터를 저장하기 위해 배열이나 컬렉션을 사용하는데 이렇게 저장된 데이터에 접근하기 위해선 반복문이나 반복자를 사용하여 매번 새로운 코드를 작성해야한다. 하지만 이렇게 작성된 코드는 가독성이 떨어지고 코드의 재사용이 거의 불가능하다

이러한 문제점을 극복하기 위해 Java SE 8 부터 스트림(stream) API를 도입했다. 스트림 API는 데이터를 추상화하여 다루므로 다양한 방식으로 저장된 데이터를 읽고 쓰기 위한 공통된 방법을 제공한다. 따라서 스트림 API를 이용하면 배열이나 컬렉션뿐 아니라 파일에 저장된 데이터도 모두 같은 방법으로 다룰 수 있게 된다

### 스트림 API의 특징

- 스트림은 외부 반복을 통해 작업하는 컬렉션과 달리 내부 반복을 통해 작업을 수행함
- 스트림은 단 한번만 사용할 수 있다 (컬렉션은 재사용가능)
- 스트림은 원본 데이터를 변경하지 않는다
- 스트림의 연산은 필터-맵(filter-map) 기반의 API를 사용하여 지연(lazy) 연산을 통해 성능을 최적화한다
- 스트림은 parallelStream() 메소드를 통한 손쉬운 병렬 처리를 지원

### 스트림 API의 동작 흐름

생성 → 중개 연산(스트림의 변환) → 스트림의 최종 연산(스트림의 사용)

<img width="465" alt="스크린샷 2023-01-31 오전 12 42 50" src="https://user-images.githubusercontent.com/95615105/215523487-6cd2841f-ffca-4e03-af19-23d79fb21388.png">

### 스트림의 생성

- 컬렉션

Collection 인터페이스에는 stream() 메소드가 정의되어 있다. 따라서 List와 Set 클래스에서도 스트림 생성이 가능하다

```java
rrayList<Integer> list = new ArrayList<Integer>();

list.add(4);
list.add(2);
list.add(3);
list.add(1);

// 컬렉션에서 스트림 생성
Stream<Integer> stream = list.stream();

// forEach() 메소드를 이용한 스트림 요소의 순차 접근
stream.forEach(System.out::println);

// 결과 : 4 2 3 1 (개행함)
```

스트림 클래스의 forEach()메소드는 해당 스트림의 요소를 하나씩 소모해가며 순차적으로 요소에 접근한다. 따라서 같은 스트림으로는 forEach() 메소드를 한번만 호출할 수 있다. 단, 원본 데이터의 요소를 소모하는 것은 아니라서 같은 데이터에서 또 다른 스트림을 생성하여 forEach()메소드를 호출하는 것은 가능하다

- 배열

Arrays 클래스에서 기본타입인 int,long,double 형을 저장할 수 있는 배열에 관한 스트림이 별도로 정의되어 있다.

```java
String[] arr = new String[]{"넷", "둘", "셋", "하나"};

// 배열에서 스트림 생성
Stream<String> stream1 = Arrays.stream(arr);
stream1.forEach(e -> System.out.print(e + " "));
System.out.println();
 
// 배열의 특정 부분만을 이용한 스트림 생성
Stream<String> stream2 = Arrays.stream(arr, 1, 3);
stream2.forEach(e -> System.out.print(e + " "));

// 결과
넷 둘 셋 하나
둘 셋
```

Arrays 클래스의 stream() 메소드는 전체 배열뿐만 아니라 배열의 특정 부분만을 이용하여 스트림을 생성할 수도 있다

- 가변 매개변수

Stream 클래스의 of() 메소드를 사용하면 가변 매개변수를 전달받아 스트림을 생성할 수 있다

```java
// 가변 매개변수에서 스트림 생성
Stream<Double> stream = Stream.of(4.2, 2.5, 3.1, 1.9);
stream.forEach(System.out::println);
```

- 지정된 범위의 연속된 정수

IntStream나 LongStream 인터페이스에는 range()와 rangeClosed() 메소드가 정의되어 있다.

range() - 명시된 시작 정수 포함, 마지막 정수는 포함 하지 않는 스트림 생성

rangeClosed() - 명시된 시작 정수 뿐만 아니라 마지막 정수까지도 포함하는 스트림 생성

```java
// 지정된 범위의 연속된 정수에서 스트림 생성
IntStream stream1 = IntStream.range(1, 4);
stream1.forEach(e -> System.out.print(e + " "));
System.out.println();

IntStream stream2 = IntStream.rangeClosed(1, 4);
stream2.forEach(e -> System.out.print(e + " "));

// 결과
1 2 3 
1 2 3 4
```

- 특정 타입의 난수들

Random 클래스에는 ints(), longs(), doubles()와 같은 메소드가 정의되어 있다. 이 메소드들은 매개변수로 스트림의 크기를 long 타입으로 전달받을 수 있다. 만약 매개변수를 전달받지 않으면 크기가 정해지지 않은 무한 스트림을 반환하기 때문에 limit() 메소드를 사용하여 따로 스트림의 크기를 제한해야 한다.

```java
// 특정 타입의 난수로 이루어진 스트림 생성
IntStream stream = new Random().ints(4);
stream.forEach(System.out::println);

// 결과
1072176871
-649065206
133298431
-616174137
```

- 람다 표현식

람다 표현식을 매개변수로 전달받아 해당 람다 표현식에 의해 반환되는 값을 요소로 하는 무한 스트림을 생성하기 위해 Stream 클래스에는 iterate()와 generate() 메소드가 정의되어 있다.

iterate() - 시드(seed)로 명시된 값을 람다 표현식에 사용하여 반환된 값을 가시 시드로 사용하는 방식으로 무한 스트림 생성

generate() - 매개변수가 없는 람다 표현식을 사용하여 반환된 값으로 무한 스트림 생성

```java
// iterate() 메소드를 이용하여 홀수만으로 이루어진 무한 스트림을 생성하는 예제
IntStream stream = Stream.iterate(2, n -> n + 2); // 2, 4, 6, 8, 10, ...
```

- 빈 스트림

아무 요소도 가지지 않는 빈 스트림은 empty() 메소드를 사용해서 생성할 수 있다

```java
// 빈 스트림 생성
Stream<Object> stream = Stream.empty();
System.out.println(stream.count()); // 스트림의 요소의 총 개수를 출력함.

// 결과
0
```

### 스트림의 중개 연산

1. 스트림 필터링 : filter(), distinct()
- filter() 메소드는 해당 스트림에서 주어진 조건(predicate)에 맞는 요소만으로 구성된 새로운 스트림을 반환
- distinct() 메소드는 해당 스트림에서 중복된 요소가 제거된 새로운 스트림을 반환. 내부적으로 Object 클래스의 equals() 메소드를 사용하여 요소의 중복을 비교

```java
IntStream stream1 = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
IntStream stream2 = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);

// 스트림에서 중복된 요소를 제거함.
stream1.distinct().forEach(e -> System.out.print(e + " "));
System.out.println();

// 스트림에서 홀수만을 골라냄.
stream2.filter(n -> n % 2 != 0).forEach(e -> System.out.print(e + " "));

// 결과
7 5 2 1 3 4 6 
7 5 5 1 3 5
```

2. 스트림 변환 : map(), flatMap()
- map() 메소드는 해당 스트림의 요소들을 주어진 함수에 인수로 전달하여, 그 반환값들로 이루어진 새로운 스트림을 반환. 만약 해당 스트림의 요소가 배열이라면, flatMap() 메소드를 사용하여 각 배열의 각 요소의 반환값을 하나로 합친 새로운 스트림을 얻을 수 있다

```java
// 문자열로 이루어진 스트림을 각 문자열의 길이로 이루어진 스트림으로 변환
Stream<String> stream = Stream.of("HTML", "CSS", "JAVA", "JAVASCRIPT");
stream.map(s -> s.length()).forEach(System.out::println);

// 결과
4 3 4 10 (개행)

// 여러 문자열이 저장된 배열을 각 문자열에 포함된 단어로 이루어진 스트림으로 변호나
String[] arr = {"I study hard", "You study JAVA", "I am hungry"};

Stream<String> stream = Arrays.stream(arr);
stream.flatMap(s -> Stream.of(s.split(" +"))).forEach(System.out::println);

// 결과
I
study
hard
You
study
JAVA
I
am
hungry
```

3. 스트림 제한 : limit(), skip()
- limit() 메소드는 해당 스트림의 첫 번째 요소부터 전달된 개수만큼의 요소만으로 이루어진 새로운 스트림을 반환
- skip() 메소드는 해당 스트림의 첫 번째 요소부터 전달된 개수만큼의 요소를 제외한 나머지 요소만으로 이루어진 새로운 스트림을 반환

```java
IntStream stream1 = IntStream.range(0, 10);
IntStream stream2 = IntStream.range(0, 10);
IntStream stream3 = IntStream.range(0, 10);

stream1.skip(4).forEach(n -> System.out.print(n + " "));
System.out.println();

stream2.limit(5).forEach(n -> System.out.print(n + " "));
System.out.println();

stream3.skip(3).limit(5).forEach(n -> System.out.print(n + " "));

// 결과
4 5 6 7 8 9 
0 1 2 3 4 
3 4 5 6 7
```

4. 스트림 정렬 : sorted()

sorted() 메소드는 해당 스트림을 주어진 비교자(comparator)를 이용하여 정렬. 이때 비교자를 전달하지 않으면 기본적으로 사전 편찬 순(natural order)으로 정렬

```java
Stream<String> stream1 = Stream.of("JAVA", "HTML", "JAVASCRIPT", "CSS");
Stream<String> stream2 = Stream.of("JAVA", "HTML", "JAVASCRIPT", "CSS");

stream1.sorted().forEach(s -> System.out.print(s + " "));
System.out.println();

stream2.sorted(Comparator.reverseOrder()).forEach(s -> System.out.print(s + " "));

// 결과
CSS HTML JAVA JAVASCRIPT 
JAVASCRIPT JAVA HTML CSS
```

5. 스트림 연산 결과 확인 : peek()

peek() 메소드는 결과 스트림으로부터 요소를 소모하여 추가로 명시된 동작을 수행. 이 메소드는 원본 스트림에서 요소를 소모하지 않으므로, 주로 연산과 연산 사이에 결과를 확인하고 싶을 때 사용. 디버깅 용도로 사용한다

```
IntStream stream = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);

stream.peek(s -> System.out.println("원본 스트림 : " + s))
    .skip(2)
    .peek(s -> System.out.println("skip(2) 실행 후 : " + s))
    .limit(5)
    .peek(s -> System.out.println("limit(5) 실행 후 : " + s))
    .sorted()
    .peek(s -> System.out.println("sorted() 실행 후 : " + s))
    .forEach(n -> System.out.println(n));
```

```
원본 스트림 : 7
원본 스트림 : 5
원본 스트림 : 5
skip(2) 실행 후 : 5
limit(5) 실행 후 : 5
원본 스트림 : 2
skip(2) 실행 후 : 2
limit(5) 실행 후 : 2
원본 스트림 : 1
skip(2) 실행 후 : 1
limit(5) 실행 후 : 1
원본 스트림 : 2
skip(2) 실행 후 : 2
limit(5) 실행 후 : 2
원본 스트림 : 3
skip(2) 실행 후 : 3
limit(5) 실행 후 : 3
sorted() 실행 후 : 1
1
sorted() 실행 후 : 2
2
sorted() 실행 후 : 2
2
sorted() 실행 후 : 3
3
sorted() 실행 후 : 5
5
```

위의 예제에서 첫 번째 요소인 7과 두 번째 요소인 5는 skip() 메소드에 의해 삭제되므로, 원본 스트림에서만 나타난다.

하지만 세 번째 요소인 5는 skip() 메소드와 limit() 메소드가 실행된 후에도 존재하므로, 모두 나타난다.

이렇게 peek() 메소드는 스트림의 각 요소가 해당 중개 연산 후에 어떻게 변화하는지를 보여준다

### 대표적인 중개 연산 메소드

스트림 API에서 사용할 수 있는 대표적인 중개 연산을 위한 메소드는 다음과 같다

| 메소드 | 설명 |
| --- | --- |
| Stream<T> filter(Predicate<? super T> predicate) | 해당 스트림에서 주어진 조건(predicate)에 맞는 요소만으로 구성된 새로운 스트림을 반환함. |
| <R> Stream<R> map(Functoin<? super T, ? extends R> mapper) | 해당 스트림의 요소들을 주어진 함수에 인수로 전달하여, 그 반환값으로 이루어진 새로운 스트림을 반환함. |
| <R> Stream<R> flatMap(Functoin<? super T, ? extends Stream<? extends R>> mapper) | 해당 스트림의 요소가 배열일 경우, 배열의 각 요소를 주어진 함수에 인수로 전달하여, 그 반환값으로 이루어진 새로운 스트림을 반환함. |
| Stream<T> distinct() | 해당 스트림에서 중복된 요소가 제거된 새로운 스트림을 반환함.
내부적으로 Object 클래스의 equals() 메소드를 사용함. |
| Stream<T> limit(long maxSize) | 해당 스트림에서 전달된 개수만큼의 요소만으로 이루어진 새로운 스트림을 반환함. |
| Stream<T> peek(Consumer<? super T> action) | 결과 스트림으로부터 각 요소를 소모하여 추가로 명시된 동작(action)을 수행하여 새로운 스트림을 생성하여 반환함. |
| Stream<T> skip(long n) | 해당 스트림의 첫 번째 요소부터 전달된 개수만큼의 요소를 제외한 나머지 요소만으로 이루어진 새로운 스트림을 반환함. |
| Stream<T> sorted()
Stream<T> sorted(Comparator<? super T> comparator) | 해당 스트림을 주어진 비교자(comparator)를 이용하여 정렬함.
비교자를 전달하지 않으면 영문사전 순(natural order)으로 정렬함. |

### 스트림의 최종연산

[코딩교육 티씨피스쿨](http://www.tcpschool.com/java/java_stream_terminal)

---

## 순수함수 만들기🎯

### 학습 목표

- 불변성(Immutable) 값이나 변수를 적극 활용할 수 있다
- 함수가 참조 투명성을 지키고, 부작용을 줄일 수 있도록 구현할 수 있다
- 순수 함수(Pure Function)로 구현할 수 있다

### 기능요구사항

각 언어로 만들어진 2개의 클래스에서 중복 코드를 줄이고 함수형 표현으로 최대한 개선

### 예상결과 및 동작예시

1부터 100까지 숫자를 각 함수에 넣고 동작 결과가 동일해야 한다

### 구현 코드

이렇게 짜는게 맞는걸까? 문제가 무슨 소리인지 이해를 못하갰다

**Factors 클래스**

```
import java.util.HashSet;
import java.util.Set;

public class Factors {

    public static boolean isFactor(int number, int potentialFactor) {
        return number % potentialFactor == 0;
    }

    public static Set<Integer> of(int number) {
        HashSet<Integer> factors = new HashSet<>();
        for (int pod=1; pod <= Math.sqrt(number); pod++) {
            if (isFactor(number, pod)) {
                factors.add(pod);
                factors.add(number / pod);
            }
        }
        return factors;
    }


}

```

**PrimeAlpha 클래스**

```
import java.util.HashSet;
import java.util.Set;

public class PrimeAlpha extends Factors{

    public boolean isPrime(int number) {
        Set<Integer> primeSet = new HashSet<>(){ {add(1); add(number);} };
        return number > 1 && of(number).equals(primeSet);
    }

    public static void main(String[] args) {
        PrimeAlpha prime1 = new PrimeAlpha();

        System.out.println(prime1.isPrime(5));
    }
}
```

**ClassifierAlpha 클래스**

```
import java.util.Iterator;
import java.util.Set;

public class ClassifierAlpha{

    public int sum(int number) {
        Iterator<Integer> iterator = Factors.of(number).iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        return sum;
    }

    public boolean isPerfect(int number) {
        return sum(number) - number == number;
    }

    public boolean isAbundant(int number) {
        return sum(number) - number > number;
    }

    public boolean isDeficient(int number) {
        return sum(number) - number < number;
    }
    public static void main(String[] args) {
        ClassifierAlpha alpha = new ClassifierAlpha();

        System.out.println(alpha.isPerfect(28));
    }
}

```


---

## 고차함수 활용하기🎯

### 학습 목표

- 클로저를 선언해서 매개변수 또는 리턴 값으로 전달
- map, filter, reduce 함수 사용
- 클로저 관련된 다양한 표현 학습

### **기능요구사항**

앞서 작성한 자연수 분류 ClassifierAlpha, PrimeAlpha 를 이용해서 2-100까지 자연수 중에서완전수(perfect), 과잉수(Abundant), 부족수(Deficient), 소수(Prime), 정사각수(Squared) 목록을 출력한다.

- map, filter, reduce 고차 함수를 활용한다.
- 출력을 위해서는 반드시 클로저(또는 람다)를 선언하고 반복문 대신 reduce를 활용해서 출력해야 한다.
- 자연수 중에서 다른 자연수의 제곱으로 표현되는 정사각수(squared) 판단 함수를 추가한다

### **예상결과 및 동작예시**
```
2 : deficient, prime
3 : deficient, prime
4 : deficient, squared
5 : deficient, prime
6 : perfect,
7 : deficient, prime
8 : deficient,
9 : deficient, squared
10 : deficient,
11 : deficient, prime
12 : abundant,
13 : deficient, prime
14 : deficient,
15 : deficient,
16 : deficient, squared
17 : deficient, prime
18 : abundant,
19 : deficient, prime
...
88 : abundant,
89 : deficient, prime
90 : abundant,
91 : deficient,
92 : deficient,
93 : deficient,
94 : deficient,
95 : deficient,
96 : abundant,
97 : deficient, prime
98 : deficient,
99 : deficient,
100 : abundant, squared
```