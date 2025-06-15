package co.com.nequi.r2dbc.adapters.producto;

import co.com.nequi.model.commons.BusinessException;
import co.com.nequi.model.commons.message.BusinessErrorMessage;
import co.com.nequi.model.producto.Producto;
import co.com.nequi.model.producto.gateways.ProductoRepository;
import co.com.nequi.model.producto.valueobject.ProductoId;
import co.com.nequi.model.sucursal.Sucursal;
import co.com.nequi.r2dbc.adapters.producto.data.ProductoData;
import co.com.nequi.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.UUID;

@Repository
public class ProductoRepositoryAdapter extends ReactiveAdapterOperations<
        Producto, ProductoData, UUID, ProductoDataRepository
        > implements ProductoRepository {

    public ProductoRepositoryAdapter(ProductoDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, data -> mapper.map(data, Producto.class));
    }


    @Override
    public Mono<Producto> createProduct(Sucursal sucursal) {
        return Mono.just(sucursal)
                .map(ProductoRepositoryAdapter::getProductoData)
                .flatMap(this::saveData)
                .map(ProductoRepositoryAdapter::getProducto)
                .switchIfEmpty(Mono.defer(() ->
                        Mono.error(new RuntimeException("Product creation failed"))));
    }

    @Override
    public Mono<Producto> updateProduct(Sucursal sucursal) {
        return repository.findById(sucursal.getProductos().get(0).getId())
                .switchIfEmpty(Mono.defer(() ->
                        Mono.error(new BusinessException(BusinessErrorMessage.PRODUCTO_NOT_FOUND))))
                .flatMap(existingProduct -> {
                    ProductoData updatedData = getProductoData(sucursal);
                    updatedData.setId(existingProduct.getId());
                    updatedData.setSucursalId(existingProduct.getSucursalId());
                    return saveData(updatedData);
                })
                .map(ProductoRepositoryAdapter::getProducto)
                .switchIfEmpty(Mono.defer(() ->
                        Mono.error(new BusinessException(BusinessErrorMessage.PRODUCTO_UPDATE_FAILED))));
    }

    @Override
    public Mono<ProductoId> deleteProduct(ProductoId idProducto) {
        return repository.findById(idProducto.productoId())
                .switchIfEmpty(Mono.defer(() ->
                        Mono.error(new BusinessException(BusinessErrorMessage.PRODUCTO_NOT_FOUND))))
                .flatMap(data -> repository.delete(data).thenReturn(idProducto))
                .switchIfEmpty(Mono.defer(() ->
                        Mono.error(new BusinessException(BusinessErrorMessage.PRODUCTO_DELETION_FAILED))));
    }

    private static Producto getProducto(ProductoData productoData) {
        return Producto.builder()
                .id(productoData.getId())
                .nombre(productoData.getNombre())
                .cantidad(productoData.getCantidad().intValue())
                .build();
    }

    private static ProductoData getProductoData(Sucursal sucursal) {
        return ProductoData
                .builder()
                .id(sucursal.getProductos().get(0).getId())
                .nombre(sucursal.getProductos().get(0).getNombre())
                .cantidad(BigDecimal.valueOf(sucursal.getProductos().get(0).getCantidad()))
                .sucursalId(sucursal.getId())
                .build();
    }

}