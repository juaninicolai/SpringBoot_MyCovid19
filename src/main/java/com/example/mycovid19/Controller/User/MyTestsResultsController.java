package com.example.mycovid19.Controller.User;

import com.example.mycovid19.Repo.User.MyTestsResultsRepo;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyTestsResultsController {

  @Autowired
  private MyTestsResultsRepo myTestsResultsRepo;

  @GetMapping("/user/my_results")
  public String results(Model model) throws SQLException {
    model.addAttribute("myTestsResults", myTestsResultsRepo.joinTestsResults());
    return "/user/my_results";
  }
}
