package co.com.nequi.api.builder.mapper;

import co.com.nequi.api.commons.dto.request.ActualizarProductoRequestDTO;
import co.com.nequi.api.commons.dto.request.ActualizarSucursalDTO;
import co.com.nequi.api.commons.dto.request.ProductoSucursalRequestDTO;
import co.com.nequi.api.commons.dto.request.SucursalFranquiciaRequestDTO;
import co.com.nequi.api.commons.dto.response.SucursalResponseDTO;
import co.com.nequi.model.producto.Producto;
import co.com.nequi.model.sucursal.Sucursal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductoMapper.class})
public interface SucursalMapper {

    Sucursal desdeSucursalDTO(SucursalFranquiciaRequestDTO sucursalFranquiciaRequestDTO);

    Sucursal desdeActualizarSucursalDTO(ActualizarSucursalDTO sucursalResponseDTO);

    @Mapping(target = "id", source = "idSucursal")
    @Mapping(target = "nombre", ignore = true)
    @Mapping(expression = "java(createListProducto(productoSucursalRequestDTO))", target = "productos")
    Sucursal desdeProductoSucursalDTO(ProductoSucursalRequestDTO productoSucursalRequestDTO);

    @Mapping(target = "id", source = "idSucursal")
    @Mapping(target = "nombre", ignore = true)
    @Mapping(expression = "java(createListProductoActualizar(actualizarProductoRequestDTO))", target = "productos")
    Sucursal actualizarProductoSucursal(ActualizarProductoRequestDTO actualizarProductoRequestDTO);

    SucursalResponseDTO desdeSucursal(Sucursal sucursal);

    default List<Producto> createListProducto(ProductoSucursalRequestDTO productoSucursalRequestDTO) {
        ProductoMapper productoMapper = Mappers.getMapper(ProductoMapper.class);
        return List.of(productoMapper.desdeProductoSucursalDTO(productoSucursalRequestDTO));
    }
    default List<Producto> createListProductoActualizar(ActualizarProductoRequestDTO actualizarProductoRequestDTO) {
        ProductoMapper productoMapper = Mappers.getMapper(ProductoMapper.class);
        return List.of(productoMapper.productoDTOToProducto(actualizarProductoRequestDTO));
    }
}
