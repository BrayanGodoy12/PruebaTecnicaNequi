package co.com.nequi.model.producto.valueobject;

import java.util.UUID;

public record ProductoId(UUID productoId) {

    public ProductoId {
        if (productoId == null || productoId.toString().isBlank()) {
            throw new IllegalArgumentException("El id del producto no puede ser nulos");
        }
    }
}
