package jsh.advanced.app.v2;

import jsh.advanced.trace.TraceId;
import jsh.advanced.trace.TraceStatus;
import jsh.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepositoryV2;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId) {

        TraceStatus status = trace.beginSync(traceId, "OrderService.orderItem()");
        try {
            orderRepositoryV2.save(status.getTraceId(), itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
