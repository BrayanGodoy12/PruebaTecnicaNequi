package co.com.nequi.api.services.sucursal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SucursalRouterRest {
    @Bean
    public RouterFunction<ServerResponse> sucursalRouterFunction(SucursalHandler sucursalHandler) {
        return route(PUT("/api/sucursal"), sucursalHandler::actualizarSucursal)
                .andRoute(POST("/api/sucursal/producto"), sucursalHandler::agregarProductoSucursal)
                .and(route(DELETE("/api/sucursal/producto/{id}"), sucursalHandler::eliminarProductoSucursal));
    }
}
