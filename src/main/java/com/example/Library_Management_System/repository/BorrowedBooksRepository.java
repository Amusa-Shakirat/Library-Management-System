package com.example.Library_Management_System.repository;

import com.example.Library_Management_System.model.BorrowedBooks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowedBooksRepository extends JpaRepository<BorrowedBooks, Long> {

    List<BorrowedBooks> findByBookName(String bookName);

    List<BorrowedBooks> findByBookAuthor(String bookAuthor);


}
