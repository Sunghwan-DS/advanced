package jsh.advanced.app.v2;

import jsh.advanced.trace.TraceStatus;
import jsh.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepositoryV2;
    private final HelloTraceV2 trace;

    public void orderItem(String itemId) {

        TraceStatus status = trace.begin("OrderService.orderItem()");
        try {
            orderRepositoryV2.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
