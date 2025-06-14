package co.com.nequi.usecase.sucursales;

import co.com.nequi.model.sucursal.Sucursal;
import co.com.nequi.model.sucursal.gateways.SucursalRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class SucursalesUseCase {

    //private SucursalRepository sucursalRepository;


    public Mono<Sucursal> getSucursal(String idSucursal){
        return Mono.empty();
    }
    public Mono<List<Sucursal>> getSucursalesByFranquicia(String idFranquicia){
        return Mono.empty();
    }

    public Mono<Sucursal> deleteSucursal(String idsucursal){
        return Mono.empty();
    }
    public Mono<Sucursal> createSucursal(Sucursal sucursal){
        return Mono.empty();
    }
}
