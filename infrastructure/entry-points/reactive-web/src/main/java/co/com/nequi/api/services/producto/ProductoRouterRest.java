package co.com.nequi.api.services.producto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProductoRouterRest {
    @Bean
    public RouterFunction<ServerResponse> productoRouterFunction(ProductoHandler productoHandler) {
        return route(GET("/api/producto/{idProducto}"), productoHandler::listenGETUseCase)
                .andRoute(POST("/api/producto"), productoHandler::listenPOSTUseCase)
                .and(route(PUT("/api/producto"), productoHandler::listenGETOtherUseCase))
                .and(route(DELETE("/api/producto"), productoHandler::listenGETOtherUseCase));
    }
}
