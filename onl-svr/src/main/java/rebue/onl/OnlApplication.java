package rebue.onl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@ServletComponentScan("rebue")
@SpringCloudApplication
@EnableFeignClients(basePackages = { "rebue.prm.svr.feign", "rebue.ibr.svr.feign", "rebue.ord.svr.feign",
        "rebue.suc.svr.feign", "rebue.slr.svr.feign", "rebue.prd.svr.feign" })
public class OnlApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlApplication.class, args);
    }

}
