package ungs.bienestar.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.Ciudad;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long>{

}
