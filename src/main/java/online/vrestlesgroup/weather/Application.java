package online.vrestlesgroup.weather;

import online.vrestlesgroup.weather.Data.CitiesWeather;
import online.vrestlesgroup.weather.Service.WeatherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		/*
		CitiesWeather citiesWeatherList = context.getBean(CitiesWeather.class);
		citiesWeatherList.setCityWeatherList();
		WeatherService weatherService = context.getBean(WeatherService.class);
		weatherService.setWeatherService(citiesWeatherList);
		weatherService.updateWeather();
		System.out.println(citiesWeatherList);
		*/
	}

}