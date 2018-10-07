package ungs.bienestar.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long>{

}
