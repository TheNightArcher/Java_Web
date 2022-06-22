package bg.softuni.battleships.service;

import bg.softuni.battleships.model.entity.CategoryEntity;
import bg.softuni.battleships.model.entity.CategoryNameEnum;
import bg.softuni.battleships.repository.CategoryRepository;
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

                    categoryRepository.save(category);
                });
    }

    public CategoryEntity findByCategoryEnum(CategoryNameEnum category) {
        return categoryRepository.findByName(category)
                .orElse(null);
    }
}
