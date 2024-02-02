package jsh.advanced.app.v4;

import jsh.advanced.trace.TraceStatus;
import jsh.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepositoryV4;
    private final LogTrace trace;

    public void orderItem(String itemId) {

        TraceStatus status = trace.begin("OrderService.orderItem()");
        try {
            orderRepositoryV4.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
