package net.virkkunen.booksspring;

import java.util.Optional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BooksSpringApplication {
    
        @Bean
        public CommandLineRunner springMain() {
            return args -> {
                System.out.println(brep.findAuthor(1));
                System.out.println(brep.findByTitle("e"));
                System.out.println(arep.findBooks(3));
                System.out.println(arep.findNameContains("c"));
                /*
                Optional<Book> bBolla=brep.findById(5);
                if (bBolla.isPresent()){
                    System.out.println("Bolla: "+bBolla.get());
                    Book b=bBolla.get();
                    b.setTitle("Bolla");
                    brep.save(b);
                }
                System.out.println("Add book");
                Book bnew = new Book();
                bnew.setTitle("Bolla");
//                brep.save(bnew);
                System.out.println("All books");
                Iterable<Book> books = brep.findAll();
                for (Book b : books) {
                    System.out.println(b);
                }
                Author at=arep.findById(1).get();
                System.out.println("Tolkien: "+at);
                at.setFirstName("JRR");
                arep.save(at);
                System.out.println("Add author");
                Author anew = new Author();
                anew.setFirstName("Pajtim");
                anew.setLastName("Statovci");
//                arep.save(anew);                
                System.out.println("All authors");
                Iterable<Author> authors = arep.findAll();
                for (Author a : authors) {
                    System.out.println(a);
                } */
            };
        }

	public static void main(String[] args) {
		SpringApplication.run(BooksSpringApplication.class, args);
	}

}
