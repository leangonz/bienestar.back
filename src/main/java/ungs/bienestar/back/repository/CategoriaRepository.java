package ungs.bienestar.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.Categoria;
import ungs.bienestar.back.entity.CategoriaId;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, CategoriaId>{

}
