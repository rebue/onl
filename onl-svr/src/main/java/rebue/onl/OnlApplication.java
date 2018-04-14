package rebue.onl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ServletComponentScan("rebue")
@SpringCloudApplication
public class OnlApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlApplication.class, args);
	}

}
