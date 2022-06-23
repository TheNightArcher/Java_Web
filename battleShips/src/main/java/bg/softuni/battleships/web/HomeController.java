package bg.softuni.battleships.web;

import bg.softuni.battleships.model.binding.HomeBindingModel;
import bg.softuni.battleships.model.view.UserShipView;
import bg.softuni.battleships.security.CurrentUser;
import bg.softuni.battleships.service.ShipService;
import bg.softuni.battleships.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/home")
    public String homePage(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }

        List<UserShipView> attackers = shipService.findShipsById(currentUser.getId());
        List<UserShipView> defender = shipService.findShipsOfOthers(currentUser.getId());

        List<UserShipView> allShips = shipService.findAll();

        model.addAttribute("attacker", attackers);
        model.addAttribute("defender", defender.stream().filter(d -> !d.getId().equals(currentUser.getId()))
                .collect(Collectors.toList()));

        model.addAttribute("allShips", allShips);

        return "home";
    }


    @PostMapping("/home")
    public String fight(@Valid HomeBindingModel homeBindingModel,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("homeBindingModel", homeBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.homeBindingModel"
                            , bindingResult);

            return "redirect:/";
        }

        shipService.fight(homeBindingModel);

        return "redirect:/";
    }


    @ModelAttribute
    public HomeBindingModel homeBindingModel() {
        return new HomeBindingModel();
    }
}
