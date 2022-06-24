package bg.softuni.shopinglist.repository;

import bg.softuni.shopinglist.model.entity.CategoryNameEnum;
import bg.softuni.shopinglist.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByCategoryName(CategoryNameEnum food);

    @Query("SELECT SUM(p.price) FROM products  p")
    BigDecimal findMyProductsSum();
}
