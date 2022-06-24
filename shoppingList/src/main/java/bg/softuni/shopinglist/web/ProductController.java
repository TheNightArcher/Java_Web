package bg.softuni.shopinglist.web;

import bg.softuni.shopinglist.model.binding.UserProductBindingModel;
import bg.softuni.shopinglist.model.service.ProductServiceModel;
import bg.softuni.shopinglist.service.ProductService;
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
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/product-add")
    public String addProduct() {

        return "product-add";
    }

    @PostMapping("/product-add")
    public String addProductConfirm(@Valid UserProductBindingModel userProductBindingModel,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("userProductBindingModel", userProductBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userProductBindingModel"
                            , bindingResult);

            return "redirect:/product-add";
        }

        productService
                .addProduct(modelMapper.map(userProductBindingModel, ProductServiceModel.class));

        return "redirect:/";
    }


     @GetMapping("/product-add/buy/{id}")
    public String buyProduct(@PathVariable Long id){
        productService.buyProduct(id);

        return "redirect:/";
     }


    @GetMapping("/product-add/buy-all")
    public String buyProduct(){
        productService.buyAllProduct();

        return "redirect:/";
    }

    @ModelAttribute
    public UserProductBindingModel userProductBindingModel() {
        return new UserProductBindingModel();
    }
}
