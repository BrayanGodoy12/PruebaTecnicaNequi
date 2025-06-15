package co.com.nequi.model.commons.message;

public enum BusinessErrorMessage {
    FRANQUICIA_NOT_FOUND("Franquicia no encontrada"),
    UNKNOWN_ERROR("Error desconocido"),
    FRANQUICIA_CREATION_FAILED("Error al crear la franquicia"),
    SUCURSAL_CREATION_FAILED("Error al crear la sucursal"),
    SUCURSAL_UPDATE_FAILED("Error al actualizar la sucursal"),
    PRODUCTO_NOT_FOUND("Producto no encontrado"),
    PRODUCTO_DELETION_FAILED("Error al eliminar el producto"),
    PRODUCTO_UPDATE_FAILED("Error al actualizar el producto"),
    SUCURSAL_NOT_FOUND("Sucursal no encontrada"),
    ;

    private final String message;

    BusinessErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}