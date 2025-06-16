package co.com.nequi.api.commons.utils;

import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

public class ResponseUtil {

     public static Mono<ServerResponse> ok(Object body) {
        return ServerResponse.ok()
                .header("Content-Type", "application/json")
                .bodyValue(body);
    }

     public static Mono<ServerResponse> error(Throwable ex) {
        return ServerResponse.status(500)
                .header("Content-Type", "application/json")
                .bodyValue(Map.of("error", ex.getMessage()));
    }

}
