package co.com.nequi.model.commons.message;

import lombok.Getter;

@Getter
public enum BusinessErrorMessage {
    FRANQUICIA_NOT_FOUND("Franquicia no encontrada"),
    UNKNOWN_ERROR("Error desconocido"),
    FRANQUICIA_CREATION_FAILED("Error al crear la franquicia"),
    SUCURSAL_CREATION_FAILED("Error al crear la sucursal"),
    SUCURSAL_FRANQUICIA_CREATION_FAILED("Error al crear la sucursal. No existe la franquicia"),
    SUCURSAL_UPDATE_FAILED("Error al actualizar la sucursal"),
    PRODUCTO_NOT_FOUND("Producto no encontrado"),
    PRODUCTO_DELETION_FAILED("Error al eliminar el producto"),
    PRODUCTO_UPDATE_FAILED("Error al actualizar el producto"),
    SUCURSAL_NOT_FOUND("Sucursal no encontrada"),
    PRODUCTO_CREATION_FAILED("Error al crear el producto"),
    PRODUCTO_FRANQUICIA_CREATION_FAILED("Error al crear el producto. No existe la sucursal"),
    CONSULTAR_MAYOR_PRODUCTO_SUCURSAL_FAILED("Error al consultar el mayor producto de la sucursal");

    private final String message;

    BusinessErrorMessage(String message) {
        this.message = message;
    }

}