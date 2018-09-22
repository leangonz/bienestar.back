package ungs.bienestar.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.Consumo;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Long>{

}
