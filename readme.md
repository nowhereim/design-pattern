## 🗂️ Observer Pattern
<details>
<summary> view </summary>

# 옵저버 패턴 (Observer Design Pattern)

## 📖 정의

**옵저버 패턴**은 객체의 상태 변화를 구독자에게 자동으로 통지하는 디자인 패턴이다. 이 패턴은 발행자(Subject)가 상태 변경 시 구독자(Observer)에게 알림을 전달하여, 상태 변화에 반응하는 동작을 구현한다.

### 예시
유튜브 채널 구독처럼, 구독자는 채널의 새로운 영상(상태 변화)을 알림으로 받아보게 된다.

## 🔧 주요 구성 요소

1. **발행자(Subject)**: 상태 변화를 감지하고 구독자에게 알림을 전달.
2. **구독자(Observer)**: 알림을 받고 그에 따른 동작을 수행.

### 예시 코드 (Java)
```java
// Subject 인터페이스
interface ISubject {
    void addObserver(IObserver o);
    void removeObserver(IObserver o);
    void notifyObservers();
}

// 구체적 발행자
class ConcreteSubject implements ISubject {
    List<IObserver> observers = new ArrayList<>();
    
    public void addObserver(IObserver o) {
        observers.add(o);
    }
    
    public void removeObserver(IObserver o) {
        observers.remove(o);
    }
    
    public void notifyObservers() {
        for (IObserver o : observers) {
            o.update();
        }
    }
}

// Observer 인터페이스
interface IObserver {
    void update();
}

// ObserverA 클래스
class ObserverA implements IObserver {
    public void update() {
        System.out.println("ObserverA가 알림을 받았습니다.");
    }
}

// ObserverB 클래스
class ObserverB implements IObserver {
    public void update() {
        System.out.println("ObserverB가 알림을 받았습니다.");
    }
}
```
🔄 플로우

	1.	발행자(Subject)가 상태를 변경.
	2.	등록된 구독자(Observer)에게 상태 변경을 알림.
	3.	구독자는 알림을 받고 적절한 동작을 수행.

- 복잡하고 확장이 많이 되야할 경우는 반대로 옵저버가 필요한 속성을 요청할 수 있다. 

🔍 패턴 사용 사례

	•	java.util.Observer 및 Observable 클래스 ( java 9 이후 Deprecated )
	•	RxJS의 Observable은 옵저버 패턴을 사용해 비동기 데이터 스트림을 처리.
    •       이외 다양한 Listener, Event Handler 내부에서 사용.

📊 장점

	•	상태 변경을 실시간으로 감지하여 효율적 반응.
	•	발행자와 구독자 간의 느슨한 결합으로 확장성 제공.

⚠️ 단점

	•	알림을 받는 순서를 제어할 수 없음.
	•	구독자를 관리하지 않으면 메모리 누수 가능성.
	•	복잡도가 올라갈 경우 디버깅 리소스 증가.
</details>

## 🗂️ Adapter & Facade Pattern
<details>
<summary> view</summary>

# 어댑터 패턴 (Adapter Design Pattern)

## 📖 정의

**어댑터 패턴**은 서로 다른 인터페이스를 가진 클래스들이 함께 동작할 수 있도록 중간에 어댑터 클래스를 끼워 맞추는 디자인 패턴이다. 클라이언트가 기대하는 인터페이스와 기존의 클래스(어댑티)가 일치하지 않을 때, 어댑터가 중재하여 둘을 호환시킨다.

### 예시
미국형 전원 플러그를 유럽형 소켓에 맞추기 위해 전기 어댑터를 사용하는 것과 같다.

## 🔧 주요 구성 요소

1. **타깃(Target)**: 클라이언트가 사용하려는 인터페이스.
2. **어댑티(Adaptee)**: 기존 클래스, 클라이언트가 바로 사용할 수 없는 객체.
3. **어댑터(Adapter)**: 타깃 인터페이스를 구현하고, 내부에서 어댑티의 기능을 호출하여 변환.

