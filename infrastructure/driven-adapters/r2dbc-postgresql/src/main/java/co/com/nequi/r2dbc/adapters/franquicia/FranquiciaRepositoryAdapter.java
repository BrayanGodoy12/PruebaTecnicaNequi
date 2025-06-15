package co.com.nequi.r2dbc.adapters.franquicia;

import co.com.nequi.model.commons.BusinessException;
import co.com.nequi.model.commons.message.BusinessErrorMessage;
import co.com.nequi.model.franquicia.Franquicia;
import co.com.nequi.model.franquicia.gateways.FranquiciaRepository;
import co.com.nequi.model.franquicia.valueobject.FranquiciaId;
import co.com.nequi.model.producto.Producto;
import co.com.nequi.model.sucursal.Sucursal;
import co.com.nequi.r2dbc.adapters.franquicia.data.FranquiciaData;
import co.com.nequi.r2dbc.adapters.franquicia.data.SucursalProductosData;
import co.com.nequi.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class FranquiciaRepositoryAdapter extends ReactiveAdapterOperations<
        Franquicia, FranquiciaData, UUID, FranquiciaDataRepository
        > implements FranquiciaRepository {

    public FranquiciaRepositoryAdapter(FranquiciaDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, data -> mapper.map(data, Franquicia.class));
    }


    @Override
    public Mono<Franquicia> updateFranquicia(Franquicia franquicia) {
        return findById(franquicia.getId())
                .flatMap(franquicia1 -> save(franquicia))
                .switchIfEmpty(Mono.defer(() ->
                        Mono.error(new BusinessException(BusinessErrorMessage.FRANQUICIA_NOT_FOUND))));
    }

    @Override
    public Mono<Franquicia> createFranquicia(Franquicia franquicia) {
        return save(franquicia)
                .switchIfEmpty(Mono.defer(() ->
                        Mono.error(new BusinessException(BusinessErrorMessage.FRANQUICIA_CREATION_FAILED))));
    }


    @Override
    public Mono<Franquicia> consultarMayorProductoSucursal(FranquiciaId idFranquicia) {
        return repository.findProductosByFranquiciaIdOrderByCantidadDesc(idFranquicia.franquiciaId())
                .collectList()
                .flatMap(sucursalProductosDataList -> {
                    if (sucursalProductosDataList.isEmpty()) {
                        return Mono.error(new BusinessException(BusinessErrorMessage.FRANQUICIA_NOT_FOUND));
                    }
                    Map<UUID, Sucursal> sucursalMap = new LinkedHashMap<>();
                    sucursalProductosDataList.forEach(data -> {
                        Sucursal sucursal = sucursalMap.computeIfAbsent(
                                data.getSucursalId(),
                                id -> construirSucursal(data)
                        );
                        sucursal.getProductos().add(
                                construirProducto(data)
                        );
                    });
                    return Mono.just(construirFranquicia(idFranquicia, sucursalMap))
                            .zipWith(this.findById(idFranquicia.franquiciaId()))
                            .map(FranquiciaRepositoryAdapter::getFranquicia);
                })
                .switchIfEmpty(Mono.defer(() ->
                        Mono.error(new BusinessException(BusinessErrorMessage.FRANQUICIA_NOT_FOUND))));
    }

    private static Franquicia getFranquicia(Tuple2<Franquicia, Franquicia> tuple) {
        Franquicia franquiciaFromDb = tuple.getT2();
        franquiciaFromDb.setSucursales(tuple.getT1().getSucursales());
        return franquiciaFromDb;
    }

    private static Franquicia construirFranquicia(FranquiciaId idFranquicia, Map<UUID, Sucursal> sucursalMap) {
        return Franquicia.builder()
                .id(idFranquicia.franquiciaId())
                .sucursales(new ArrayList<>(sucursalMap.values()))
                .build();
    }

    private static Producto construirProducto(SucursalProductosData data) {
        return Producto.builder()
                .id(data.getProductoId())
                .nombre(data.getProductoNombre())
                .cantidad(data.getCantidad())
                .build();
    }

    private static Sucursal construirSucursal(SucursalProductosData data) {
        return Sucursal.builder()
                .id(data.getSucursalId())
                .nombre(data.getSucursalNombre())
                .productos(new ArrayList<>())
                .build();
    }
}