package com.example.Library_Management_System.service;


import com.example.Library_Management_System.model.Books;
import com.example.Library_Management_System.model.BorrowedBooks;
import com.example.Library_Management_System.model.Users;
import com.example.Library_Management_System.repository.BooksRepository;
import com.example.Library_Management_System.repository.BorrowedBooksRepository;
import com.example.Library_Management_System.repository.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class BorrowedBooksService {

    @Autowired
    private BorrowedBooksRepository borrowedBooksRepository;

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private UsersRepository usersRepository;


    @CacheEvict(value = "addBorrowedBooks", allEntries = true)
    public BorrowedBooks addBorrowedBooks(BorrowedBooks borrowedBooks) {
        Books books = booksRepository.findById(borrowedBooks.getBooks().getId())
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));

        Users users = usersRepository.findById(borrowedBooks.getUsers().getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        borrowedBooks.setBooks(books);
        borrowedBooks.setUsers(users);

        return borrowedBooksRepository.save(borrowedBooks);
    }

    public BorrowedBooks findBorrowedBooksById(long id){
        return borrowedBooksRepository.findById(id).orElseThrow();
    }

    public BorrowedBooks findBorrowedBooksByAuthorName(String bookAuthor){
        return (BorrowedBooks) borrowedBooksRepository.findByBookAuthor(bookAuthor);
    }

    public BorrowedBooks findBorrowedBooksByBookName(String bookName){
        return (BorrowedBooks) borrowedBooksRepository.findByBookName(bookName);
    }





}