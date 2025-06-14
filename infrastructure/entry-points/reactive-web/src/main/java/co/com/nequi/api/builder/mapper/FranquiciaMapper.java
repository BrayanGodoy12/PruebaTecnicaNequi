package co.com.nequi.api.builder.mapper;

import co.com.nequi.api.commons.dto.FranquiciaRequestDTO;
import co.com.nequi.api.commons.dto.FranquiciaResponseDTO;
import co.com.nequi.model.franquicia.Franquicia;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FranquiciaMapper {

    Franquicia desdeFranquiciaDTO(FranquiciaRequestDTO franquiciaRequestDTO);

    FranquiciaResponseDTO desdeFranquicia(Franquicia franquicia);
}
