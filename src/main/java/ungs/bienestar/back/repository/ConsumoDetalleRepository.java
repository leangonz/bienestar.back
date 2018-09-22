package ungs.bienestar.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.ConsumoDetalle;

@Repository
public interface ConsumoDetalleRepository extends JpaRepository<ConsumoDetalle, Long>{

}
