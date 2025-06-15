package co.com.nequi.api.builder;

import co.com.nequi.api.builder.mapper.ProductoMapper;
import co.com.nequi.api.builder.mapper.SucursalMapper;
import co.com.nequi.api.commons.dto.request.ActualizarProductoRequestDTO;
import co.com.nequi.api.commons.dto.response.ProductoResponseDTO;
import co.com.nequi.model.producto.Producto;
import co.com.nequi.model.producto.valueobject.ProductoId;
import co.com.nequi.model.sucursal.Sucursal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductoBuilder {
    private final ProductoMapper productoMapper;
    private final SucursalMapper sucursalMapper;

    public Mono<Sucursal> construirProducto(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(ActualizarProductoRequestDTO.class)
                .map(sucursalMapper::actualizarProductoSucursal);
    }

    public Mono<ProductoResponseDTO> constuirProductoResponseDTO(Producto producto) {
        return Mono.just(productoMapper.productoToProductoDTO(producto));
    }

    public Mono<ProductoId> construirProductoId(ServerRequest serverRequest) {
        return Mono.just(serverRequest.pathVariable("id"))
                .map(s -> new ProductoId(UUID.fromString(s)));
    }

}