### 예시 코드 (Java)
```java
// 타깃 인터페이스
interface Target {
    void request();
}

// 어댑티 클래스
class Adaptee {
    public void specificRequest() {
        System.out.println("어댑티의 요청 처리");
    }
}

// 어댑터 클래스
class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest(); // 어댑티의 메서드를 호출
    }
}
```
## 🔄 플로우
```
1. 클라이언트는 타깃 인터페이스를 통해 메서드 호출.
2. 어댑터는 타깃 인터페이스를 구현하여 어댑티의 메서드를 호출.
3. 어댑티의 기능을 변환하여 클라이언트에게 제공.
```

## 🔍 패턴 사용 사례
```
•	자바 IO 스트림에서 InputStreamReader는 바이트 스트림을 문자 스트림으로 변환하는 어댑터 패턴을 사용.
•	외부 라이브러리의 API가 클라이언트 코드와 맞지 않을 때 어댑터 사용.
```

## 📊 장점
```
•	기존 코드를 수정하지 않고 새 시스템과 통합 가능.
•	클라이언트와 어댑티 간의 결합도를 낮출 수 있음.
```

## ⚠️ 단점
```
•	어댑터 클래스가 많아지면 코드 복잡도 증가.
•	어댑터 클래스가 많아지면 유지보수가 어려워질 수 있음.
```

# 파사드 패턴 (Facade Design Pattern)

## 📖 정의

파사드 패턴은 복잡한 서브시스템에 대한 간단한 인터페이스를 제공하여, 클라이언트가 서브시스템의 내부 세부 사항을 몰라도 쉽게 사용할 수 있게 하는 디자인 패턴이다. 여러 복잡한 클래스나 메서드를 하나의 간단한 인터페이스로 감싸서 사용을 단순화한다.

예시

호텔의 리셉션 데스크가 여러 부서(청소, 룸 서비스, 안내)를 대신하여 요청을 처리해 주는 것과 같다.

## 🔧 주요 구성 요소

1.	파사드(Facade): 클라이언트가 사용하기 위한 간단한 인터페이스를 제공.
2.	서브시스템(Subsystems): 파사드가 간단한 인터페이스로 감싸고 있는 실제 시스템의 복잡한 구성 요소들.

예시 코드 (Java)
```java
class Amplifier {
    public void on() { System.out.println("Amplifier on"); }
    public void off() { System.out.println("Amplifier off"); }
}

class DVDPlayer {
    public void play() { System.out.println("DVD playing"); }
    public void stop() { System.out.println("DVD stopped"); }
}

// 파사드 클래스
class HomeTheaterFacade {
    private Amplifier amp;
    private DVDPlayer dvd;

    public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd) {
        this.amp = amp;
        this.dvd = dvd;
    }

    public void watchMovie() {
        amp.on();
        dvd.play();
    }

    public void endMovie() {
        dvd.stop();
        amp.off();
    }
}
```
## 🔄 플로우
```
1. 클라이언트는 파사드의 간단한 메서드를 호출.
2. 파사드는 여러 서브시스템의 복잡한 메서드들을 호출하여 동작을 처리.
3. 클라이언트는 서브시스템의 내부 동작을 알 필요 없이 간단한 인터페이스만 사용.
```
## 🔍 패턴 사용 사례
```
•	스프링 프레임워크에서 JdbcTemplate은 복잡한 JDBC 코드들을 감싸 간단한 인터페이스로 제공.
•	WAS에서 클라이언트 요청을 처리하기 위해 여러 서브시스템을 사용하는 경우 파사드 패턴 사용.
```
## 📊 장점
```
•	복잡한 서브시스템을 간단하게 사용할 수 있어 클라이언트 코드를 단순화.
•	서브시스템과 클라이언트 간의 결합도를 낮춰 유지보수성 향상.
```
## ⚠️ 단점
```
•	지나치게 단순화 하려다 보면 파사드 클래스가 지나치게 비대해질 수 있음을 주의.
```

</details>