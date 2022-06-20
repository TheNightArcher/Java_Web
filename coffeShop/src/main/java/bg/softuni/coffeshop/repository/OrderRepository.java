package bg.softuni.coffeshop.repository;

import bg.softuni.coffeshop.model.OrderEntity;
import bg.softuni.coffeshop.model.view.OrderViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {

    List<OrderEntity> findAllByOrderByPriceDesc();
}
