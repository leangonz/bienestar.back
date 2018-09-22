package ungs.bienestar.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.Menue;

@Repository
public interface MenueRepository extends JpaRepository<Menue, Long>{

}
