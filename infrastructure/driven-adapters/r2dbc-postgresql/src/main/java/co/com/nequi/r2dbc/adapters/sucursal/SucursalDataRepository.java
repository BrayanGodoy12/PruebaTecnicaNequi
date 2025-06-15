package co.com.nequi.r2dbc.adapters.sucursal;

import co.com.nequi.r2dbc.adapters.sucursal.data.SucursalData;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SucursalDataRepository extends
        ReactiveCrudRepository<SucursalData, UUID>,
        ReactiveQueryByExampleExecutor<SucursalData> {
}