package bg.softuni.shopinglist.web;

import bg.softuni.shopinglist.security.CurrentUser;
import bg.softuni.shopinglist.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  private final CurrentUser currentUser;
  private final ProductService productService;

  public HomeController(CurrentUser currentUser, ProductService productService) {
    this.currentUser = currentUser;
    this.productService = productService;
  }

  @GetMapping("/")
    public String homePage(Model model){
    if (currentUser.getId() == null){
      return "index";


    }

    return "home";
  }
}
