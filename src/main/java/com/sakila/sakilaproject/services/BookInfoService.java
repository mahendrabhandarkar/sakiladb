package com.sakila.sakilaproject.services;

import com.sakila.sakilaproject.domain.BookInfo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class BookInfoService {

    public Flux<BookInfo> getBooks() {
        List<BookInfo> books = Arrays.asList(
                new BookInfo(1,"Book One","Author One","12121212"),
                new BookInfo(2,"Book Two","Author Two","42342343"),
                new BookInfo(3,"Book Three","Author Three","23425444")
        );

        return Flux.fromIterable(books);
    }

    public Mono<BookInfo> getBookById(long bookId) {
        BookInfo book = new BookInfo(bookId, "Book One","Author One","12121212");

        return Mono.just(book);
    }
}
