package br.edu.brazcubas.biblioteca.controller;

import br.edu.brazcubas.biblioteca.model.entity.Livro;

import java.sql.SQLException;
import java.util.List;
import br.edu.brazcubas.biblioteca.model.dao.IDAO;

public class LivroController {
    private final IDAO<Livro> livroDAO;

    public LivroController(IDAO<Livro> livroDAO) {
        this.livroDAO = livroDAO;
    }

    public String cadastrarLivro(Livro livro) throws SQLException{
        livroDAO.cadastrar(livro);
        return "Livro cadastrado!";
    } 

    public String atualizarLivro(Livro livro) throws SQLException{
        livroDAO.atualizar(livro);
        return "Livro atualizado!";
    }

    public String excluirLivro(long id) throws SQLException{
        livroDAO.excluir(id);
        return "Livro excluido!";
    }

    public Livro listarLivro(int id) throws SQLException{
        return livroDAO.listarLivro(id);
    }

    public List<Livro> listarLivros() throws SQLException{
        return livroDAO.listar();
    }
}
