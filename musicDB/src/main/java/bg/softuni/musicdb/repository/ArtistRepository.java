package bg.softuni.musicdb.repository;

import bg.softuni.musicdb.model.entity.ArtistEntity;
import bg.softuni.musicdb.model.entity.ArtistNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {
    Optional<ArtistEntity> findByName(ArtistNameEnum name);
}
