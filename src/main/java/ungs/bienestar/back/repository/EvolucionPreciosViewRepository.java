package ungs.bienestar.back.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.view.EvolucionPreciosId;
import ungs.bienestar.back.entity.view.EvolucionPreciosView;

@Repository
public interface EvolucionPreciosViewRepository extends JpaRepository<EvolucionPreciosView, EvolucionPreciosId>{

	@Query("select epv from EvolucionPreciosView epv where coalesce(:idInsumo, epv.idInsumo) = epv.idInsumo and coalesce(:desde, epv.fecha) <= epv.fecha and coalesce(:hasta, epv.fecha) >= epv.fecha")
	List<EvolucionPreciosView> findBy(@Param("idInsumo") Long idInsumo, @Param("desde") Date fechaDesde, @Param("hasta") Date fechaHasta);
}
