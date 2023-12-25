package com.example.Library_Management_System.service;



import com.example.Library_Management_System.model.Books;
import com.example.Library_Management_System.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    //addBook, deleteBook, borrowBook, findBookById, findBookByTitle, findBookByISBNNo


    @CacheEvict(value = {"addBooks"}, allEntries = true)
    public Books addBook(Books books){
        return booksRepository.save(books);
    }


    @CacheEvict(value = {"allBooks"}, allEntries = true)
    public Books deleteBook(long id){
        Books books = findBookById(id);
        booksRepository.delete(books);
        return books;
    }

    public Books borrowBook(long id){

        return booksRepository.findById(id).orElseThrow(null);
    }


    @Cacheable("allBooks")
    public List<Books> getAllBooks(){

        return booksRepository.findAll();
    }

    public Books findBookById(long id){

        return booksRepository.findById(id).orElseThrow(null);
    }

    public List<Books> findBookByTitle(String title){
        return booksRepository.findByTitle(title);
    }

    public List<Books> findBookByIsbnNo(String isbnNo) {
        return booksRepository.findByIsbnNo(isbnNo);
    }
}

