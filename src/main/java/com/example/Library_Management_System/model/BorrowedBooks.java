package com.example.Library_Management_System.model;


import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "borrowed_books")
public class BorrowedBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users users;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Books books;

    @Column(name = "book_name")
    @Length(min = 4, max = 35, message = "The character of the book name not satisfied")
    private String bookName;

    @Column(name = "book-author")
    @Length(min = 6, max = 20, message = "The character of the author name not satisfied")
    private String bookAuthor;

    public BorrowedBooks() {
    }

    public BorrowedBooks(Users users, Books books, String bookName, String bookAuthor) {
        this.users = users;
        this.books = books;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }

    public Long getId() {

        return id;
    }

    public Users getUsers() {

        return users;
    }

    public void setUsers(Users users) {

        this.users = users;
    }

    public Books getBooks() {

        return books;
    }

    public void setBooks(Books books) {

        this.books = books;
    }

    public String getBookName() {

        return bookName;
    }

    public void setBookName(String bookName) {

        this.bookName = bookName;
    }

    public String getAuthorName() {

        return bookAuthor;
    }

    public void setAuthorName(String authorName) {

        this.bookAuthor = authorName;
    }


    @Override
    public String toString() {
        return "BorrowedBooks{" +
                "id=" + id +
                ", users=" + users +
                ", books=" + books +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + bookAuthor + '\'' +
                '}';
    }
}
