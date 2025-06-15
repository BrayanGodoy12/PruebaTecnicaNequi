package co.com.nequi.r2dbc.adapters.franquicia;

import co.com.nequi.r2dbc.adapters.franquicia.data.FranquiciaData;
import co.com.nequi.r2dbc.adapters.franquicia.data.SucursalProductosData;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface FranquiciaDataRepository extends
        ReactiveCrudRepository<FranquiciaData, UUID>,
        ReactiveQueryByExampleExecutor<FranquiciaData> {

  @Query("""
     
          SELECT s.id AS sucursal_id,
            s.nombre AS sucursal_nombre,
            p.id AS producto_id,
            p.nombre AS producto_nombre,
            p.cantidad
     FROM franquicias_schema.sucursal s
     JOIN franquicias_schema.producto p ON s.id = p.sucursal_id
     WHERE s.franquicia_id = :idFranquicia
     ORDER BY s.id, p.cantidad DESC
     """)
 Flux<SucursalProductosData> findProductosByFranquiciaIdOrderByCantidadDesc(UUID idFranquicia);
 }