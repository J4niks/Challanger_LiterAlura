package br.com.janiks.liter_alura.main;

import br.com.janiks.liter_alura.models.Author;
import br.com.janiks.liter_alura.models.AuthorData;
import br.com.janiks.liter_alura.models.Book;
import br.com.janiks.liter_alura.models.BookData;
import br.com.janiks.liter_alura.repositories.AuthorRepository;
import br.com.janiks.liter_alura.repositories.BookRepository;
import br.com.janiks.liter_alura.services.ApiRequest;
import br.com.janiks.liter_alura.services.DataConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner sc = new Scanner(System.in);
    private ApiRequest requisicao = new ApiRequest();
    private AuthorRepository repositorioAutor;
    private BookRepository repositorioLivro;
    private List<Book> books = new ArrayList<>();
    private DataConverter conversor = new DataConverter();
    private final String ADDRESS = "https://gutendex.com/books?search=";

    public Main(AuthorRepository repositorioAutor, BookRepository repositorioLivro) {
        this.repositorioAutor = repositorioAutor;
        this.repositorioLivro = repositorioLivro;
    }

    public void principal(){
        String menu = """
                **********************************************
                1 - Buscar livro pelo titulo
                2 - Listar livros registrados
                3 - Listar autores registrados
                4 - Listar autores vivos em determinado ano
                5 - Listar livros em determinado idioma
                
                0 - Sair
                **********************************************
                """;
        var opcao = -1;
        while (opcao != 0){
            System.out.println(menu);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:
                    buscarNovoLivro();
                    break;
                case 2:
                    buscarLivrosRegistrados();
                    break;
                case 3:
                    buscarAutoresRegistrados();
                    break;
                case 4:
                    buscarLivrosPorAno();
                    break;
                case 5:
                    buscarLivrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("\n\n***Opção Inválida***\n\n");
            }
        }


    }

    private void buscarNovoLivro() {
        System.out.println("\nQual livro deseja buscar?");
        var buscaDoUsuario = sc.nextLine();
        var dados = requisicao.consumo(ADDRESS+ buscaDoUsuario.replace(" ","%20"));
        salvarNoDb(dados);
    }

    private void salvarNoDb(String dados){
        try{
            Book livro = new Book(conversor.getData(dados, BookData.class));
            Author autor = new Author(conversor.getData(dados, AuthorData.class));
            Author autorDb = null;
            Book bookDb = null;
            if (!repositorioAutor.existsByNome(autor.getNome())){
                repositorioAutor.save(autor);
                autorDb = autor;
            }else{
                autorDb = repositorioAutor.findByNome(autor.getNome());
            }
            if (!repositorioLivro.existsByNome(livro.getNome())){
                livro.setAutor(autorDb);
                repositorioLivro.save(livro);
                bookDb = livro;
            }else{
                bookDb = repositorioLivro.findByNome(livro.getNome());
            }
            System.out.println(bookDb);
        }catch (NullPointerException e){
            System.out.println("\n\n*** Livro não encontrado ***\n\n");
        }

    }


    private void buscarLivrosRegistrados() {
        var bucasDB = repositorioLivro.findAll();
        if(!bucasDB.isEmpty()){
            System.out.println("\nLivros cadastrados no banco de dados: ");
            bucasDB.forEach(System.out::println);
        }else{
            System.out.println("\nNenhum livro encontrado no banco de dados!");
        }
    }

    private void buscarAutoresRegistrados() {
        var buscaDb = repositorioAutor.findAll();
        if(!buscaDb.isEmpty()){
            System.out.println("\nAutores cadastrados no banco de dados:");
            buscaDb.forEach(System.out::println);
        }else{
            System.out.println("\nNenhum autor encontrado no banco de dados!");
        }
    }

    private void buscarLivrosPorAno() {
        System.out.println("\nQual ano deseja pesquisar?");
        var anoSelecionado = sc.nextInt();
        sc.nextLine();
        var buscaAutoresNoDb = repositorioAutor.buscarPorAnoDeFalecimento(anoSelecionado);
        if(!buscaAutoresNoDb.isEmpty()){
            System.out.println("\n\nAtores vivos no ano de: " + anoSelecionado);
            buscaAutoresNoDb.forEach(System.out::println);
        }else {
            System.out.println("\nNenhum autor encontrado para esta data!");
        }
    }

    private void buscarLivrosPorIdioma() {
        var idiomasCadastrados = repositorioLivro.bucasidiomas();
        System.out.println("\nIdiomas cadastrados no banco:");
        idiomasCadastrados.forEach(System.out::println);
        System.out.println("\nSelecione um dos idiomas cadastrados no banco:\n");
        var idiomaSelecionado = sc.nextLine();
        repositorioLivro.buscarPorIdioma(idiomaSelecionado).forEach(System.out::println);
    }
}
