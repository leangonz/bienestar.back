package ungs.bienestar.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.CategoriaSecundaria;

@Repository
public interface CategoriaSecundariaRepository extends JpaRepository<CategoriaSecundaria, Long>{

}
