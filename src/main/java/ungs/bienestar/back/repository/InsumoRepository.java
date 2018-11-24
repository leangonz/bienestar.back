package ungs.bienestar.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.Insumo;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Long>{

	@Query("select i from Insumo i where coalesce(:insumo, i.idInsumos) = i.idInsumos")
	List<Insumo> findByParams(@Param("insumo") Long idInsumo);
}
