package co.com.nequi.usecase.franquicias;

import co.com.nequi.model.franquicia.Franquicia;
import co.com.nequi.model.franquicia.gateways.FranquiciaRepository;
import co.com.nequi.model.sucursal.Sucursal;
import co.com.nequi.model.sucursal.gateways.SucursalRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AgregarSucursalFranquiciaUseCase {
    private final SucursalRepository sucursalRepository;

    public Mono<Sucursal> agregarSucursalFranquicia(Franquicia franquicia) {
        return sucursalRepository.createSucursal(franquicia);
    }
}
