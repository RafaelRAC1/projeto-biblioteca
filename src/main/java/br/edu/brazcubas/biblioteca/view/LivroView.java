package br.edu.brazcubas.biblioteca.view;

import java.util.*;

import br.edu.brazcubas.biblioteca.model.entity.Livro;

public class LivroView {
    public void imprimirInformacoesLivro(Livro livro){
        System.out.println("INFORMACOES DO LIVRO:");
        System.out.println("ID: "+livro.getId());
        System.out.println("Titulo: "+livro.getTitulo());
        System.out.println("Autor: "+livro.getAutor());
        System.out.println("ISBN: "+livro.getIsbn());
        System.out.println("Qtd. Paginas: "+livro.getNumPaginas());
    }

    public void imprimirListaLivros(List<Livro> livros){
        for(Livro livro : livros){
            System.out.println("ID "+livro.getId()+" - "+livro.getTitulo()+" ["+livro.getAutor()+"]");
        }
    }
}
