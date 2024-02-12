package jsh.proxy.config.v1_proxy;

import jsh.proxy.app.v1.OrderControllerV1;
import jsh.proxy.app.v1.OrderControllerV1Impl;
import jsh.proxy.app.v1.OrderRepositoryV1;
import jsh.proxy.app.v1.OrderRepositoryV1Impl;
import jsh.proxy.app.v1.OrderServiceV1;
import jsh.proxy.app.v1.OrderServiceV1Impl;
import jsh.proxy.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import jsh.proxy.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import jsh.proxy.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import jsh.proxy.trace.logtrace.LogTrace;
import jsh.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {

    @Bean
    public OrderControllerV1 orderController(LogTrace logTrace) {
        OrderControllerV1Impl controllerImpl = new OrderControllerV1Impl(orderService(logTrace));
        return new OrderControllerInterfaceProxy(controllerImpl, logTrace);
    }

    @Bean
    public OrderServiceV1 orderService(LogTrace logTrace) {
        OrderServiceV1Impl serviceImpl = new OrderServiceV1Impl(orderRepository(logTrace));
        return new OrderServiceInterfaceProxy(serviceImpl, logTrace);
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace) {
        OrderRepositoryV1Impl repositoryImpl = new OrderRepositoryV1Impl();
        return new OrderRepositoryInterfaceProxy(repositoryImpl, logTrace);
    }
}
