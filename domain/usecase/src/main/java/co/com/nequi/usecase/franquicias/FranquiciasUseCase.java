package co.com.nequi.usecase.franquicias;

import co.com.nequi.model.franquicia.Franquicia;
import co.com.nequi.model.franquicia.gateways.FranquiciaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class FranquiciasUseCase {

    private final FranquiciaRepository franquiciaRepository;


    public Mono<Franquicia> createFranquicia(Franquicia franquicia) {
        return Mono.empty();
    }

    public Mono<List<Franquicia>> listFranquicias(){
        return Mono.empty();
    }

    public Mono<Franquicia> getFranquicia(String idFranquicia){
        return Mono.empty();
    }

    public Mono<Franquicia> deleteFranquicia(String idFranquicia){
        return Mono.empty();
    }

    public Mono<Franquicia> updateFranquicia(Franquicia franquicia){
        return Mono.empty();
    }



}
