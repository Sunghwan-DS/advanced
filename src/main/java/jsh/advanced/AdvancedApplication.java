package jsh.advanced;

import jsh.proxy.config.v3_proxyfactory.ProxyFactoryConfigV1;
import jsh.proxy.config.v3_proxyfactory.ProxyFactoryConfigV2;
import jsh.proxy.trace.logtrace.LogTrace;
import jsh.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import({ProxyFactoryConfigV1.class, ProxyFactoryConfigV2.class})
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
