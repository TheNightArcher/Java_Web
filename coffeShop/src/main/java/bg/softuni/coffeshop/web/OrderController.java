package bg.softuni.coffeshop.web;

import bg.softuni.coffeshop.model.binding.UserOrderBindingModel;
import bg.softuni.coffeshop.model.service.OrderServiceModel;
import bg.softuni.coffeshop.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class OrderController {

    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/order-add")
    public String orderAdd() {

        return "order-add";
    }

    @PostMapping("/order-add")
    public String orderAddConfirm(@Valid UserOrderBindingModel userOrderBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userOrderBindingModel", userOrderBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userOrderBindingModel"
                            , bindingResult);

            return "redirect:/order-add";
        }

        orderService
                .addOrder(modelMapper.map(userOrderBindingModel, OrderServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/orders/ready/{id}")
    public String ordersReady(@PathVariable Long id){
        orderService.readyOrder(id);
        return "redirect:/";
    }

    @ModelAttribute
    public UserOrderBindingModel orderBindingModel() {
        return new UserOrderBindingModel();
    }
}
