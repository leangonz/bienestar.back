package ungs.bienestar.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{

}