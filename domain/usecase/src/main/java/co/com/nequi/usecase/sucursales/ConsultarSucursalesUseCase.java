package co.com.nequi.usecase.sucursales;

import co.com.nequi.model.franquicia.valueobject.FranquiciaId;
import co.com.nequi.model.sucursal.Sucursal;
import co.com.nequi.model.sucursal.gateways.SucursalRepository;
import co.com.nequi.model.sucursal.valueobject.SucursalId;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class ConsultarSucursalesUseCase {

    //private final SucursalRepository sucursalRepository;

    public Mono<Sucursal> getSucursal(SucursalId sucursal){
        return Mono.empty();
    }
    public Mono<List<Sucursal>> getSucursalesByFranquicia(FranquiciaId franquicia){
        return Mono.empty();
    }

}
