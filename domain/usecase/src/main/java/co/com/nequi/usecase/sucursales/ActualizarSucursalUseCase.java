package co.com.nequi.usecase.sucursales;

import co.com.nequi.model.franquicia.Franquicia;
import co.com.nequi.model.sucursal.Sucursal;
import co.com.nequi.model.sucursal.gateways.SucursalRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizarSucursalUseCase {

    private final SucursalRepository sucursalRepository;

    public Mono<Sucursal> actualizarSucursal(Franquicia franquicia) {
        return sucursalRepository.updateSucursal(franquicia);
    }

}
