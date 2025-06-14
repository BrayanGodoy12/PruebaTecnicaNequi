package co.com.nequi.api.builder;

import co.com.nequi.api.builder.mapper.FranquiciaMapper;
import co.com.nequi.api.commons.dto.FranquiciaRequestDTO;
import co.com.nequi.api.commons.dto.FranquiciaResponseDTO;
import co.com.nequi.model.franquicia.Franquicia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FranquiciaBuilder {

    private final FranquiciaMapper franquiciaMapper;

    public Mono<Franquicia> construirFranquicia(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(FranquiciaRequestDTO.class)
                .map(franquiciaMapper::desdeFranquiciaDTO);
    }

    public Mono<FranquiciaResponseDTO> constuirFranquiciaDTOdeEntidad(Franquicia franquicia) {
        return Mono.just(franquicia)
                .map(franquiciaMapper::desdeFranquicia);
    }
}
