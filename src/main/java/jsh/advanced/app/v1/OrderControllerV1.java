package jsh.advanced.app.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderServiceV1;

    @GetMapping("/v1/request")
    public String request(String itemId) {
        orderServiceV1.orderItem(itemId);
        return "ok";
    }
}
