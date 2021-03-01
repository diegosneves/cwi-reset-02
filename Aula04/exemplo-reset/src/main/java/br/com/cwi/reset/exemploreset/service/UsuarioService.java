package br.com.cwi.reset.exemploreset.service;

import br.com.cwi.reset.exemploreset.domain.Usuario;
import br.com.cwi.reset.exemploreset.exception.BadRequestException;
import br.com.cwi.reset.exemploreset.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> getUsuarios() {
        return repository.getUsuarios();
    }

    public Usuario addUsuario(Usuario usuario) {
        if(usuario == null || usuario.getNome() == null || usuario.getSenha() == null || usuario.getEmail() == null) {
            throw new BadRequestException();
        }

        return repository.addUsuario(usuario);
    }

    public void removeUsuario(Integer id) {
        repository.removeUsuario(id);
    }
}
