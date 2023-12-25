package com.example.Library_Management_System.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "library_books", uniqueConstraints = {@UniqueConstraint(columnNames = "ISBN_No")})
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;


    @Column(name = "publication_year")
    @Digits(integer = 4, fraction = 0, message = "Publication year must be a 4-digit number")    private Long publicationYear;

    private String author;


    @Column(name = "ISBN_No")
    @Pattern(regexp = "^[a-zA-Z]{3}\\d{3}$", message = "ISBN must be 3 letters followed by 3 digits")
    //@Pattern(regexp = "[a-zA-Z]{3}[0-9]{3}", message = "Please follow naming pattern '***-###', where * are letters and # are numbers")
    private String isbnNo;


    public Books(){};

    public Books(String title, Long publicationYear, String author, String isbnNo) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.author = author;
        this.isbnNo = isbnNo;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Long publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbnNo;
    }

    public void setIsbn(String isbn) {
        this.isbnNo = isbnNo;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", author='" + author + '\'' +
                ", isbn='" + isbnNo + '\'' +
                '}';
    }
}

