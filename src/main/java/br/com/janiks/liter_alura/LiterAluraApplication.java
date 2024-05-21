package br.com.janiks.liter_alura;

import br.com.janiks.liter_alura.main.Main;
import br.com.janiks.liter_alura.repositories.AuthorRepository;
import br.com.janiks.liter_alura.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {
	@Autowired
	AuthorRepository autorRepository;
	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(autorRepository,bookRepository);
		main.principal();
	}
}
