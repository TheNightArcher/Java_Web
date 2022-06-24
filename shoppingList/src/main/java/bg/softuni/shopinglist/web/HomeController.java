package bg.softuni.shopinglist.web;

import bg.softuni.shopinglist.model.entity.CategoryNameEnum;
import bg.softuni.shopinglist.security.CurrentUser;
import bg.softuni.shopinglist.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ProductService productService;

    public HomeController(CurrentUser currentUser, ProductService productService) {
        this.currentUser = currentUser;
        this.productService = productService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("foods", productService.findByProductCategoryName(CategoryNameEnum.Food));
        model.addAttribute("drinks", productService.findByProductCategoryName(CategoryNameEnum.Drink));
        model.addAttribute("households", productService.findByProductCategoryName(CategoryNameEnum.Household));
        model.addAttribute("others", productService.findByProductCategoryName(CategoryNameEnum.Other));
        model.addAttribute("totalSumForProducts",productService.totalSum());

        return "home";
    }
}
