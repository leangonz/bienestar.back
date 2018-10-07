package ungs.bienestar.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.CategoriaCompra;

@Repository
public interface CategoriaCompraRepository extends JpaRepository<CategoriaCompra, Long>{

}
