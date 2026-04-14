package desarrolloempresarial.com.quiz2romerocastrogarcia.repository;

import desarrolloempresarial.com.quiz2romerocastrogarcia.entity.Chef;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChefRepository extends JpaRepository<Chef, Long> {
    Optional<Chef> findByUsername(String username);
}