package co.com.nequi.r2dbc.adapters.producto;

import co.com.nequi.r2dbc.adapters.producto.data.ProductoData;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductoDataRepository extends
        ReactiveCrudRepository<ProductoData, UUID>,
        ReactiveQueryByExampleExecutor<ProductoData> {
}