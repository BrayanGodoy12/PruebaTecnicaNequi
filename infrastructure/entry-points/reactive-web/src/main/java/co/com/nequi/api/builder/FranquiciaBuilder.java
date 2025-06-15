package co.com.nequi.api.builder;

import co.com.nequi.api.builder.mapper.FranquiciaMapper;
import co.com.nequi.api.commons.dto.request.FranquiciaActualizarRequestDTO;
import co.com.nequi.api.commons.dto.request.FranquiciaRequestDTO;
import co.com.nequi.api.commons.dto.request.SucursalFranquiciaRequestDTO;
import co.com.nequi.api.commons.dto.response.FranquiciaResponseDTO;
import co.com.nequi.model.franquicia.Franquicia;
import co.com.nequi.model.franquicia.valueobject.FranquiciaId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FranquiciaBuilder {

    private final FranquiciaMapper franquiciaMapper;

    public Mono<Franquicia> construirFranquicia(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(FranquiciaRequestDTO.class)
                .map(franquiciaMapper::desdeFranquiciaDTO);
    }

    public Mono<Franquicia> actualizarFranquiciaBuilder(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(FranquiciaActualizarRequestDTO.class)
                .map(franquiciaMapper::desdeFranquiciaActualizarDTO);
    }

    public Mono<FranquiciaId> construirFranquiciaId(ServerRequest serverRequest) {
        return Mono.just(serverRequest.pathVariable("id"))
                .map(s -> new FranquiciaId(UUID.fromString(s)));
    }

    public Mono<FranquiciaResponseDTO> constuirFranquiciaDTOdeEntidad(Franquicia franquicia) {
        return Mono.just(franquicia)
                .map(franquiciaMapper::desdeFranquicia);
    }

    public Mono<Franquicia> agregarSucursalFranquicia(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(SucursalFranquiciaRequestDTO.class)
                .map(franquiciaMapper::desdeFranquciaConSucursalesDTO);
    }
}
