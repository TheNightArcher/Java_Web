package bg.softuni.musicdb.repository;

import bg.softuni.musicdb.model.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {

    @Query("SELECT SUM(a.copies) FROM  albums a")
    Integer findAlbumsCopies();
}
