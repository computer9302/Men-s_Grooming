package authorization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.logging.logback.LogbackLoggingSystem;

@SpringBootApplication
public class Application {
	
	private static final Logger logger = LoggerFactory.getLogger(LogbackLoggingSystem.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("log Example {}", LogbackLoggingSystem.class.getSimpleName());
		SpringApplication.run(Application.class, args);
	}

}
