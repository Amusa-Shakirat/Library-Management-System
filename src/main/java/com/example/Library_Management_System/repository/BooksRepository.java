package com.example.Library_Management_System.repository;

import com.example.Library_Management_System.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BooksRepository extends JpaRepository<Books, Long> {

    List<Books> findByTitle(String title);

    List<Books> findByIsbnNo(String isbnNo);
}
//addBook, deleteBook, borrowBook, findBookById, findBookByTitle, findBookByISBNNo