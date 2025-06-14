package co.com.nequi.model.franquicia.valueobject;

public record FranquiciaId(String franquiciaId) {

    public  FranquiciaId{
        if(franquiciaId == null||franquiciaId.isBlank()){
            throw new IllegalArgumentException("El id de la franquicia no puede ser nulo.");
        }
    }

}
