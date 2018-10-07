package ungs.bienestar.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.OrdenCompraHeader;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompraHeader, Long>{

}
