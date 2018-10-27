package ungs.bienestar.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.view.HistorialDescarteId;
import ungs.bienestar.back.entity.view.HistorialDescarteView;

@Repository
public interface HistorialDescarteViewRepository  extends JpaRepository<HistorialDescarteView, HistorialDescarteId>{

	List<HistorialDescarteView> findByAnio(Integer anio);
}
