package co.com.nequi.api.services.franquicia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FranquiciaRouterRest {
    @Bean
    public RouterFunction<ServerResponse> franquiciaRouterFunction(FranquiciaHandler franquiciaHandler) {
        return route(POST("/api/franquicia"), franquiciaHandler::agregarFranquicia)
                .andRoute(PUT("/api/franquicia"), franquiciaHandler::actualizarFranquicia)
                .andRoute(POST("/api/franquicia/sucursal"), franquiciaHandler::agregarSucursalFranquicia)
                .and(route(GET("/api/franquicia/mayor-producto/{id}"), franquiciaHandler::consultarMayorProductoPorSucursal));
    }
}
