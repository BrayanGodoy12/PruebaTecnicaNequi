package co.com.nequi.api.services.sucursal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SucursalRouterRest {
    @Bean
    public RouterFunction<ServerResponse> sucursalRouterFunction(SucursalHandler sucursalHandler) {
        return route(GET("/api/usecase/path"), sucursalHandler::listenGETUseCase)
                .andRoute(POST("/api/usecase/otherpath"), sucursalHandler::listenPOSTUseCase)
                .and(route(GET("/api/otherusercase/path"), sucursalHandler::listenGETOtherUseCase));
    }
}
