package ungs.bienestar.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{

	@Query("select p from Proveedor p where coalesce(:proveedor, p.idProveedor) = p.idProveedor")
	List<Proveedor> findByParams(@Param("proveedor") Long idProveedor);
}
