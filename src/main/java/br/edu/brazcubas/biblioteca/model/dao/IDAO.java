package br.edu.brazcubas.biblioteca.model.dao;

import java.sql.SQLException;
import java.util.List;
import br.edu.brazcubas.biblioteca.model.entity.Livro;

public interface IDAO<T extends Livro> {

    void cadastrar(T item) throws SQLException;

    void atualizar(T item) throws SQLException;

    void excluir(long id) throws SQLException;

    List<T> listar() throws SQLException;

    Livro listarLivro(int idLivro) throws SQLException;
}
