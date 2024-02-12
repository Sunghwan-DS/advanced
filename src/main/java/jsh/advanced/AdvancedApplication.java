package jsh.advanced;

import jsh.proxy.config.v5_autoproxy.AutoProxyConfig;
import jsh.proxy.trace.logtrace.LogTrace;
import jsh.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(AutoProxyConfig.class)
@SpringBootApplication(scanBasePackages = "jsh.proxy.app")
public class AdvancedApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvancedApplication.class, args);
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }

}
