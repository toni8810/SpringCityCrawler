package spring.city.crawler.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import spring.city.crawler.domain.City;

public interface CityRepository extends MongoRepository<City, String> {

}
