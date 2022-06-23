package bg.softuni.shopinglist.service;

import bg.softuni.shopinglist.model.entity.ProductEntity;
import bg.softuni.shopinglist.model.service.ProductServiceModel;
import bg.softuni.shopinglist.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    public void addProduct(ProductServiceModel productServiceModel) {

        ProductEntity product = modelMapper.map(productServiceModel, ProductEntity.class);
        product.setCategory(categoryService.findByCategoryName(productServiceModel.getCategory()));

        productRepository.save(product);
    }
}
