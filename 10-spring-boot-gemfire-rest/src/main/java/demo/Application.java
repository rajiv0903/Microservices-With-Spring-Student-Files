package demo;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import com.gemstone.gemfire.cache.GemFireCache;

import demo.dao.Person;

@SpringBootApplication
@EnableGemfireRepositories
@SuppressWarnings("unused")
public class Application {

	@Bean
	Properties gemfireProperties() {
		Properties gemfireProperties = new Properties();
		gemfireProperties.setProperty("name", "DataGemFireRestApplication");
		gemfireProperties.setProperty("mcast-port", "0");
		gemfireProperties.setProperty("log-level", "config");
		return gemfireProperties;
	}

	@Bean
	CacheFactoryBean gemfireCache() {
		CacheFactoryBean gemfireCache = new CacheFactoryBean();
		gemfireCache.setClose(true);
		gemfireCache.setProperties(gemfireProperties());
		return gemfireCache;
	}

	@Bean
	LocalRegionFactoryBean<String, Person> personRegion(final GemFireCache cache) {
		LocalRegionFactoryBean<String, Person> personRegion = new LocalRegionFactoryBean<>();
		personRegion.setCache(cache);
		personRegion.setClose(false);
		personRegion.setName("person");
		personRegion.setPersistent(false);
		return personRegion;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
