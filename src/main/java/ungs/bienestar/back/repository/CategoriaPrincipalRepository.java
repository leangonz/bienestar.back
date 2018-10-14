package ungs.bienestar.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.CategoriaPrincipal;

@Repository
public interface CategoriaPrincipalRepository extends JpaRepository<CategoriaPrincipal, Long>{

}
