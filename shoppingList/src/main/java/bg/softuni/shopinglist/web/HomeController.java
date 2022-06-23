package bg.softuni.shopinglist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/")
    public String homePage(){
      return "index";
  }

  @GetMapping("/home")
  public String home(){
    return "home";
  }

}
