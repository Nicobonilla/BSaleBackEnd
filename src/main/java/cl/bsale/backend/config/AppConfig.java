package cl.bsale.backend.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan("cl.bsale.backend")
public class AppConfig {
	
	@Autowired
	Environment enviroment;
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		
		driverManagerDataSource.setDriverClassName(enviroment.getProperty("driver"));
		driverManagerDataSource.setUsername(enviroment.getProperty("dusername"));
		driverManagerDataSource.setPassword(enviroment.getProperty("dpassword"));
		driverManagerDataSource.setUrl(enviroment.getProperty("durl"));
		
		return driverManagerDataSource;
	}
	
}

