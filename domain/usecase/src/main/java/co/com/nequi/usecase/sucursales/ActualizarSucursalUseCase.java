package co.com.nequi.usecase.sucursales;

import co.com.nequi.model.sucursal.Sucursal;
import co.com.nequi.model.sucursal.gateways.SucursalRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizarSucursalUseCase {

    private SucursalRepository sucursalRepository;

    public Mono<Sucursal> actualizarSucursal(Sucursal sucursal) {
        return sucursalRepository.updateSucursal(sucursal);
    }

}
