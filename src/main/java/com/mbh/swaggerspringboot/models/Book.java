/**
 * 
 */
package com.mbh.swaggerspringboot.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author amineboufatah
 *
 */
@ApiModel("Book object")
public class Book {

  @ApiModelProperty("Id that identifies the book")
  private int id;

  @ApiModelProperty("The author who wrote the book")
  private String author;

  @ApiModelProperty("The title of the book")
  private String title;

  @ApiModelProperty("The year when the book was published")
  private int year;

  public Book() {

  }

  public Book(int id, String author, String title, int year) {
    this.id = id;
    this.author = author;
    this.title = title;
    this.year = year;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

}
