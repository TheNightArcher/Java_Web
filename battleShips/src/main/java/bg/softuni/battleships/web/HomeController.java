package bg.softuni.battleships.web;

import bg.softuni.battleships.model.view.UserShipView;
import bg.softuni.battleships.security.CurrentUser;
import bg.softuni.battleships.service.ShipService;
import bg.softuni.battleships.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final UserService userService;
    private final ShipService shipService;

    public HomeController(CurrentUser currentUser, UserService userService, ShipService shipService) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.shipService = shipService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }

      List<UserShipView> attackers = userService.findShipsById(currentUser.getId());
        model.addAttribute("attackers", attackers);


        return "home";
    }
}
