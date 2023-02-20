# CS07

### 학습키워드

- XML(EXtensible Markup Language)

  XML은 HTML처럼 데이터를 보여주는 목적이 아니라 데이터를 저장하고 전달할 목적으로 만들어졌으며, 저장되는 데이터의 구조를 기술하기 위한 언어다. 또한 XML 태그는 HTML 태그처럼 미리 정의되어 있지 않고, 사용자가 직접 정의할 수 있다 . XML은 문서용 마크업 언어를 정의하기 위한 메타언어인 SGML(Standard Generalized Markup Language)을 기반으로 만들어졌다.

    - XML의 특징
        - 다른 목적의 마크업 언어를 만드는데 사용되는 다목적 마크업 언어
        - 다른 시스템끼리 다양한 정류의 데이터를 손쉽게 교환할 수 있도록 해줌
        - 새로운 태그를 만들어 추가해도 계속해서 동작하므로 확장성이 좋다
        - 데이터를 보여주지 않는다. 전달하고 저장하는 것만 한다.
        - 텍스트 데이터 형식의 언어로 모든 XML 문서는 유니코드 문자로만 이루어진다
    - XML 기반의 언어
        1. XHTML
        2. SVG
        3. RDF
        4. RSS
        5. Atom
        6. MathML
    - HTML 로부터 데이터 분리

      HTML 문서의 데이터를 XML 파일로 따로 저장할 수 있다. 이런 데이터는 자바스크립트 코드로 간단히 읽어 들일 수 있고, HTML문서 내에서 불러온 데이터를 쉽게 이용할 수 있다.

```
        function loadDoc() {
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.onreadystatechange = function() {
                if(this.status == 200 && this.readyState == this.DONE) {
                    displayData(xmlHttp);
                }
            };
            xmlHttp.open("GET", "/examples/media/korean_major_cities.xml", true);
            xmlHttp.send();
        }
        
        function displayData(xmlHttp) {
            var xmlObj, cityList, result, idx;
            xmlObj = xmlHttp.responseXML; // 요청한 데이터를 XML DOM 객체로 반환함.
            result = "<table><tr><th>도시 이름</th><th>행정구역</th></tr>";
            cityList = xmlObj.getElementsByTagName("city");
            for(idx = 0; idx < cityList.length; idx++) {
                result += "<tr><td>" +
                    cityList[idx].getElementsByTagName("name")[0].childNodes[0].nodeValue + "</td><td>" +
                    cityList[idx].getElementsByTagName("class")[0].childNodes[0].nodeValue + "</td></tr>";
            }
            result += "</table>";
            document.getElementById("text").innerHTML = result;
        }
```
위 예제를 XML 데이터로 분리해서 가져오면 
```
    <?xml version="1.0" encoding="UTF-8"?>
    
    <korean_cities>
    
        <city>
    
            <name>서울</name>
    
            <class>특별시</class>
    
        </city>
    
        <city>
    
            <name>부산</name>
    
            <class>광역시</class>
    
        </city>
    
        <city>
    
            <name>인천</name>
    
            <class>광역시</class>
    
        </city>
    
        <city>
    
            <name>대전</name>
    
            <class>광역시</class>
    
        </city>
    
        <city>
    
            <name>광주</name>
    
            <class>광역시</class>
    
        </city>
    
        <city>
    
            <name>대구</name>
    
            <class>광역시</class>
    
        </city>
    
        <city>
    
            <name>울산</name>
    
            <class>광역시</class>
    
        </city>
    
        <city>
    
            <name>수원</name>
    
            <class>시</class>
    
        </city>
    
        <city>
    
            <name>청주</name>
    
            <class>시</class>
    
        </city>
    
        <city>
    
            <name>목포</name>
    
            <class>시</class>
    
        </city>
    
    </korean_cities>
```

| 도시이름 | 행정구역  |
|------|-------|
| 서울   | 특별시   |
| 부산   | 광역시   |
| 인천   | 광역시   |
| 대전   | 광역시   |
| 광주   | 광역시   |
| 대구   | 광역시   |
| 울산   | 광역시   |
| 수원   | 시     |
| 청주   | 시     |
| 목포   | 시     |

XML을 배우기 위해선 HTML과 자바스크립트의 기초 지식이 필요하다.
    
