/**
 * 
 */
package com.mbh.swaggerspringboot.apis;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mbh.swaggerspringboot.exceptions.BookNotFoundException;
import com.mbh.swaggerspringboot.models.Book;
import com.mbh.swaggerspringboot.services.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Book API
 * 
 * @author amineboufatah
 *
 */
@RestController
@RequestMapping("api")
public class BookApi {

  /** Business Layer Book Service **/
  @Autowired
  private BookService bookService;


  @RequestMapping(method = RequestMethod.GET, value = "book/id/{id}")
  @ApiOperation(value = "Finds book by id",
      notes = "Please provide an id in order to retrieve a book", response = Book.class)
  public Book getBookById(@ApiParam(value = "The book identifier should be an integer",
      example = "1") @PathVariable("id") int id) throws BookNotFoundException {
    return bookService.getBookById(id);
  }

  @RequestMapping(method = RequestMethod.GET, value = "books")
  @ApiOperation(value = "Gets all of the books", notes = "There's nothing to provide here",
      response = List.class)
  public List<Book> getAllBooks() {
    return bookService.getAllBooks();
  }

  @RequestMapping(method = RequestMethod.GET, value = "book/title/{title}")
  @ApiOperation(value = "Finds book by its title",
      notes = "Please provide a title in order to retrieve a book", response = Book.class)
  public Book getBookByTitle(
      @ApiParam(value = "It's the book's title",
          example = "Harry Potter") @PathVariable("title") String title)
      throws BookNotFoundException {
    return bookService.getBookByTitle(title);
  }

  @RequestMapping(method = RequestMethod.GET, value = "book/year/{year}")
  @ApiOperation(value = "Finds books published for a specific year",
      notes = "the parameter is an integer, example: 2018 ", response = Book.class)
  public List<Book> getAllBooksByYear(@ApiParam(value = "The year when the book was published",
      example = "2015") @PathVariable("year") int year) {
    return bookService.getAllBooksByYear(year);
  }

  @RequestMapping(method = RequestMethod.POST, value = "books")
  @ApiOperation(value = "Adds a new book to the store", notes = "the parameter is the object Book",
      response = Void.class)
  public void addBook(@ApiParam("The object to be added to the store") @RequestBody Book book) {
    bookService.addBook(book);
  }


  @RequestMapping(method = RequestMethod.PUT, value = "books")
  @ApiOperation(value = "Update an existing book",
      notes = "It's essential to provide the book id. Only the author and the year can be updated",
      response = Void.class)
  public void updateBook(
      @ApiParam("The parameter is the object Book that will be updated") @RequestBody Book book) {
    bookService.updateBook(book);
  }

}
