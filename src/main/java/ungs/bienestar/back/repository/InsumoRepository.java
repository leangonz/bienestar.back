package ungs.bienestar.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.Insumo;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Long>{

}
