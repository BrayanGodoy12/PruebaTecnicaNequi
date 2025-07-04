package co.com.nequi.api.builder.mapper;

import co.com.nequi.api.commons.dto.request.ActualizarProductoRequestDTO;
import co.com.nequi.api.commons.dto.request.ProductoSucursalRequestDTO;
import co.com.nequi.api.commons.dto.response.ProductoResponseDTO;
import co.com.nequi.model.producto.Producto;
import co.com.nequi.model.sucursal.Sucursal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    ProductoResponseDTO productoToProductoDTO(Producto producto);

    Producto desdeProductoSucursalDTO(ProductoSucursalRequestDTO productoSucursalRequestDTO);

    Producto productoDTOToProducto(ActualizarProductoRequestDTO actualizarProductoRequestDTO);

}
