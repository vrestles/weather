package online.vrestlesgroup.weather.Data;

public class CityWeather {
	private String city;
	private Double lat;
	private Double lon;
	private Integer temp;
	private final String lang = "ru_RU";
	private final String apiURL = "https://api.weather.yandex.ru/v1/forecast?";

	public CityWeather() {
	}

	public CityWeather(Double lat, Double lon, String city) {
		this.city = city;
		this.lat = lat;
		this.lon = lon;
	}

	public String createURL() {
		return apiURL
				+ "lat=" + this.getLat()
				+ "&lon=" + this.getLon()
				+ "&lang=" + lang;
	}

	public CityWeather getCityWeather() {
		return this;
	}

	public Double getLat() {
		return lat;
	}

	public Double getLon() {
		return lon;
	}

	public String getLang() {
		return lang;
	}

	public String getCity() { return city; }

	public Integer getTemp() {
		return temp;
	}

	public void setTemp(Integer temp) {
		this.temp = temp;
	}

	@Override
	public String toString() {
		return "Temperature in " + this.city + " is " + this.temp;
	}
}
