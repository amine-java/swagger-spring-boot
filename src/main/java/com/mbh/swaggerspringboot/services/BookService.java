/**
 * 
 */
package com.mbh.swaggerspringboot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.mbh.swaggerspringboot.exceptions.BookNotFoundException;
import com.mbh.swaggerspringboot.models.Book;

/**
 * Business Layer: BookService - Retrieving, adding and updating books.
 * 
 * @author amineboufatah
 *
 */
@Service
public class BookService {

  /** We use a static list for simplicity sake. No DB here **/
  private static List<Book> books = new ArrayList<>();

  static {
    books.add(new Book(1, "Blane John", "Once upon a time", 2015));
    books.add(new Book(2, "Jimmy Burton", "The sheep and the girl", 2012));
    books.add(new Book(3, "Harry James", "The president is missing", 2019));
    books.add(new Book(4, "Dan Blaze", "Shen's story ", 2015));
  }

  /**
   * Returns a book by id
   * 
   * @param id
   * @return Book
   * @throws BookNotFoundException
   */
  public Book getBookById(int id) throws BookNotFoundException {
    Optional<Book> book = books.stream().filter(p -> p.getId() == id).findFirst();
    return book
        .orElseThrow(() -> new BookNotFoundException("The book with id " + id + " does not exist"));
  }

  /**
   * Returns all of the books
   * 
   * @return List of books
   */
  public List<Book> getAllBooks() {
    return books;
  }

  /**
   * Returns all of the books published in a specific year.
   * 
   * @param year
   * @return List of books
   */
  public List<Book> getAllBooksByYear(int year) {
    return books.stream().filter(p -> p.getYear() == year).collect(Collectors.toList());
  }

  /**
   * Returns a book by title
   * 
   * @param title
   * @return
   * @throws BookNotFoundException if the book does not exist.
   */
  public Book getBookByTitle(String title) throws BookNotFoundException {
    Optional<Book> book = books.stream().filter(p -> p.getTitle().equals(title.trim())).findFirst();
    return book.orElseThrow(
        () -> new BookNotFoundException("The book with title " + title + " does not exist"));
  }

  /**
   * Add a new book to the store.
   * 
   * @param book
   */
  public void addBook(Book book) {
    books.add(book);
  }

  /**
   * Updates an existing book. The update is only done on the author and/or the year.
   * 
   * @param book
   */
  public void updateBook(Book updatedBook) {
    Optional<Book> book = books.stream().filter(p -> p.getId() == updatedBook.getId()).findFirst();
    if (book.isPresent()) {
      book.get().setAuthor(updatedBook.getAuthor());
      book.get().setYear(updatedBook.getYear());
    }
  }
}
