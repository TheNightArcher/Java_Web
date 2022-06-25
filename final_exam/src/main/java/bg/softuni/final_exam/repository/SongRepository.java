package bg.softuni.final_exam.repository;

import bg.softuni.final_exam.model.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<SongEntity, Long> {

    @Query("SELECT s FROM songs  s " +
            "WHERE s.style.styleName = :name")
    List<SongEntity> findByStyleSName(String name);
}
