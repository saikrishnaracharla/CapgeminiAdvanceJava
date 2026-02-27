package com.library;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Long id, String title, String author) {
        bookRepository.save(new Book(id, title, author));
        System.out.println("Book Added Successfully");
    }

    public List<Book> getAvailableBooks() {
        return bookRepository.findAll().stream().filter(Book::isAvailable).toList();
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id);
    }
}
