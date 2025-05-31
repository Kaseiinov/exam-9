package kg.attractor.exam9.repository;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import kg.attractor.exam9.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String userEmail);

    boolean existsUserByEmail(@NotBlank @Email String email);
}
