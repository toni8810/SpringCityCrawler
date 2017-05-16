package spring.city.crawler;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import spring.city.crawler.domain.City;
import spring.city.crawler.repository.CityRepository;

@SpringBootApplication
public class SpringCityCrawlerApplication implements CommandLineRunner {
	
	@Autowired
	private CityRepository cityRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringCityCrawlerApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		List<City> cities = new ArrayList<>();
		HtmlUnitDriver driver = new HtmlUnitDriver(false);
		driver.get("http://www.lovemytown.co.uk/Populations/TownsTable3.asp");
		WebElement tbody = driver.findElement(By.xpath(".//*[@id='mainContent']/table/tbody"));
		List<WebElement> trs = tbody.findElements(By.tagName("tr"));
		for (WebElement tr : trs) {
			cities.add(new City(tr.findElements(By.tagName("td")).get(1).getText()));
		}
		driver.close();
		driver.quit();
		cityRepository.save(cities);
	}
}
