package observer.weather.display;

import observer.weather.DisplayElement;
import observer.weather.Observer;
import observer.weather.WeatherData;

/**
 * 온도와 습도를 표시하는 디스플레이
 * Observer 인터페이스를 구현하고, WeatherData 객체에 등록한다.
 * 디스플레이를 업데이트하면, 온도와 습도를 출력한다.
 * DisplayElement는 디스플레이 메소드를 전부 디스플레이별로 가지고있다고 가정하고 생성.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	private final WeatherData weatherData;
	
	public CurrentConditionsDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	public void update(float temperature, float humidity, float pressure) {
//		this.temperature = temperature;
//		this.humidity = humidity;
		this.temperature = weatherData.getTemperature();
		this.humidity = weatherData.getHumidity();
		//이런식으로 하면 필요한것만 가져올수있음
		display();
	}
	
	public void display() {
		System.out.println("Current conditions: " + temperature 
			+ "F degrees and " + humidity + "% humidity");
	}
}
