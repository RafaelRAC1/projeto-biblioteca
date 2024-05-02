package br.edu.brazcubas.biblioteca;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.brazcubas.biblioteca.controller.LivroController;
import br.edu.brazcubas.biblioteca.model.dao.LivroDAO;
import br.edu.brazcubas.biblioteca.model.database.DBConfig;
import br.edu.brazcubas.biblioteca.model.entity.Livro;
import br.edu.brazcubas.biblioteca.view.LivroView;

@SpringBootApplication
public class BibliotecaApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(BibliotecaApplication.class, args);
		DBConfig.createTables(DBConfig.getConnection());

		LivroController livroCon = new LivroController(new LivroDAO());
		LivroView livroView = new LivroView();
		Scanner scan = new Scanner(System.in);

		SistemaBiblioteca sys = new SistemaBiblioteca(livroCon, livroView, scan);
		sys.inicializarSistema();
	}
}
