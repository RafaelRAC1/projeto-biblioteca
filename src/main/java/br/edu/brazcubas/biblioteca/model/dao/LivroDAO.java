package br.edu.brazcubas.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.brazcubas.biblioteca.model.entity.Livro;
import br.edu.brazcubas.biblioteca.model.database.DBConfig;

public class LivroDAO implements IDAO<Livro> {
    public void cadastrar(Livro item) throws SQLException {
        try {
            Connection conn = DBConfig.getConnection();
            conn.createStatement().execute("USE biblioteca;");
            String query = "insert into livro values (default, ?, ?, ?, ?);";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, item.getTitulo());
            stmt.setString(2, item.getAutor());
            stmt.setString(3, String.valueOf(item.getNumPaginas()));
            stmt.setString(4, String.valueOf(item.getIsbn()));
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public void atualizar(Livro item) throws SQLException {
        try {
            Connection conn = DBConfig.getConnection();
            conn.createStatement().execute("USE biblioteca;");
            String query = "UPDATE livro SET titulo = ?, autor = ?, numero_paginas = ?, isbn = ? WHERE id = ?;";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, item.getTitulo());
            stmt.setString(2, item.getAutor());
            stmt.setString(3, String.valueOf(item.getNumPaginas()));
            stmt.setString(4, String.valueOf(item.getIsbn()));
            stmt.setString(5, String.valueOf(item.getId()));
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void excluir(long id) {
        try {
            Connection conn = DBConfig.getConnection();
            conn.createStatement().execute("USE biblioteca;");
            String query = "DELETE FROM livro WHERE id = ?;";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, String.valueOf(id));
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public Livro listarLivro(int idLivro) throws SQLException {
        Livro livro = new Livro();
        try {
            Connection conn = DBConfig.getConnection();
            conn.createStatement().execute("USE biblioteca;");
            String query = "SELECT * FROM livro WHERE id = ?;";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idLivro);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int numero_paginas = rs.getInt("numero_paginas");
                int isbn = rs.getInt("isbn");

                livro.setId(id);
                livro.setAutor(autor);
                livro.setTitulo(titulo);
                livro.setNumPaginas(numero_paginas);
                livro.setIsbn(isbn);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
        return livro;
    }

    public List<Livro> listar() {
        List<Livro> minhaList = new ArrayList<Livro>();
        try {
            Connection conn = DBConfig.getConnection();
            conn.createStatement().execute("USE biblioteca;");
            String query = "SELECT * FROM livro;";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int numero_paginas = rs.getInt("numero_paginas");
                int isbn = rs.getInt("isbn");

                Livro livro = new Livro(id, titulo, autor, numero_paginas, isbn);

                minhaList.add(livro);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return minhaList;
    }

}
