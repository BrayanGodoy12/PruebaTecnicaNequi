package co.com.nequi.api.services.franquicia;

import co.com.nequi.api.builder.FranquiciaBuilder;
import co.com.nequi.usecase.franquicias.AgregarFranquiciaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FranquiciaHandler {
    private final FranquiciaBuilder franquiciaBuilder;
    private final AgregarFranquiciaUseCase agregarFranquiciaUseCase;

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        // useCase.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> agregarFranquicia(ServerRequest serverRequest) {
        return franquiciaBuilder.construirFranquicia(serverRequest)
                .flatMap(agregarFranquiciaUseCase::crearFranquicia)
                .flatMap(franquiciaBuilder::constuirFranquiciaDTOdeEntidad)
                .flatMap(franquiciaResponseDTO ->
                        ServerResponse.ok().bodyValue(franquiciaResponseDTO));

    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // useCase.logic();
        return ServerResponse.ok().bodyValue("");
    }
}
