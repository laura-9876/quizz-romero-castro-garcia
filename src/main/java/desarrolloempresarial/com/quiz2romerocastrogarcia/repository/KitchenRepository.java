package desarrolloempresarial.com.quiz2romerocastrogarcia.repository;

import desarrolloempresarial.com.quiz2romerocastrogarcia.entity.Chef;
import desarrolloempresarial.com.quiz2romerocastrogarcia.entity.Kitchen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KitchenRepository extends JpaRepository<Kitchen, Long> {
    List<Kitchen> findByChef(Chef chef);
}