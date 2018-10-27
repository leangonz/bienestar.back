package ungs.bienestar.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.HistorialDescarte;

@Repository
public interface HistorialDescarteRepository extends JpaRepository<HistorialDescarte, Long>{

}
