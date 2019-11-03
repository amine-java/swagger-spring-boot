/**
 * 
 */
package com.mbh.swaggerspringboot.apis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author amineboufatah
 *
 */
@RestController
public class HomeApi {


  @RequestMapping(value = "/")
  public String home() {

    StringBuilder home = new StringBuilder();
    home.append("<h1>Book API</h1>").append("<br>").append(
        "<p>I have coded this API for the purpose of testing swagger-ui implementation using Spring Boot</p>")
        .append(
            "<p>It's a simple in-memory API that allows you retrieve, create and update books</p>")
        .append("Please go to the swagger html page to test the api: ")
        .append("<a href='swagger-ui.html'>Click here</a>");

    return home.toString();
  }
}
