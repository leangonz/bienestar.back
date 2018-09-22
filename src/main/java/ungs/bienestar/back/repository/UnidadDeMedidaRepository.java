package ungs.bienestar.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.UnidadDeMedida;

@Repository
public interface UnidadDeMedidaRepository extends JpaRepository<UnidadDeMedida, Long>{

}
