package ungs.bienestar.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.TipoDeMenue;

@Repository
public interface TipoDeMenueRepository extends JpaRepository<TipoDeMenue, Long>{

}
