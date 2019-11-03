/**
 * 
 */
package com.mbh.swaggerspringboot.exceptions;

/**
 * This exception is thrown when a book does not exist.
 * 
 * @author amineboufatah
 *
 */
public class BookNotFoundException extends Exception {

  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = 2752547901348867855L;

  /**
   * Constructor
   * 
   * @param message
   */
  public BookNotFoundException(String message) {
    super(message);
  }

}
