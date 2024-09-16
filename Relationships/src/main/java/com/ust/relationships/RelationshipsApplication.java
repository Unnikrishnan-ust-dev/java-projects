package com.ust.relationships;

import com.ust.relationships.repository.BookRepository;
import com.ust.relationships.repository.PageRepository;
import com.ust.relationships.resources.Book;
import com.ust.relationships.resources.Page;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RelationshipsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RelationshipsApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner mappingDemo(BookRepository bookRepository, PageRepository pageRepository){
//        return args -> {
//            Book book = new Book("Spring Boot","Josh Lang","8735");
//            Page p1 = new Page(1,"Introduction","Chapter 1");
//            Page p2 = new Page(50,"Content","Chapter 2");
//            Page p3 = new Page(67,"Wrap Up","Chapter 3");
//            Page p4 = new Page(69,"End","Chapter 4");
//
//            book.getPages().add(p1);
//            book.getPages().add(p2);
//            book.getPages().add(p3);
//            book.getPages().add(p4);
//
//            bookRepository.save(book);
//        };
//    }

    @Bean
    public CommandLineRunner mappingDemo(BookRepository bookRepository, PageRepository pageRepository){
        return args -> {
            Book book = new Book("Spring Boot","Josh Lang","8737");
            bookRepository.save(book);

            Page p1 = new Page(1,"Introduction","Chapter 1",book);
            Page p2 = new Page(50,"Content","Chapter 2",book);
            Page p3 = new Page(67,"Wrap Up","Chapter 3",book);
            Page p4 = new Page(69,"End","Chapter 4",book);

            pageRepository.save(p1);
            pageRepository.save(p2);
            pageRepository.save(p3);
            pageRepository.save(p4);



        };
    }
}
