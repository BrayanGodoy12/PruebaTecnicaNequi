package co.com.nequi.r2dbc.adapters.franquicia;

import co.com.nequi.model.commons.BusinessException;
import co.com.nequi.model.commons.message.BusinessErrorMessage;
import co.com.nequi.model.franquicia.Franquicia;
import co.com.nequi.model.franquicia.gateways.FranquiciaRepository;
import co.com.nequi.model.franquicia.valueobject.FranquiciaId;
import co.com.nequi.r2dbc.adapters.franquicia.data.FranquiciaData;
import co.com.nequi.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

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
                .switchIfEmpty(Mono.defer(() -> Mono.error(new BusinessException(BusinessErrorMessage.FRANQUICIA_NOT_FOUND))));
    }

    @Override
    public Mono<Franquicia> createFranquicia(Franquicia franquicia) {
        return save(franquicia)
                .switchIfEmpty(Mono.defer(() -> Mono.error(new BusinessException(BusinessErrorMessage.FRANQUICIA_CREATION_FAILED))));
    }


    @Override
    public Mono<Franquicia> consultarMayorProductoSucursal(FranquiciaId idFranquicia) {

        return repository.findProductosByFranquiciaIdOrderByCantidadDesc(idFranquicia.franquiciaId())
                .collectList()
                .flatMap(sucursalProductosDataList -> {
                    if (sucursalProductosDataList.isEmpty()) {
                        return Mono.error(new BusinessException(BusinessErrorMessage.FRANQUICIA_NOT_FOUND));
                    }
                    return Mono.just(Franquicia.builder().build());
                })
                .switchIfEmpty(Mono.defer(() -> Mono.error(new BusinessException(BusinessErrorMessage.FRANQUICIA_NOT_FOUND))));
    }
}