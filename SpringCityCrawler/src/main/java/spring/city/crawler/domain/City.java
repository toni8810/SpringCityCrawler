package spring.city.crawler.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="city_names")
public class City {
	
	private String name;

	public City(String name) {
		this.name = name;
	}
	public City() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "City [name=" + name + "]";
	}
	
	
	
	
}
