package co.com.nequi.api.services.sucursal;

import co.com.nequi.api.builder.ProductoBuilder;
import co.com.nequi.api.builder.SucursalBuilder;
import co.com.nequi.api.commons.utils.ResponseUtil;
import co.com.nequi.usecase.sucursales.ActualizarSucursalUseCase;
import co.com.nequi.usecase.sucursales.AgregarProductoSucursalUseCase;
import co.com.nequi.usecase.sucursales.EliminarProductoSucursalUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class SucursalHandler {
    private final ActualizarSucursalUseCase actualizarSucursalUseCase;
    private final AgregarProductoSucursalUseCase agregarProductoSucursalUseCase;
    private final EliminarProductoSucursalUseCase eliminarProductoSucursalUseCase;
    private final SucursalBuilder sucursalBuilder;
    private final ProductoBuilder productoBuilder;


    public Mono<ServerResponse> actualizarSucursal(ServerRequest serverRequest) {
        return sucursalBuilder.actualizarSucursalEntity(serverRequest)
                .flatMap(actualizarSucursalUseCase::actualizarSucursal)
                .flatMap(sucursalBuilder::constuirSucursalResponseDTO)
                .flatMap(ResponseUtil::ok)
                .onErrorResume(ResponseUtil::error);
    }

    public Mono<ServerResponse> agregarProductoSucursal(ServerRequest serverRequest) {
        return sucursalBuilder.agregarProductoSucursal(serverRequest)
                .flatMap(agregarProductoSucursalUseCase::agregarProducto)
                .flatMap(productoBuilder::constuirProductoResponseDTO)
                .flatMap(ResponseUtil::ok)
                .onErrorResume(ResponseUtil::error);
    }

    public Mono<ServerResponse> eliminarProductoSucursal(ServerRequest serverRequest) {
        return productoBuilder.construirProductoId(serverRequest)
                .flatMap(eliminarProductoSucursalUseCase::eliminarProductSucursal)
                .flatMap(ResponseUtil::ok)
                .onErrorResume(ResponseUtil::error);
    }
}
