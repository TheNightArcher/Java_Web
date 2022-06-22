package bg.softuni.battleships.repository;

import bg.softuni.battleships.model.entity.ShipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ShipRepository extends JpaRepository<ShipEntity,Long> {

}
