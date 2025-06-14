package co.com.nequi.model.sucursal.valueobject;

public record SucursalId (String idSucursal) {

    public SucursalId{
        if (idSucursal == null || idSucursal.isBlank()) {
            throw new IllegalArgumentException("idSucursal");
        }
    }
}
