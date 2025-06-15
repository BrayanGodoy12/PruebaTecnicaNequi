package co.com.nequi.r2dbc.adapters.sucursal;

import co.com.nequi.model.commons.BusinessException;
import co.com.nequi.model.commons.message.BusinessErrorMessage;
import co.com.nequi.model.franquicia.Franquicia;
import co.com.nequi.model.sucursal.Sucursal;
import co.com.nequi.model.sucursal.gateways.SucursalRepository;
import co.com.nequi.r2dbc.adapters.sucursal.data.SucursalData;
import co.com.nequi.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public class SucursalRepositoryAdapter extends ReactiveAdapterOperations<
        Sucursal, SucursalData, UUID, SucursalDataRepository
        > implements SucursalRepository {

    public SucursalRepositoryAdapter(SucursalDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, data -> mapper.map(data, Sucursal.class));
    }


    @Override
    public Mono<Sucursal> updateSucursal(Franquicia franquicia) {
        return repository.findById(franquicia.getSucursales().getFirst().getId())
                .switchIfEmpty(Mono.defer(() ->
                        Mono.error(new BusinessException(BusinessErrorMessage.SUCURSAL_NOT_FOUND))))
                .flatMap(existingSucursal -> {
                    SucursalData updatedData = getSucursalData(franquicia);
                    updatedData.setId(existingSucursal.getId());
                    updatedData.setFranquiciaId(existingSucursal.getFranquiciaId());
                    return saveData(updatedData);
                })
                .map(SucursalRepositoryAdapter::getSucursal)
                .switchIfEmpty(Mono.defer(() ->
                        Mono.error(new BusinessException(BusinessErrorMessage.SUCURSAL_UPDATE_FAILED))));
    }

    @Override
    public Mono<Sucursal> createSucursal(Franquicia franquicia) {
        return Mono.just(franquicia)
                .map(SucursalRepositoryAdapter::getSucursalData)
                .flatMap(this::saveData)
                .map(SucursalRepositoryAdapter::getSucursal)
                .switchIfEmpty(Mono.defer(() ->
                        Mono.error(new BusinessException(BusinessErrorMessage.SUCURSAL_CREATION_FAILED))));
    }

    private static Sucursal getSucursal(SucursalData sucursalData) {
        return Sucursal.builder()
                .id(sucursalData.getId())
                .nombre(sucursalData.getNombre())
                .build();
    }

    private static SucursalData getSucursalData(Franquicia franquicia1) {
        return SucursalData
                .builder()
                .id(franquicia1.getSucursales().getFirst().getId())
                .nombre(franquicia1.getSucursales().getFirst().getNombre())
                .franquiciaId(franquicia1.getId())
                .build();
    }


}