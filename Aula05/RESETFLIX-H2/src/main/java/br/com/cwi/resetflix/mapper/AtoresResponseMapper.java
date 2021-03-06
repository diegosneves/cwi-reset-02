package br.com.cwi.resetflix.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.response.AtoresResponse;

@Component
public class AtoresResponseMapper {

    public List<AtoresResponse> mapear(final List<AtorEntity> atores) {
        List<AtoresResponse> atoresResponses = new ArrayList<>();

        for(AtorEntity atorEntity : atores){

            AtoresResponse atorResponse = new AtoresResponse(atorEntity.getId(),
                atorEntity.getNome());

            atoresResponses.add(atorResponse);
        }

        return atoresResponses;
    }
}
