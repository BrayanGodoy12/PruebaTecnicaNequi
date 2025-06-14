package co.com.nequi.api.builder;

import co.com.nequi.api.builder.mapper.ProductoMapper;
import co.com.nequi.api.commons.dto.request.CrearProductoRequestDTO;
import co.com.nequi.api.commons.dto.response.ProductoResponseDTO;
import co.com.nequi.model.producto.Producto;
import co.com.nequi.model.producto.valueobject.ProductoId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductoBuilder {
    private final ProductoMapper productoMapper;

    public Mono<Producto> construirProducto(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(CrearProductoRequestDTO.class)
                .map(productoMapper::productoDTOToProducto);
    }

    public Mono<ProductoResponseDTO> constuirProductoResponseDTO(Producto producto) {
        return Mono.just(productoMapper.productoToProductoDTO(producto));
    }

    public Mono<ProductoId> construirProductoId(ServerRequest serverRequest) {
        return Mono.just(serverRequest.pathVariable("id"))
                .map(ProductoId::new);
    }

}
