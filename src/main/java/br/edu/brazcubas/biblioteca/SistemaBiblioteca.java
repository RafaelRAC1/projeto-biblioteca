package br.edu.brazcubas.biblioteca;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import br.edu.brazcubas.biblioteca.controller.LivroController;
import br.edu.brazcubas.biblioteca.model.entity.Livro;
import br.edu.brazcubas.biblioteca.view.LivroView;

public class SistemaBiblioteca {
    private LivroController livroCon;
    private LivroView livroView;
    private Scanner scan;

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public SistemaBiblioteca(LivroController livroCon, LivroView livroView, Scanner scan) {
        this.livroCon = livroCon;
        this.livroView = livroView;
        this.scan = scan;
    }

    public void inicializarSistema() {
        int op = 0;
        int id = 0;

        while (op != 6) {
            clearScreen();
            System.out.println("\n=== SISTEMA BIBLIOTECA ===");
            System.out.println("1 - Adicionar Livro");
            System.out.println("2 - Atualizar Livro");
            System.out.println("3 - Excluir Livro");
            System.out.println("4 - Descrever Livro");
            System.out.println("5 - Listar Livros");
            System.out.println("6 - Sair");
            System.out.println("---------------------------");
            System.out.printf("Digite a opção: ");
            op = scan.nextInt();

            switch (op) {
                case 1:
                    clearScreen();
                    System.out.println("\n=== SISTEMA BIBLIOTECA ===");
                    System.out.println("---- ADICIONAR LIVRO ----");
                    Livro livro = new Livro();
                    System.out.println("Digite as informações.\n");
                    System.out.println("Título: ");
                    System.out.print("-> ");
                    scan.nextLine();
                    livro.setTitulo(scan.nextLine());

                    System.out.println("\nAutor: ");
                    System.out.print("-> ");
                    livro.setAutor(scan.nextLine());

                    System.out.println("\nNúmero de Páginas: ");
                    System.out.print("-> ");
                    livro.setNumPaginas(scan.nextInt());

                    System.out.println("\nISBN: ");
                    System.out.print("-> ");
                    livro.setIsbn(scan.nextInt());

                    try {
                        System.out.println("");
                        System.out.println(this.livroCon.cadastrarLivro(livro));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        System.out.println("\nPressione qualquer tecla para continuar...");
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case 2:
                    clearScreen();
                    System.out.println("\n=== SISTEMA BIBLIOTECA ===");
                    System.out.println("----- ATUALIZAR LIVRO -----\n");

                    try {
                        livroView.imprimirListaLivros(livroCon.listarLivros());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    System.out.println("\nDigite o ID do livro: ");
                    System.out.print("-> ");
                    id = scan.nextInt();

                    clearScreen();
                    System.out.println("\n=== SISTEMA BIBLIOTECA ===");
                    System.out.println("---- ATUALIZAR LIVRO ----\n");
                    Livro livroAtualizar = new Livro();

                    try {
                        livroAtualizar = livroCon.listarLivro(id);
                        livroView.imprimirInformacoesLivro(livroAtualizar);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    System.out.println("\n*Digite as novas informações.\n");

                    System.out.println("Título: ");
                    System.out.print("-> ");
                    scan.nextLine();
                    livroAtualizar.setTitulo(scan.nextLine());

                    System.out.println("\nAutor: ");
                    System.out.print("-> ");
                    livroAtualizar.setAutor(scan.nextLine());

                    System.out.println("\nNúmero de Páginas: ");
                    System.out.print("-> ");
                    livroAtualizar.setNumPaginas(scan.nextInt());

                    System.out.println("\nISBN: ");
                    System.out.print("-> ");
                    livroAtualizar.setIsbn(scan.nextInt());

                    try {
                        System.out.println("");
                        System.out.println(this.livroCon.atualizarLivro(livroAtualizar));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        System.out.println("\nPressione qualquer tecla para continuar...");
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case 3:
                    clearScreen();
                    System.out.println("\n=== SISTEMA BIBLIOTECA ===");
                    System.out.println("----- EXCLUIR LIVRO -----\n");

                    try {
                        livroView.imprimirListaLivros(livroCon.listarLivros());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    System.out.println("\nDigite o ID do livro: ");
                    System.out.print("-> ");
                    try {
                        String str = livroCon.excluirLivro(scan.nextInt());
                        System.out.println("\n" + str);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        System.out.println("\nPressione qualquer tecla para continuar...");
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case 4:
                    clearScreen();
                    System.out.println("\n=== SISTEMA BIBLIOTECA ===");
                    System.out.println("----- DESCREVER LIVRO -----\n");

                    try {
                        livroView.imprimirListaLivros(livroCon.listarLivros());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    System.out.println("\nDigite o ID do livro: ");
                    System.out.print("-> ");
                    id = scan.nextInt();

                    clearScreen();
                    System.out.println("\n=== SISTEMA BIBLIOTECA ===");
                    System.out.println("---- DESCREVER LIVRO ----\n");

                    try {
                        livroView.imprimirInformacoesLivro(livroCon.listarLivro(id));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        System.out.println("\nPressione qualquer tecla para continuar...");
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    clearScreen();
                    System.out.println("\n=== SISTEMA BIBLIOTECA ===");
                    System.out.println("----- LISTAR LIVROS -----\n");
                    try {
                        livroView.imprimirListaLivros(livroCon.listarLivros());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        System.out.println("\nPressione qualquer tecla para continuar...");
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("\nSaindo...");
    }
}
