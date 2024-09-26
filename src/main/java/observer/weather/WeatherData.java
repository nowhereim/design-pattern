package observer;
import java.util.ArrayList;
import java.util.List;


/**
 * 옵저버를 리스트로 담는다.  ( 옵저버 될 객체들 추가, 삭제 가 가능해짐 )
 * 웨더데이터는 옵저버를 등록, 삭제, 알림을 하는 메소드를 가진다.
 * 생성자를 이용해 옵저버 리스트를 초기화한다.
 * 옵저버들을 업데이트하는 메소드 생성
 * 측정값 변경 메소드 생성
 * 측정값 셋팅 후 측정값 변경 메소드 호출 ( 옵저버들에게 알림 )
 * 나머지는 게터
 */
public class WeatherData implements Subject {
	private final List<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {
		observers = new ArrayList<Observer>();
		System.out.println("\"찍어봐요?\" = " + "찍어봐요?");
	}

	public void registerObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(temperature, humidity, pressure);
		}
	}

	public void measurementsChanged() {
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}

}
