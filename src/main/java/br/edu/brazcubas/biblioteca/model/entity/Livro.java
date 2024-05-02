package br.edu.brazcubas.biblioteca.model.entity;

public class Livro {
    private long id;
    private String titulo;
    private String autor;
    private int numPaginas;
    private long isbn;

    public Livro(long id, String titulo, String autor, int numPaginas, long isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
    }

    public Livro(String titulo, String autor, int numPaginas, long isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
    }   

    public Livro() {
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPaginas() {
        return this.numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }
}
