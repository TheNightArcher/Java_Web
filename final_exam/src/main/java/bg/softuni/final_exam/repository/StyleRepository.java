package bg.softuni.final_exam.repository;

import bg.softuni.final_exam.model.entity.StyleEntity;
import bg.softuni.final_exam.model.entity.StyleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StyleRepository extends JpaRepository<StyleEntity,Long> {
    Optional<StyleEntity> findByStyleName(StyleNameEnum style);
}
