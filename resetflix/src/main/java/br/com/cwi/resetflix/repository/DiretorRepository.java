package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.entity.DiretorEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DiretorRepository {

    private List<DiretorEntity> diretores = new ArrayList<>();
    private Long contadorIDs = 1l;

    public List<DiretorEntity> getDiretores() {
        return diretores;
    }

    public DiretorEntity getDiretorById(Long id) {
        for (DiretorEntity diretorEntity : diretores) {
            if (diretorEntity.getId().equals(id)) {
                return diretorEntity;
            }
        }
        return null;
    }

    public Long criarDiretor(DiretorEntity novoDiretor) {
        if (novoDiretor.getId() == null) {
            novoDiretor.setId(contadorIDs++);
        }
        diretores.add(novoDiretor);
        return novoDiretor.getId();
    }
}
