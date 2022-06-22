package bg.softuni.battleships.web;

import bg.softuni.battleships.model.binding.ShipAddBindingModel;
import bg.softuni.battleships.model.service.ShipServiceModel;
import bg.softuni.battleships.service.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ShipController {

    private final ShipService shipService;
    private final ModelMapper modelMapper;

    public ShipController(ShipService shipService, ModelMapper modelMapper) {
        this.shipService = shipService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/ship-add")
    public String addShip() {
        return "ship-add";
    }

    @PostMapping("/ship-add")
    public String addShipConfirm(@Valid ShipAddBindingModel shipAddBindingModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("shipAddBindingModel", shipAddBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel"
                            , bindingResult);

            return "redirect:/ship-add";
        }

        shipService.addShip(modelMapper.map(shipAddBindingModel, ShipServiceModel.class));

        return "redirect:/";
    }

    @ModelAttribute
    public ShipAddBindingModel shipAddBindingModel() {
        return new ShipAddBindingModel();
    }
}
