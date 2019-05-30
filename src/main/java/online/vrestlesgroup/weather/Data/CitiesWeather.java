package online.vrestlesgroup.weather.Data;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class CitiesWeather {
	private List<CityWeather> cityWeatherList;

	public CitiesWeather() {
		cityWeatherList = new LinkedList<>();
	}

	public List<CityWeather> getCityWeatherList() {
		return this.cityWeatherList;
	}

	public void setCityWeatherList() {
		CityWeather msc = new CityWeather(55.75, 37.62, "Moscow");
		CityWeather spb = new CityWeather(59.94, 30.31, "Saint-Petersburg");
		CityWeather tky = new CityWeather(35.68, 139.77, "Tokyo");

		this.cityWeatherList.add(msc);
		this.cityWeatherList.add(spb);
		this.cityWeatherList.add(tky);
	}

	public Integer getTempInCity(String city) {
		for (CityWeather cityWeather : this.cityWeatherList) {
			if (cityWeather.getCity().equals(city)) {
				return cityWeather.getTemp();
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (CityWeather weather : this.cityWeatherList) {
			result.append(weather.toString());
			result.append('\n');
		}
		return result.toString();
	}
}
