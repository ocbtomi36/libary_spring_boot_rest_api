package net.myapi.springboot.repository;

import net.myapi.springboot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Optional<Book> findBookByTitle(String title);

}
