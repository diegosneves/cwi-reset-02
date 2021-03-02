package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.request.CriarFilmeRequest;

public class FilmeEntityMapper {

    public FilmeEntity mapear(CriarFilmeRequest request) {
        return new FilmeEntity(request.getNome(), request.getGenero(), request.getIdDiretor(), request.getIdsAtores());
    }
}
