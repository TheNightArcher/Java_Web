package bg.softuni.coffeshop.repository;

import bg.softuni.coffeshop.model.CategoryEntity;
import bg.softuni.coffeshop.model.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    Optional<CategoryEntity> findByName(CategoryNameEnum name);
}
