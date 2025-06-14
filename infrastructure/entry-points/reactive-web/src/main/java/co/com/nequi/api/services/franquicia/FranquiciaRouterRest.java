package co.com.nequi.api.services.franquicia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FranquiciaRouterRest {
    @Bean
    public RouterFunction<ServerResponse> franquiciaRouterFunction(FranquiciaHandler franquiciaHandler) {
        return route(GET("/api/franquicia"), franquiciaHandler::agregarFranquicia)
                .andRoute(POST("/api/usecase/otherpath"), franquiciaHandler::listenPOSTUseCase)
                .and(route(GET("/api/otherusercase/path"), franquiciaHandler::listenGETOtherUseCase));
    }
}
