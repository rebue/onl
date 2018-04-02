package rebue.onl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;

@ServletComponentScan("rebue")
@SpringCloudApplication
public class OnlApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlApplication.class, args);
	}

}
