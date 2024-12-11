package ua.comparus.getuserstesttask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({DataSourceConfig.class})
public class GetUsersTestTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetUsersTestTaskApplication.class, args);
    }

}
