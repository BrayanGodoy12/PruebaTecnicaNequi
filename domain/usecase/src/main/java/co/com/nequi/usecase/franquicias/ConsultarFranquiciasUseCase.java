package co.com.nequi.usecase.franquicias;

import co.com.nequi.model.franquicia.Franquicia;
import co.com.nequi.model.franquicia.gateways.FranquiciaRepository;
import co.com.nequi.model.franquicia.valueobject.FranquiciaId;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class ConsultarFranquiciasUseCase {

    //private final FranquiciaRepository franquiciaRepository;

    public Mono<List<Franquicia>> listarFranquicias(){
        return Mono.empty();
    }

    public Mono<Franquicia> obtenerFranquicias(FranquiciaId franquicia){
        return Mono.empty();
    }
}
