package ungs.bienestar.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.Movimiento;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long>{

	@Query("select m from Movimiento m where coalesce(:insumo, m.insumo.idInsumos) = m.insumo.idInsumos")
	List<Movimiento> findByParams(@Param("insumo") Long idInsumo);
}
