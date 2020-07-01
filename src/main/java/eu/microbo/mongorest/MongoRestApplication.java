package eu.microbo.mongorest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@EnableSwagger2WebMvc
@SpringBootApplication
@Import(SpringDataRestConfiguration.class)
public class MongoRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoRestApplication.class, args);
    }

}
