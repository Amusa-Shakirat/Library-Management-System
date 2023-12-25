package com.example.Library_Management_System.controller;

import com.example.Library_Management_System.model.Books;
import com.example.Library_Management_System.model.BorrowedBooks;
import com.example.Library_Management_System.model.Users;
import com.example.Library_Management_System.service.BooksService;
import com.example.Library_Management_System.service.BorrowedBooksService;
import com.example.Library_Management_System.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController {


    @Autowired
    private BooksService booksService;

    @Autowired
    public BorrowedBooksService borrowedBooksService;

    @PostMapping("/id")
    public ResponseEntity<Books> getBookById(@PathVariable long id){
        return new ResponseEntity<>(booksService.findBookById(id), HttpStatus.CREATED);
    }

    @GetMapping("/title/{title}")
    public List<Books> getByTitle(@PathVariable String title){

        return booksService.findBookByTitle(title);
    }

    @GetMapping("/isbn/{isbnNo}")
    public List<Books> getByISBNNo( @PathVariable String isbnNo){
        return booksService.findBookByIsbnNo(isbnNo);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Books>> getAllBooks(){

        return new ResponseEntity<>(booksService.getAllBooks(), HttpStatus.OK);
    }

    @PostMapping("/addBook")
    public ResponseEntity<Books> addBook(@RequestBody @Valid Books books) {

        return new ResponseEntity<>(booksService.addBook(books), HttpStatus.CREATED);
    }

    @PostMapping("/borrow")
    public ResponseEntity <BorrowedBooks> borrowBook(@PathVariable @Valid BorrowedBooks borrowedBooks){
        return new ResponseEntity<>(borrowedBooksService.addBorrowedBooks(borrowedBooks), HttpStatus.CREATED);
    }

    @GetMapping("/borrowed/{id}")
    public ResponseEntity<BorrowedBooks> getBorrowedBooksById(@PathVariable long id){
        return new ResponseEntity<>(borrowedBooksService.findBorrowedBooksById(id), HttpStatus.OK);
    }

    @GetMapping("/borrowed-bookAuthor/{id}")
    public ResponseEntity<BorrowedBooks> getBorrowedBooksByAuthor(@PathVariable String bookAuthor){
        return new ResponseEntity<>(borrowedBooksService.findBorrowedBooksByAuthorName(bookAuthor), HttpStatus.OK);
    }

    @GetMapping("/borrowed-bookName/{id}")
    public ResponseEntity<BorrowedBooks> getBorrowedBooksByName(@PathVariable String bookName){
        return new ResponseEntity<>(borrowedBooksService.findBorrowedBooksByBookName(bookName), HttpStatus.OK);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Books> deleteBook(@PathVariable long id) {

        return ResponseEntity.ok(booksService.deleteBook(id));
    }

}
