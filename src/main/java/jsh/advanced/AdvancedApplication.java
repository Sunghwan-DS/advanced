package jsh.advanced;

import jsh.proxy.config.AppV2Config;
import jsh.proxy.config.v1_proxy.InterfaceProxyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({InterfaceProxyConfig.class, AppV2Config.class})
@SpringBootApplication(scanBasePackages = "jsh.proxy.app")
public class AdvancedApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvancedApplication.class, args);
    }

}
