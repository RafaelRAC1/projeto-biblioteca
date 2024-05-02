package br.edu.brazcubas.biblioteca.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

  private static final String URL = "jdbc:h2:mem:test";

  private static final String USER = "admin";

  private static final String PASSWORD = "admin";

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASSWORD);
  }

  public static void createTables(Connection conn) throws SQLException{
    try {
      conn.createStatement().execute("create schema biblioteca;");
      conn.createStatement().execute("use biblioteca;");
      conn.createStatement().execute("CREATE TABLE livro (id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL, titulo VARCHAR(255) NOT NULL, autor VARCHAR(255) NOT NULL, numero_paginas integer NOT NULL, isbn integer not null);");
    } catch(SQLException e){
      System.err.println(e);
    }

  }
}