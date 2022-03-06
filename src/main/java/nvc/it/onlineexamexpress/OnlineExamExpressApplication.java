package nvc.it.onlineexamexpress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class OnlineExamExpressApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineExamExpressApplication.class, args);
	}

}
