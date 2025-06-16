package co.com.nequi.api.services.producto;

import co.com.nequi.api.builder.ProductoBuilder;
import co.com.nequi.api.commons.utils.ResponseUtil;
import co.com.nequi.usecase.productos.ActualizarProductoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductoHandler {
    private final ActualizarProductoUseCase actualizarProductoUseCase;
    private final ProductoBuilder productoBuilder;

    public Mono<ServerResponse> actualizarStockProducto(ServerRequest serverRequest) {
        return productoBuilder.construirProducto(serverRequest)
                .flatMap(actualizarProductoUseCase::actualizarStockProducto)
                .flatMap(productoBuilder::constuirProductoResponseDTO)
                .flatMap(ResponseUtil::ok)
                .onErrorResume(ResponseUtil::error);
    }


}
