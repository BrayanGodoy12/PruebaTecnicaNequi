package co.com.nequi.api.builder;

import co.com.nequi.api.builder.mapper.FranquiciaMapper;
import co.com.nequi.api.builder.mapper.SucursalMapper;
import co.com.nequi.api.commons.dto.request.ActualizarSucursalDTO;
import co.com.nequi.api.commons.dto.request.ProductoSucursalRequestDTO;
import co.com.nequi.api.commons.dto.response.SucursalResponseDTO;
import co.com.nequi.model.franquicia.Franquicia;
import co.com.nequi.model.sucursal.Sucursal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class SucursalBuilder {

    private final SucursalMapper sucursalMapper;
    private final FranquiciaMapper franquiciaMapper;

    public Mono<Franquicia> actualizarSucursalEntity(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(ActualizarSucursalDTO.class)
                .map(franquiciaMapper::ActualizarSucursalDTO);
    }

    public Mono<Sucursal> agregarProductoSucursal(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(ProductoSucursalRequestDTO.class)
                .map(sucursalMapper::desdeProductoSucursalDTO);
    }

    public Mono<SucursalResponseDTO> constuirSucursalResponseDTO(Sucursal sucursal) {
        return Mono.just(sucursalMapper.desdeSucursal(sucursal));
    }
}
