package com.example.mycovid19.User.Controller;

import com.example.mycovid19.User.Repo.BookTestRepo;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookTestController {

  @Autowired
  private BookTestRepo bookTestRepo;

  @GetMapping("templates/User/book_tests.html")
  public String test(Model model) throws SQLException {
    model.addAttribute("tests", bookTestRepo.fetchAll());
    return "templates/User/test.html";
  }

  /*@PostMapping("/createTest")
  public String addTest(Test test){
    testRepo.addTest(test);
    return "redirect:/test";
  }*/

  /*@PostMapping(value = "/editTest", params="cancel")
  public String cancelTest(@RequestParam("test_id") int test_id){
    testRepo.cancelTest(test_id);
    return "redirect:/test";
  }*/

  @PostMapping(value = "/edit_book_test", params="update")
  public String bookTest(@RequestParam("test_id") int test_id){
    bookTestRepo.bookTest(test_id);
    return "redirect:templates/User/book_tests.html";
  }

}