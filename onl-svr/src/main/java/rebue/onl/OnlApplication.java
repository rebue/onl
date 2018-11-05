package rebue.onl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@ServletComponentScan("rebue")
@SpringCloudApplication
@EnableFeignClients(basePackages = { "rebue.prm.svr.feign", "rebue.suc.svr.feign" })
public class OnlApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlApplication.class, args);
	}

}
