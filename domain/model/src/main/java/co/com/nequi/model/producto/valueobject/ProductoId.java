package co.com.nequi.model.producto.valueobject;

public record ProductoId(String productoId) {

    public ProductoId{
        if (productoId == null || productoId.isBlank()) {
            throw new IllegalArgumentException("El id del producto no puede ser nulos");
        }
    }
}