[HTML 수업부터 배우고 오기 =>](http://www.tcpschool.com/html/intro)
    
[자바스크립트 수업부터 배우고 오기 =>](http://www.tcpschool.com/javascript/intro)
    
[코딩교육 티씨피스쿨](http://www.tcpschool.com/xml/intro)
    
> XML을 배워보자  
> [XML 구조](https://mystyle1057.tistory.com/entry/XML-%EA%B5%AC%EC%A1%B0)


- 토큰

  프로그래밍 언어에서의 토큰은, 문법적으로 더 이상 나눌 수 없는 기본적인 언어요소를 말한다. 예를 들어 하나의 키워드나 연산자 또는 구두점 등이 토큰이 될 수 있다.

  [[개념 정리] Token이란?](https://badstorage.tistory.com/29)

- 정규표현식

  사전적인 의미로는 특정한 규칙을 가진 문자열의 집합을 표현하는데 사용하는 형식 언어.

  [정규표현식(Regular Expression)을 소개합니다.](https://www.nextree.co.kr/p4327/)

  [정규표현식 (Regular Expression) 이해하기](https://yurimkoo.github.io/analytics/2019/10/26/regular_expression.html)

  [정규표현식 (regex)](https://sooftware.io/regex/)

- DOM(Document Object Model)

  문서 객체 모델(DOM)은 XML이나 HTML 문서에 접근하기 위한 API이다. DOM은 문서 내의 모든 요소를 정의하고, 해당 요소에 접근하는방법까지 정의한다.

    1. Core DOM : 모든 문서 타입을 위한 DOM 모델

    2. HTML DOM : HTML 문서를 위한 DOM 모델

    3. XML DOM : XML 문서를 위한 DOM 모델

    ---

  ### HTML DOM

  HTML DOM은 HTML 문서에 접근하여 조작할 수 있는 표준화된 방법을 정의

  모든 HTML 요소는 HTML DOM을 통해 접근할 수 있다
    
  ---

  ### XML DOM

  XML DOM은 XML 문서에 접근하여, 해당 문서를 조작할 수 있는 표준화된 방법을 정의

  모든 XML 요소는 XML DOM을 통해 접근할 수 있다

  XML DOM은 XML 문서 내의 모든 요소의 객체, 속성 그리고 메소드를 정의

  이러한 XML DOM은 플랫폼이나 프로그래밍 언어에 상관없이 언제나 사용할 수 있다

- Tokenizer

  토크나이저란 어떤 구문에서 의미있는 요소들을 토큰으로 쪼개는 역할을 한다.

- lexer

  토큰의 의미를 분석하는 역할.

  Tokenizer, Lexer 의 역할을 합하여 Lexical anlyze라고 한다. Lexical Analyze란 의미 있는 조각을 검출하여 토큰을 생성하는 것을 말한다.

  예를들어, Lexical analysis is the first step of compiler"라는 문장에서 'L', 'e', 'x', 'i', 'c', 'a', 'l'을 따로 놓으면 어떠한 의미도 없지만, "Lexical"이라는 하나의 조각으로 보면 의미를 갖게 된다.

  이렇게 토큰 단위로 키워드나 속성을 정의한 이후에 parser에게 넘겨준다.

- Parser

  Parser는 Lexical analyze 되어 토큰화된 데이터를 가지고 그것을 구조적으로 나타낼 수 있게 해준다. 또한 데이터를 구조적으로 바꾸는 과정에서 데이터가 올바른지 검증을 수행한다. 대부분의 인터프리터와 컴파일러에서 소스코드를 구조적으로 나타내는 자료구조로 AST를 사용한다.

  [컴파일러 이론에서 토크나이저(Tokenizer), 렉서(Lexer), 파서(Parse) 의 역할](https://velog.io/@mu1616/%EC%BB%B4%ED%8C%8C%EC%9D%BC%EB%9F%AC-%EC%9D%B4%EB%A1%A0%EC%97%90%EC%84%9C-%ED%86%A0%ED%81%AC%EB%82%98%EC%9D%B4%EC%A0%80Tokenizer-%EB%A0%89%EC%84%9CLexer-%ED%8C%8C%EC%84%9CParse-%EC%9D%98-%EC%97%AD%ED%95%A0)

  [[컴파일러 이론] Tokenizer, Lexer, Parser](https://trumanfromkorea.tistory.com/79)


[HTML과 XML의 차이점 - 하나몬](https://hanamon.kr/htm-xml-%EC%B0%A8%EC%9D%B4%EC%A0%90/)

- tokenizer, lexer, parser 역할이 무엇인지 학습
- 공백 문자로 구분되는문자열을 순서대로 토큰으로 만들고, 각 토큰의 순서와 어휘를 분석해서 의미 부여

### 일반적인 토큰 종류

프로그래밍 언어에서 사용하는 토큰의 종류

- identifier : 식별하기 위한 이름
- keyword : 미리 지정한 예약어
- separator : 글자를 구분하는 문자
- operator : 연산을 위한 심볼
- literal : 숫자, 논리, 문자
- comment : 줄 또는 블록 코멘터리

### **토큰 예시**

| 토큰이름 | 샘플 |
| --- | --- |
| identifier | HTML, BODY |
| separator | <, >, [, ], , |
| operator | +, <, = |
| literal | true, NULL, 3.14, "hello" |
| comment | <!코멘트는 무시> |

### **예시**

JSON **`[ 23, “JK”, false ]`** 는 다음과 같은 토큰으로 분리할 수 있다**`[ LeftSquareBracker, token(23), comma, token(“JK”), comma, token(false), RightSquareBracker]`**

### **중첩되는 구조를 해결하는 방법**

### **1. 재귀함수**

반복해서 중첩되는 구조를 해결하기 위해서 재귀 함수(호출)을 구현하기도 한다.재귀 호출 구조가 편리한 경우도 있지만, 메모리 관리나 콜 스택이 너무 깊어지지 않도록 주의해야 한다.

### **2. 스택 Stack**

중첩 또는 반복되는 구조에서 이전 상태를 보관하기 위해서 스택을 활용한다.[https://ko.wikipedia.org/wiki/스택](https://ko.wikipedia.org/wiki/%EC%8A%A4%ED%83%9D)

# **오토마타 소개**

- **`오토마타`** : 가능한 상태(State)들의 유한한 집합(Set)
- 상태는 주어진 규칙(Rule)에 따라 이전 상태에서 다음 상태로 전이(Transition)

### **오토마타 표현**

이론상으로는 무한 오토마타도 있을 수 있지만, 유한한 집합만 처리 가능하기 때문에 유한한 상태만 다룬다. 컴파일러 이론의 기초는 오토마타 이론이다.

### **유한(Finite) 오토마타**

### **1) 그래프 표현 방식**

- 상태는 노드(node)
- 상태 전이(transition)은 방향있는 화살표 (directed edge)
- 전이 규칙은 화살표 옆에 레이블(Label)

  ![https://lucas-image.codesquad.kr/1671093171915FA.png](https://lucas-image.codesquad.kr/1671093171915FA.png)


> 참고. 그래프 방식에 있는 전이 규칙을 표로 만들수도 있다
>

### **2) 집합 표현 방식**

- **알파벳**은 전형적인 유한한 심볼 집합예) ASCII코드, 유니코드, 이진코드 {0, 1}
- **문자열(Strings)** : 알파벳으로 조합해서 만들 수 있는 문자열 집합∑ * 는 문자열 집합을 의미{ 0, 1 } * = { ∊, 0, 1, 00, 01, 10, 11, 000, 001, … }∊는 빈문자열(empty string, 길이가 0인 문자열)
- **언어(Languages)** : 특정 알파벳 집합으로 만들 수 있는 하위 집합예) 0과 1로 이루어져 있고 연속된 두 개의 1을 포함하지 않는 문자열 집합L = { ∊, 0, 1, 00, 01, 10, 11, 000, 001, 010, 011, 100, 101, 111, 0000, … }

### **형식 문법**

언어학자 노엄 촘스키 박사가 정한 형식 문법을 가지는 언어 4개 계층

![https://lucas-image.codesquad.kr/1671092994643formal%20grammar.png](https://lucas-image.codesquad.kr/1671092994643formal%20grammar.png)

대부분 프로그래밍 언어는 제2유형 형태이고, 형식이 강해서 정규 문법으로 표현할 수 있는 제3유형 정규 언어이다.

### **정규표현식 Regular Expression**

정규 언어를 수학적으로 기술하는 방식을 **`정규표현식`**이라고 한다.특정한 언어로 표현하는 규칙을 점검하거나 매치하는 용도로 사용하는 정규표현식을 학습한다.정규표현식 개념이나 문법이 낯설다면, 이메일패턴이나 문자열패턴, 숫자패턴 등을 간단한 정규 문법 - 규칙부터 어떻게 처리할 수 있는지 학습한다.

### **정규표현식 (수학적) 예시**

```
L(01) = {01}
L(01+0) = {01, 0}
L(0(1+0)) = {01, 00}
L(0*) = {∊, 0, 00, 000, 0000, … }
L((0+10)*(∊+1)) = 0과 1로 시작하면서 1이 두 번 연속해서 나오지 않는 모든 문자열
```

### **정규표현식 패턴**

프로그래밍 언어나 자동화를 위해서 자주 사용하는 표현들

```
불리언 or
| (vertical bar) : gray | grey

그룹
( ) 소괄호 : gr(a|e)y

반복
? ( 0 또는 1번 ) : colou?r
* ( 0 또는 반복 ) : go*gle
+ ( 1번 이상 반복) : go+gle
{n} (정확히 n번)
{min, max} (최소 min만큼, 최대 max만큼)

매치
 . (모든 문자와 일치)  :  a.
[ ] (문자 집합 요소중에 하나와 일치)  :  [a-z]
[^] (문자 집합 요소 제외하고 일치)  :  [^b]at
 \ (바로 다음 문자 이스케이프)  :  a\.
```

[정규표현식 패턴 학습 추천 사이트 regex101](https://regex101.com/)

---

### 학습목표

- XML DOM Parser 동작 방식에 대해 학습
- DOM 분석을 위한 기본 동작을 구현

XML은 정형화된 데이터를 표현하는데 많이 사용하는 방식이다. 간단한 구조의 HTML5, PLIST같은 XML문서를 분석해서 DOM구조로 만드는 XML Parser

### 기능목록

- [ ]  AST
- [ ]  Tokenizer
- [ ]  lexer
- [ ]  parser

### 기능요구사항

- XML 데이터를 분석해서 요소 별로 분리하는 DOM Parser 구현
- 예제만 처리하는 파서를 만드는 게 아니라, 일반적인 XML 태그 모두 처리
    - 단 XML 문법에 well-formed 한지 판단은 하지 않고 태그가 닫히지 않았는지 수준에서 구조적인 분석

### 프로그래밍 요구사항

- xmldom이나 유사한 라이브러리, node 모듈 사용 불가. 파싱 처리 외부 라이브러리 사용 불가
- 정규표현식은 token을 추출하고 분석하기 위한 용도(선택사항)
- 전체 문자열 분석을 위해 단계별로 역할 나눠서 처리
- tokenizer, lexer, parser를 처리하는 메서드 각각 구현
- 태그 중첩을 처리하기 위해서는 Stack 동작을 배열을 활용하여 직접 구현
- 만약 태그가 제대로 닫히지 않으면 stringify() 결과는 “올바른 XML 형식이 아닙니다.” 리턴

### 예상결과 및 동작예시

**정상적인 HTML5 형식 XML을 분석한 경우**

```
const str = "<!DOCTYPE html><HTML lang="ko"><BODY><P>BOOST<IMG SRC=\"codesquad.kr\"></IMG><BR/></P></BODY></HTML>";

const dom = XMLParser(str);
console.log(dom.stringfy()); 

{   element: 'HTML',
    attributes: [
        { name : "lang", value : "ko" }
    ]
    children: [
        { element : 'BODY',
            children: [
                { element : 'P',
                    text : 'BOOST', 
                    children: [
                        { element : 'IMG',
                            attributes : [
                                { name : 'SRC', value : 'codesquad.kr'}
                            ]
                        },
                        {   element: 'BR'  }  
                    ]
                }
            ]
        }
    ]
}
```

**잘못된 형식 분석**

```
const str = "<!DOCTYPE html><HTML lang="ko"><BODY></HTML></BODY>";

const dom = XMLParser(str);
console.log(dom.stringify()); 

//ERROR: "올바른 XML 형식이 아닙니다."
```

### 추가 요구 사항

DOM 구조를 생성했으면, DOM 구조를 탐색해서 찾아내는 메소드를 구현할 수 있다

### **1. elementByAttribute 요구사항**

태그의 속성과 값을 비교해서 해당 요소를 찾는 함수를 구현한다.

```
dom.elementByAttribute("lang", value: "ko");
dom.elementByAttribute("id", value: "foo");
```

### **2. elementByTag 요구사항**

태그로 모든 해당 요소를 찾아 배열로 리턴하는 함수를 구현한다.