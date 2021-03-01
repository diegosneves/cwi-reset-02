package br.com.cwi.reset.exemploreset.repository;

import br.com.cwi.reset.exemploreset.domain.Usuario;
import br.com.cwi.reset.exemploreset.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    private static List<Usuario> usuarios = new ArrayList<>();
    private static Integer novoID = usuarios.size();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario addUsuario(Usuario usuario) {
        usuario.setId(++novoID);
        usuarios.add(usuario);
        return usuario;
    }

    public void removeUsuario(Integer id) {

        for (Usuario usuario : usuarios){
            if (usuario.getId().equals(id)){
                usuarios.remove(usuario);
                return;
            }
        }
        throw new NotFoundException();
    }
}
