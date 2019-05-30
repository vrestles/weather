package online.vrestlesgroup.weather.Controller;

import online.vrestlesgroup.weather.Data.CitiesWeather;
import online.vrestlesgroup.weather.Service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class WeatherController {

	@GetMapping("/")
	public String weatherForecast(Map<String, String> model) {
		CitiesWeather citiesWeather = new CitiesWeather();
		citiesWeather.setCityWeatherList();
		WeatherService weatherService = new WeatherService();
		weatherService.setWeatherService(citiesWeather);
		weatherService.updateWeather();

		String msc = citiesWeather.getTempInCity("Moscow").toString();
		String spb = citiesWeather.getTempInCity("Saint-Petersburg").toString();
		String tky = citiesWeather.getTempInCity("Tokyo").toString();
		model.put("msc", msc);
		model.put("spb", spb);
		model.put("tky", tky);

		System.out.println(citiesWeather);
		return "weather";
	}
}