package jsh.advanced.app.v5;

import jsh.advanced.trace.callback.TraceTemplate;
import jsh.advanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepositoryV5;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
        this.orderRepositoryV5 = orderRepository;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {

        template.execute("OrderService.orderItem()", () -> {
            orderRepositoryV5.save(itemId);
            return null;
        });
    }
}
