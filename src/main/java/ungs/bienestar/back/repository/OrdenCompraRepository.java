package ungs.bienestar.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.OrdenCompraHeader;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompraHeader, Long>{

	@Query("select och from OrdenCompraHeader och where coalesce(:proveedor, och.proveedor.id) = och.proveedor.id and coalesce(:factura, och.factura) = och.factura")
	List<OrdenCompraHeader> findByParams(@Param("proveedor") Long idProveedor, @Param("factura") String factura);

}
