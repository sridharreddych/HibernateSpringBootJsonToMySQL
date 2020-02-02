package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\n\nPersist a new author:");
            bookstoreService.newAuthor();
            
            System.out.println("\n\nFind author by name:");
            bookstoreService.byName();
            
            System.out.println("\n\nFind author by the isbn of his book:");
            bookstoreService.byNameIsbn();
            
            System.out.println("\n\nFind author by the isbn of his book via a native query:");
            bookstoreService.byBookIsbnNativeQuery();
        };
    }
}
/*
 * 
 * How To Handle JSON in MySQL

Description: Hibernate Types is a library of extra types not supported by Hibernate Core by default. This is a Spring Boot application that uses this library to persist JSON data (JSON Java Object) in a MySQL json column and for querying JSON data from the MySQL json column to JSON Java Object. Updates are supported as well.

Key points:

for Maven, add Hibernate Types as a dependency in pom.xml
in entity use @TypeDef to map typeClass to JsonStringType
 * 
 */
