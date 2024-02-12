package jsh.proxy.config.v6_aop;

import jsh.proxy.config.AppV1Config;
import jsh.proxy.config.AppV2Config;
import jsh.proxy.config.v6_aop.aspect.LogTraceAspect;
import jsh.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class AopConfig {

    @Bean
    public LogTraceAspect logTraceAspect(LogTrace logTrace) {
        return new LogTraceAspect(logTrace);
    }
}
