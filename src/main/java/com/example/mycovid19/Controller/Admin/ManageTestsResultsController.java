package com.example.mycovid19.Controller.Admin;

import com.example.mycovid19.Model.Test;
import com.example.mycovid19.Model.TestResult;
import com.example.mycovid19.Repo.Admin.ManageTestsRepo;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ManageTestsResultsController {

  @Autowired
  private ManageTestsRepo manageTestsRepo;

  @GetMapping("/admin/all_tests_results")
  public String adminResults(Model model) throws SQLException {
    model.addAttribute("adminResults", manageTestsRepo.fetchAllTestsResults());
    return "admin/all_tests_results";
  }

  @PostMapping(value = "/update_result", params="update")
  public String updateResult(TestResult testResult) {
    manageTestsRepo.updateResult(testResult);
    return "redirect:/admin/all_tests_results";
  }
}