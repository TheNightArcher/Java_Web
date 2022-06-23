package bg.softuni.battleships.repository;

import bg.softuni.battleships.model.entity.ShipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShipRepository extends JpaRepository<ShipEntity,Long> {
    List<ShipEntity> findAllByUserId(Long id);

    List<ShipEntity> findAllByUserIdNot(Long userId);

    void deleteById(Long id);

    @Query("SELECT s FROM  ships  s " +
            "ORDER BY s.name DESC , s.health DESC , s.power DESC ")
    List<ShipEntity> findAllShipsOrderByDesc();
}
