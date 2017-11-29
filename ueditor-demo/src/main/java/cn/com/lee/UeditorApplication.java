package cn.com.lee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Guoqing
 * @date 2017-11-29
 *
 */
@RestController
@SpringBootApplication
public class UeditorApplication {
	
private static final Logger LOGGER = LoggerFactory.getLogger(UeditorApplication.class);
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(UeditorApplication.class);
        application.run(args);
        LOGGER.info("Ueditor application started!!!");
	}

}
