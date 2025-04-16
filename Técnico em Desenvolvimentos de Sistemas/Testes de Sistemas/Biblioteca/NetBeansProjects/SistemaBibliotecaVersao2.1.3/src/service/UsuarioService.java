package service;

import model.Usuario;
import java.util.HashMap;
import java.util.Map;

public class UsuarioService {
    private Map<String, Usuario> usuarios = new HashMap<>();

    public UsuarioService() {
        cadastrarUsuario("admin", "admin123", "bibliotecario");
        cadastrarUsuario("maria", "abcd", "professor");
        cadastrarUsuario("joao", "1234", "aluno");
        cadastrarUsuario("lucas", "1234", "aluno");
        cadastrarUsuario("ana", "1234", "aluno");
    }

    public boolean cadastrarUsuario(String nome, String senha, String tipo) {
        if (usuarios.containsKey(nome)) {
            return false;
        }
        usuarios.put(nome, new Usuario(nome, senha, tipo));
        return true;
    }

    public Usuario autenticar(String nome, String senha) {
        Usuario u = usuarios.get(nome);
        if (u != null && u.getSenha().equals(senha)) {
            return u;
        }
        return null;
    }
}
