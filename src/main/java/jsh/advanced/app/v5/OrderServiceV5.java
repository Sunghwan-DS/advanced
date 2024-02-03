package jsh.advanced.app.v5;

import jsh.advanced.trace.logtrace.LogTrace;
import jsh.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepositoryV5;
    private final LogTrace trace;

    public void orderItem(String itemId) {

        AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
            @Override
            protected Void call() {
                orderRepositoryV5.save(itemId);
                return null;
            }
        };
        template.execute("OrderService.orderItem()");
    }
}
