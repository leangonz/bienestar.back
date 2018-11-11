package ungs.bienestar.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ungs.bienestar.back.entity.MomentoDelDia;

@Repository
public interface MomentoDelDiaRepository extends JpaRepository<MomentoDelDia, Long>{

}
