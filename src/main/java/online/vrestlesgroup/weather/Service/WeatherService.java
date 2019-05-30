package online.vrestlesgroup.weather.Service;

import online.vrestlesgroup.weather.Data.CitiesWeather;
import online.vrestlesgroup.weather.Data.CityWeather;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;

@Service
public class WeatherService {
	private CitiesWeather citiesWeatherList;

	public WeatherService() {
	}

	public void setWeatherService(CitiesWeather citiesWeatherList) {
		this.citiesWeatherList = citiesWeatherList;
	}

	public CitiesWeather getWeatherService() {
		return this.citiesWeatherList;
	}

	public void updateWeather() {

		for (CityWeather weather : this.citiesWeatherList.getCityWeatherList()) {
			String urlString = weather.createURL();
			String result = null;
			try {
				URL url = new URL(urlString);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.setRequestProperty("X-Yandex-API-Key", "5b785b61-10c7-4a65-b091-bf41d776a0f6");
				connection.connect();
				if (connection.getResponseCode()/100 == 2) {
					BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					result = reader.lines().collect(Collectors.joining());
					weather.setTemp(getFactData(result, "temp"));
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	 private Integer getFactData(String string, String value) {
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = null;
		Integer result = null;
		try {
			JSONObject json = (JSONObject) parser.parse(string);
			jsonObj = (JSONObject) json.get("fact");
			result = Integer.parseInt(jsonObj.get(value).toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}
