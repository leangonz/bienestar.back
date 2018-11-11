package ungs.bienestar.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.view.GrupoEtarioId;
import ungs.bienestar.back.entity.view.GrupoEtarioView;

@Repository
public interface GrupoEtarioViewRepository extends JpaRepository<GrupoEtarioView, GrupoEtarioId>{

	List<GrupoEtarioView> findByAnio(Integer anio);
}
