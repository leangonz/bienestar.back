package ungs.bienestar.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.Motivo;

@Repository
public interface MotivoRepository extends JpaRepository<Motivo, Long>{

}
