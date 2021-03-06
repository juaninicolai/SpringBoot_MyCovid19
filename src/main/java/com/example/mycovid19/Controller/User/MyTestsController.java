package com.example.mycovid19.Controller.User;

import com.example.mycovid19.Model.UserCredentials;
import com.example.mycovid19.Repo.User.MyTestsRepo;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyTestsController {

  @Autowired
  private MyTestsRepo myTestsRepo;

  @GetMapping("/user/my_tests")
  public String MyTests(Model model, @AuthenticationPrincipal UserCredentials userCredentials) throws SQLException {
    model.addAttribute("mytests", myTestsRepo.fetchAll(userCredentials.getId()));
    return "/user/my_tests";
  }

  @PostMapping(value = "/edit_my_tests", params = "cancel")
  public String cancelTest(@RequestParam("test_id") int test_id) {
    myTestsRepo.cancelTest(test_id);
    return "redirect:/user/my_tests";
  }

}
