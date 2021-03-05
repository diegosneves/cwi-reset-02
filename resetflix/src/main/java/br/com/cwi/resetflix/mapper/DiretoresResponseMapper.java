package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.response.DiretoresResponse;

import java.util.ArrayList;
import java.util.List;

public class DiretoresResponseMapper {
    //TODO Inserir comentarios
    public List<DiretoresResponse> mapear(List<DiretorEntity> diretores) {

        List<DiretoresResponse> diretoresSalvos = new ArrayList<>();

        for (DiretorEntity diretorEntity : diretores){
            diretoresSalvos.add(new DiretoresResponse(diretorEntity.getId(), diretorEntity.getNome()));
        }

        return diretoresSalvos;
    }
}
