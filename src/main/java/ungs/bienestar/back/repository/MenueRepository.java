package ungs.bienestar.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.Menue;

@Repository
public interface MenueRepository extends JpaRepository<Menue, Long>{

	@Query("select m from Menue m where coalesce(:menu, m.idMenues) = m.idMenues")
	List<Menue> findByParams(@Param("menu") Long idMenu);

}
