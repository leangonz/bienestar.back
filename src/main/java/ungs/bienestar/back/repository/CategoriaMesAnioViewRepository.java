package ungs.bienestar.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.view.CategoriaMesAnioId;
import ungs.bienestar.back.entity.view.CategoriaMesAnioView;

@Repository
public interface CategoriaMesAnioViewRepository extends JpaRepository<CategoriaMesAnioView, CategoriaMesAnioId>{

	List<CategoriaMesAnioView> findByAnio(Integer anio);
}
