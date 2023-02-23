package com.sakila.sakilaproject.services;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import reactor.core.publisher.Flux;
import com.sakila.sakilaproject.domain.Book;

class BookServiceTest {

    private BookInfoService bookInfoService
            = new BookInfoService();

    private ReviewService reviewService
            = new ReviewService();

    private BookService bookService
            = new BookService(bookInfoService,reviewService);

    @Test
    void getBooks() {
        Flux<Book> books = bookService.getBooks();
        StepVerifier.create(books)
                .assertNext(book -> {
                    assertEquals("Book One",book.getBookInfo().getTitle());
                    assertEquals(2,book.getReviews().size());
                })
                .assertNext(book -> {
                    assertEquals("Book Two",book.getBookInfo().getTitle());
                    assertEquals(2,book.getReviews().size());
                })
                .assertNext(book -> {
                    assertEquals("Book Three",book.getBookInfo().getTitle());
                    assertEquals(2,book.getReviews().size());
                })
                .verifyComplete();

    }

    @Test
    void getBookById() {
        Mono<Book> book = bookService.getBookById(1).log();
        StepVerifier.create(book)
                .assertNext(b -> {
                    assertEquals("Book One",b.getBookInfo().getTitle());
                    assertEquals(2,b.getReviews().size());
                })
                .verifyComplete();
    }
}