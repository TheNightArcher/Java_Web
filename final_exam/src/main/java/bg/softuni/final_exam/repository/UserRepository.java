package bg.softuni.final_exam.repository;

import bg.softuni.final_exam.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByUsernameAndPassword(String username, String password);

    Optional<UserEntity> findById(Long id);
}
