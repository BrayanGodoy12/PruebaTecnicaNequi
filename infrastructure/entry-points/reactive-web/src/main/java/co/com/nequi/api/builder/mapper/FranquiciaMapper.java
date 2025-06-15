package co.com.nequi.api.builder.mapper;

import co.com.nequi.api.commons.dto.request.ActualizarSucursalDTO;
import co.com.nequi.api.commons.dto.request.FranquiciaActualizarRequestDTO;
import co.com.nequi.api.commons.dto.request.FranquiciaRequestDTO;
import co.com.nequi.api.commons.dto.request.SucursalFranquiciaRequestDTO;
import co.com.nequi.api.commons.dto.response.FranquiciaResponseDTO;
import co.com.nequi.model.franquicia.Franquicia;
import co.com.nequi.model.sucursal.Sucursal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SucursalMapper.class})
public interface FranquiciaMapper {

    Franquicia desdeFranquiciaDTO(FranquiciaRequestDTO franquiciaRequestDTO);

    @Mapping(target = "id", source = "idFranquicia")
    @Mapping(target = "nombre", ignore = true)
    @Mapping(expression = "java(createListSucursal(franquiciaRequestDTO))", target = "sucursales")
    Franquicia desdeFranquciaConSucursalesDTO(SucursalFranquiciaRequestDTO franquiciaRequestDTO);

    @Mapping(target = "id", source = "idFranquicia")
    @Mapping(target = "nombre", ignore = true)
    @Mapping(expression = "java(createListSucursalActualizar(actualizarSucursalDTO))", target = "sucursales")
    Franquicia ActualizarSucursalDTO(ActualizarSucursalDTO actualizarSucursalDTO);

    Franquicia desdeFranquiciaActualizarDTO(FranquiciaActualizarRequestDTO franquiciaActualizarRequestDTO);

    FranquiciaResponseDTO desdeFranquicia(Franquicia franquicia);

    default List<Sucursal> createListSucursal(SucursalFranquiciaRequestDTO sucursalFranquiciaRequestDTO) {
        SucursalMapper sucursalMapper = Mappers.getMapper(SucursalMapper.class);
        return List.of(sucursalMapper.desdeSucursalDTO(sucursalFranquiciaRequestDTO));
    }

    default List<Sucursal> createListSucursalActualizar(ActualizarSucursalDTO actualizarSucursalDTO) {
        SucursalMapper sucursalMapper = Mappers.getMapper(SucursalMapper.class);
        return List.of(sucursalMapper.desdeActualizarSucursalDTO(actualizarSucursalDTO));
    }
}
