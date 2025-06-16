package co.com.nequi.api.services.franquicia;

import co.com.nequi.api.builder.FranquiciaBuilder;
import co.com.nequi.api.builder.SucursalBuilder;
import co.com.nequi.api.commons.utils.ResponseUtil;
import co.com.nequi.usecase.franquicias.ActualizarFranquiciaUseCase;
import co.com.nequi.usecase.franquicias.AgregarFranquiciaUseCase;
import co.com.nequi.usecase.franquicias.AgregarSucursalFranquiciaUseCase;
import co.com.nequi.usecase.franquicias.ConsultarMayorProductoSucursalUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class FranquiciaHandler {
    private final FranquiciaBuilder franquiciaBuilder;
    private final SucursalBuilder sucursalBuilder;
    private final AgregarFranquiciaUseCase agregarFranquiciaUseCase;
    private final ActualizarFranquiciaUseCase actualizarFranquiciaUseCase;
    private final AgregarSucursalFranquiciaUseCase agregarSucursalFranquiciaUseCase;
    private final ConsultarMayorProductoSucursalUseCase consultarMayorProductoSucursalUseCase;


    public Mono<ServerResponse> agregarFranquicia(ServerRequest serverRequest) {
        return franquiciaBuilder.construirFranquicia(serverRequest)
                .flatMap(agregarFranquiciaUseCase::crearFranquicia)
                .flatMap(franquiciaBuilder::constuirFranquiciaDTOdeEntidad)
                .flatMap(ResponseUtil::ok)
                .onErrorResume(ResponseUtil::error);
    }

    public Mono<ServerResponse> actualizarFranquicia(ServerRequest serverRequest) {
        return franquiciaBuilder.actualizarFranquiciaBuilder(serverRequest)
                .flatMap(actualizarFranquiciaUseCase::actualizarFranquicia)
                .flatMap(franquiciaBuilder::constuirFranquiciaDTOdeEntidad)
                .flatMap(ResponseUtil::ok)
                .onErrorResume(ResponseUtil::error);
    }

    public Mono<ServerResponse> agregarSucursalFranquicia(ServerRequest serverRequest) {
        return franquiciaBuilder.agregarSucursalFranquicia(serverRequest)
                .flatMap(agregarSucursalFranquiciaUseCase::agregarSucursalFranquicia)
                .flatMap(sucursalBuilder::constuirSucursalResponseDTO)
                .flatMap(ResponseUtil::ok)
                .onErrorResume(ResponseUtil::error);
    }

    public Mono<ServerResponse> consultarMayorProductoPorSucursal(ServerRequest serverRequest) {
        return franquiciaBuilder.construirFranquiciaId(serverRequest)
                .flatMap(consultarMayorProductoSucursalUseCase::consultarMayorProductoSucursal)
                .flatMap(franquiciaBuilder::constuirFranquiciaDTOdeEntidad)
                .flatMap(ResponseUtil::ok)
                .onErrorResume(ResponseUtil::error);
    }


}
