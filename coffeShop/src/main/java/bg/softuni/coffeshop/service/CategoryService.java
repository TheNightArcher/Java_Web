package bg.softuni.coffeshop.service;

import bg.softuni.coffeshop.model.CategoryEntity;
import bg.softuni.coffeshop.model.CategoryNameEnum;
import bg.softuni.coffeshop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void initCategories() {
        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {

                    CategoryEntity category = new CategoryEntity();
                    category.setName(categoryNameEnum);

                    switch (categoryNameEnum) {
                        case CAKE -> category.setNeededTime(10);
                        case COFFEE -> category.setNeededTime(2);
                        case DRINK -> category.setNeededTime(1);
                        case OTHER -> category.setNeededTime(5);
                    }

                    categoryRepository.save(category);
                });
    }

    public CategoryEntity findByCategoryEnum(CategoryNameEnum categoryEntity) {
        return categoryRepository.findByName(categoryEntity).orElse(null);
    }
}
