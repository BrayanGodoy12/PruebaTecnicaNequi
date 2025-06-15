package co.com.nequi.model.franquicia.valueobject;

import java.util.UUID;

public record FranquiciaId(UUID franquiciaId) {

    public FranquiciaId {
        if (franquiciaId == null || franquiciaId.toString().isBlank()) {
            throw new IllegalArgumentException("El id de la franquicia no puede ser nulo.");
        }
    }

}
