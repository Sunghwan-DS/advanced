package jsh.advanced.app.v3;

import jsh.advanced.trace.TraceStatus;
import jsh.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final OrderServiceV3 orderServiceV3;
    private final HelloTraceV2 trace;

    @GetMapping("/v3/request")
    public String request(String itemId) {

        TraceStatus status = trace.begin("OrderController.request()");
        try {
            orderServiceV3.orderItem(status.getTraceId(), itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
