package co.com.nequi.api.services.producto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProductoRouterRest {
    @Bean
    public RouterFunction<ServerResponse> productoRouterFunction(ProductoHandler productoHandler) {
        return route(POST("/api/producto"), productoHandler::actualizarStockProducto);
    }
}
